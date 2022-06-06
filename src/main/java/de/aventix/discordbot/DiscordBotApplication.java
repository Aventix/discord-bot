package de.aventix.discordbot;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import de.aventix.discordbot.command.CommandController;
import de.aventix.discordbot.config.ConfigRegistrationProcedure;
import de.aventix.discordbot.config.entry.DiscordApplicationConfig;
import de.aventix.discordbot.filter.TypeFilter;
import de.aventix.discordbot.listener.DiscordListener;
import de.aventix.discordbot.searcher.TypeSearcher;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* This class was created by @Aventix on 05.06.2022 at 23:34. */
public class DiscordBotApplication {
  public static void main(String[] args) {
    try {

      Injector injector =
          Guice.createInjector(
              new AbstractModule() {
                protected void configure() {
                  this.bind(ExecutorService.class).toInstance(Executors.newCachedThreadPool());
                  this.bind(ClassLoader.class).toInstance(this.getClass().getClassLoader());
                }
              });

      injector
          .getInstance(ConfigRegistrationProcedure.class)
          .load(DiscordBotApplication.class.getPackage().getName())
          .getInstance(CommandController.class)
          .load(DiscordBotApplication.class.getPackage().getName());

      DiscordApplicationConfig config = injector.getInstance(DiscordApplicationConfig.class);

      if (config.getBotToken() == null || config.getBotToken().isEmpty()) {
        System.out.println("Can't load Bot, there is no valid Bot Token!");
        return;
      }

      JDABuilder discordBuilder =
          JDABuilder.createDefault(
              config.getBotToken()).enableIntents(
                  GatewayIntent.GUILD_MEMBERS,
                  GatewayIntent.GUILD_PRESENCES);

      injector
          .getInstance(TypeSearcher.class)
          .filter(
              new String[] {DiscordBotApplication.class.getPackage().getName()},
              TypeFilter.annotatedWith(DiscordListener.class),
              TypeFilter.subClassOf(ListenerAdapter.class))
          .forEach(
              clazz -> {
                discordBuilder.addEventListeners(injector.getInstance(clazz));
                System.out.println("Successfully registered Listener: " + clazz.getSimpleName());
              });

      JDA jda = discordBuilder.build();

    } catch (LoginException e) {
      throw new RuntimeException(e);
    }
  }
}

package de.aventix.discordbot.listener;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import de.aventix.discordbot.MessageController;
import de.aventix.discordbot.config.entry.DiscordApplicationConfig;
import de.aventix.discordbot.config.entry.MessageConfiguration;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/* This class was created by @Aventix on 06.06.2022 at 01:37. */

@Singleton
@DiscordListener
public class WelcomeLeaveListener extends ListenerAdapter {
  private final MessageController messageController;
  private final DiscordApplicationConfig config;
  private final MessageConfiguration messages;

  @Inject
  public WelcomeLeaveListener(
      MessageController messageController,
      DiscordApplicationConfig config,
      MessageConfiguration messages) {
    this.messageController = messageController;
    this.config = config;
    this.messages = messages;
  }

  @Override
  public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
    User user = event.getUser();
    TextChannel channel;

    if ((channel = event.getGuild().getTextChannelById(this.config.getWelcomeLeaveMessageChannel()))
        != null) {
      channel
          .sendMessage(
              this.messageController.getMessage(
                  this.messages.getWelcomeMessage(),
                  user.getAsMention(),
                  user.getName(),
                  user.getAsTag()))
          .queue();
    }
  }

  @Override
  public void onGuildMemberRemove(@NotNull GuildMemberRemoveEvent event) {
    User user = event.getUser();
    TextChannel channel;

    if ((channel = event.getGuild().getTextChannelById(this.config.getWelcomeLeaveMessageChannel()))
        != null) {
      user.getAsMention();
      channel
          .sendMessage(
              this.messageController.getMessage(
                  this.messages.getLeaveMessage(),
                  user.getAsMention(),
                  user.getName(),
                  user.getAsTag()))
          .queue();
    }
  }
}

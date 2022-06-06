package de.aventix.discordbot.command;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import de.aventix.discordbot.filter.TypeFilter;
import de.aventix.discordbot.searcher.TypeSearcher;

import java.util.Map;

/* This class was created by @Aventix on 06.06.2022 at 00:44. */
@Singleton
public class CommandController {
  private final Map<CommandHandler, String> registeredCommands = Maps.newHashMap();
  private final TypeSearcher typeSearcher;
  private final Injector injector;

  @Inject
  public CommandController(TypeSearcher typeSearcher, Injector injector) {
    this.typeSearcher = typeSearcher;
    this.injector = injector;
  }

  public void load(Object... args) {
    Preconditions.checkNotNull(args[0]);

    this.typeSearcher
        .filter(
            new String[] {args[0].toString()},
            TypeFilter.annotatedWith(Command.class),
            TypeFilter.subClassOf(CommandHandler.class))
        .forEach(
            clazz -> {
              Command command = clazz.getAnnotation(Command.class);
              System.out.println("Successfully registered command: " + command.value());
              this.registerCommand((CommandHandler) this.injector.getInstance(clazz), command);
            });

    this.typeSearcher
        .filter(
            new String[] {args[0].toString()},
            TypeFilter.annotatedWith(SubCommand.class),
            TypeFilter.subClassOf(CommandHandler.class))
        .forEach(
            clazz -> {
              CommandHandler subCommand = (CommandHandler) this.injector.getInstance(clazz);
              SubCommand subCommandAnnotation = clazz.getAnnotation(SubCommand.class);
              CommandHandler commandHandler =
                  (CommandHandler)
                      this.injector.getInstance(subCommandAnnotation.mainCommandClass());
              Map<CommandHandler, SubCommand> subCommands =
                  (commandHandler.getSubCommands() == null
                      ? Maps.newHashMap()
                      : commandHandler.getSubCommands());
              subCommands.put(subCommand, subCommandAnnotation);
              commandHandler.setSubCommands(subCommands);
              System.out.println(
                  "Successfully added subcommand: "
                      + subCommandAnnotation.value()
                      + " to command "
                      + commandHandler.getClass().getAnnotation(Command.class).value());
            });
  }

  private void registerCommand(CommandHandler commandHandler, Command annotation) {}
}

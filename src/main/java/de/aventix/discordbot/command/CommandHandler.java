package de.aventix.discordbot.command;

import net.dv8tion.jda.api.entities.Message;

import java.util.Map;

/* This class was created by @Aventix on 06.06.2022 at 00:41. */
public class CommandHandler {
  private Map<CommandHandler, SubCommand> subCommands = null;

  public void onCommand(Message message, String args) {}

  public CommandHandler setSubCommands(Map<CommandHandler, SubCommand> subCommands) {
    this.subCommands = subCommands;
    return this;
  }

  public Map<CommandHandler, SubCommand> getSubCommands() {
    return subCommands;
  }
}

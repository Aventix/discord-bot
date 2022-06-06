package de.aventix.discordbot.command.entry;

import com.google.inject.Singleton;
import de.aventix.discordbot.command.Command;
import de.aventix.discordbot.command.CommandHandler;
import net.dv8tion.jda.api.entities.Message;

/* This class was created by @Aventix on 06.06.2022 at 00:55. */
@Singleton
@Command(value = "lockdown")
public class LockdownCommand extends CommandHandler {
  public void onCommand(Message message, String args) {
  }
}

package de.aventix.discordbot.config.entry;

import com.google.inject.Singleton;
import de.aventix.discordbot.config.Config;
import de.aventix.discordbot.config.Configuration;
import lombok.Data;

/* This class was created by @Aventix on 06.06.2022 at 13:05. */
@Data
@Singleton
@Configuration(filename = "messages")
public class MessageConfiguration extends Config {
  private String welcomeMessage = "{0} hat den Server beigetreten!";
  private String leaveMessage = "{0} bzw {1} bzw {2} hat den Server verlassen!";

  private String loggingPrefix = "[LOGGING]";
  private String loggingBan = "{0} hat {1} für {2} vom Server gesperrt! ({3})";
  private String loggingKick = "{0} hat {1} vom Server gekickt! ({2})";
  private String loggingWarn = "{0} hat {1} verwarnt! ({2})";
  private String loggingDeletedMessage = "{0} hat folgende Nachricht von {1} gelöscht. ({2})";
  private String loggingCreatedChannel = "{0} hat den Channel {1} erstellt!";
  private String loggingDeletedChannel = "{0} hat den Channel {2} gelöscht!";
  private String loggingCreatedRole = "{0} hat die Rolle {1} erstellt!";
  private String loggingDeletedRole = "{0} hat die Rolle {1} gelöscht!";
  private String loggingAddRole = "{0} hat {1} die Rolle {2} zugewiesen!";
  private String loggingRemoveRole = "{0} hat {1} die Rolle {2} entfernt!";
}

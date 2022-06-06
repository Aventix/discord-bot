package de.aventix.discordbot.config.entry;

import com.google.inject.Singleton;
import de.aventix.discordbot.config.Config;
import de.aventix.discordbot.config.Configuration;
import de.aventix.discordbot.config.JsonConfigurationType;
import lombok.Data;

/* This class was created by @Aventix on 06.06.2022 at 00:17. */
@Data
@Singleton
@Configuration(filename = "config", type = JsonConfigurationType.class)
public class DiscordApplicationConfig extends Config {
  private String botToken = "";
  private long welcomeLeaveMessageChannel = 1L;
}

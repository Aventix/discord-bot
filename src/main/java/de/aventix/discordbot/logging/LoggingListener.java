package de.aventix.discordbot.logging;

import com.google.inject.Singleton;
import de.aventix.discordbot.listener.DiscordListener;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.events.guild.GuildBanEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleAddEvent;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRoleRemoveEvent;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/* This class was created by @Aventix on 06.06.2022 at 13:33. */
@Singleton
@DiscordListener
public class LoggingListener extends ListenerAdapter {
  // TODO WARN & KICK

  @Override
  public void onGuildBan(@NotNull GuildBanEvent event) {}

  @Override
  public void onMessageDelete(@NotNull MessageDeleteEvent event) {}

  @Override
  public void onChannelCreate(@NotNull ChannelCreateEvent event) {}

  @Override
  public void onChannelDelete(@NotNull ChannelDeleteEvent event) {}

  @Override
  public void onRoleCreate(@NotNull RoleCreateEvent event) {}

  @Override
  public void onRoleDelete(@NotNull RoleDeleteEvent event) {}

  @Override
  public void onGuildMemberRoleAdd(@NotNull GuildMemberRoleAddEvent event) {}

  @Override
  public void onGuildMemberRoleRemove(@NotNull GuildMemberRoleRemoveEvent event) {}
}

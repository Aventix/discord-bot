package de.aventix.discordbot.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* This annotation was created by @Aventix on 06.06.2022 at 00:40. */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SubCommand {
  String value();

  String[] aliases() default {};

  Class<?> mainCommandClass();
}

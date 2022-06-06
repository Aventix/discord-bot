package de.aventix.discordbot;

import com.google.inject.Singleton;

import java.util.concurrent.atomic.AtomicReference;

/* This class was created by @Aventix on 06.06.2022 at 01:31. */
@Singleton
public class MessageController {
  public String getMessage(String message, Object... args) {
    AtomicReference<String> value = new AtomicReference<>(message);

    if (args.length != 0) {
      int i = 0;

      for (Object argument : args) {
        value.set(value.get().replaceAll("\\{" + i + "}", argument.toString()));
        i++;
      }
    }

    return value.get();
  }
}

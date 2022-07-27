package com.kunminx.architecture.data.config.utils;

import androidx.annotation.NonNull;

/**
 * Create by KunMinX at 2022/7/21
 */
public class KeyValueCreator {
  @NonNull
  public static <T> T create(Class<?> clazz) {
    try {
      Class<T> clazz1 = (Class<T>) Class.forName(clazz.getName() + "Impl");
      return clazz1.newInstance();
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
    return (T) new Object();
  }
}

package com.kunminx.architecture.data.config.utils;

import androidx.annotation.NonNull;

import java.util.HashMap;

/**
 * Create by KunMinX at 2022/7/21
 */
public class KeyValueProvider {
  private static final HashMap<String, Object> keyValueGroup = new HashMap<>();

  @NonNull
  public static <T> T get(Class<?> clazz) {
    try {
      String clazzName = clazz.getName();
      if (keyValueGroup.get(clazzName) != null) {
        return (T) keyValueGroup.get(clazzName);
      }
      Class<T> clazz1 = (Class<T>) Class.forName(clazzName + "Impl");
      T t = clazz1.newInstance();
      keyValueGroup.put(clazzName, t);
      return t;
    } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
      e.printStackTrace();
    }
    return (T) new Object();
  }
}

package com.kunminx.architecture.data.config.store;

/**
 * Create by KunMinX at 2022/7/19
 */
public interface KeyValueTool {
  void put(String keyName, Integer i);

  void put(String keyName, Long l);

  void put(String keyName, Float f);

  void put(String keyName, Boolean b);

  void put(String keyName, String s);

  Integer getInteger(String keyName);

  Long getLong(String keyName);

  Float getFloat(String keyName);

  Boolean getBoolean(String keyName);

  String getString(String keyName);
}

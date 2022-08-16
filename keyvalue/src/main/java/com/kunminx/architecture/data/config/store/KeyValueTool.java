package com.kunminx.architecture.data.config.store;

import androidx.annotation.NonNull;

/**
 * Create by KunMinX at 2022/7/19
 */
public interface KeyValueTool {
  void init(@NonNull String moduleName);
  String getGroupName();
  void put(@NonNull String keyName, Integer i);
  void put(@NonNull String keyName, Long l);
  void put(@NonNull String keyName, Float f);
  void put(@NonNull String keyName, Boolean b);
  void put(@NonNull String keyName, String s);
  Integer getInteger(@NonNull String keyName);
  Long getLong(@NonNull String keyName);
  Float getFloat(@NonNull String keyName);
  Boolean getBoolean(@NonNull String keyName);
  String getString(@NonNull String keyName);
}

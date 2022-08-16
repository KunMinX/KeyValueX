package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueString {

  private final String groupName;
  private final String keyName;
  private String value;

  public KeyValueString(@NonNull String groupName,@NonNull String keyName) {
    this.groupName = groupName;
    this.keyName = keyName;
  }

  public String get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTool(groupName).getString(keyName);
    return value;
  }

  public void set(@NonNull String value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTool(groupName).put(keyName, value);
  }
}
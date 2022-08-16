package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueInteger {

  private final String groupName;
  private final String keyName;
  private Integer value;

  public KeyValueInteger(@NonNull String groupName, @NonNull String keyName) {
    this.groupName = groupName;
    this.keyName = keyName;
  }

  public Integer get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTool(groupName).getInteger(keyName);
    return value;
  }

  public void set(@NonNull Integer value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTool(groupName).put(keyName, value);
  }
}

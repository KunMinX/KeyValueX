package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueLong {

  private final String groupName;
  private final String keyName;
  private Long value;

  public KeyValueLong(@NonNull String groupName, @NonNull String keyName) {
    this.groupName = groupName;
    this.keyName = keyName;
  }

  public Long get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTool(groupName).getLong(keyName);
    return value;
  }

  public void set(@NonNull Long value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTool(groupName).put(keyName, value);
  }
}

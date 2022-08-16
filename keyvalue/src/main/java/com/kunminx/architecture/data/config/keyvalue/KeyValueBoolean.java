package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueBoolean {

  private final String groupName;
  private final String keyName;
  private Boolean value;

  public KeyValueBoolean(@NonNull String groupName, @NonNull String keyName) {
    this.groupName = groupName;
    this.keyName = keyName;
  }

  public Boolean get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTool(groupName).getBoolean(keyName);
    return value;
  }

  public void set(@NonNull Boolean value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTool(groupName).put(keyName, value);
  }
}

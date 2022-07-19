package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueInteger {

  private final String keyName;
  private Integer value;

  public KeyValueInteger(@NonNull String keyName) {
    this.keyName = keyName;
  }

  public Integer get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTools().getInteger(keyName);
    return value;
  }

  public void set(@NonNull Integer value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTools().put(keyName, value);
  }
}

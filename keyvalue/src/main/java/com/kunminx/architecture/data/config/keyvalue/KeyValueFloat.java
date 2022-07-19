package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueFloat {

  private final String keyName;
  private Float value;

  public KeyValueFloat(@NonNull String keyName) {
    this.keyName = keyName;
  }

  public Float get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTools().getFloat(keyName);
    return value;
  }

  public void set(@NonNull Float value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTools().put(keyName, value);
  }
}

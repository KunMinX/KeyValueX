package com.kunminx.architecture.data.config.keyvalue;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueLong {

  private final String keyName;
  private Long value;

  public KeyValueLong(String keyName) {
    this.keyName = keyName;
  }

  public Long get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTools().getLong(keyName);
    return value;
  }

  public void set(Long value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTools().put(keyName, value);
  }
}

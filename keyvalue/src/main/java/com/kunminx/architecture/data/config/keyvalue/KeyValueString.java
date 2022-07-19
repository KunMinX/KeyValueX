package com.kunminx.architecture.data.config.keyvalue;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueString {

  private final String keyName;
  private String value;

  public KeyValueString(String keyName) {
    this.keyName = keyName;
  }

  public String get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTools().getString(keyName);
    return value;
  }

  public void set(String value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTools().put(keyName, value);
  }
}
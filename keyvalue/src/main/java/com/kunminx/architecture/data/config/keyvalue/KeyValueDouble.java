package com.kunminx.architecture.data.config.keyvalue;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueDouble {

  private final String keyName;
  private Double value;

  public KeyValueDouble(String keyName) {
    this.keyName = keyName;
  }

  public Double get() {
    if (value == null) value = (Double) KeyValueConfigs.getKeyValueTools().get(keyName);
    return value;
  }

  public void set(Double value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTools().put(keyName, value);
  }
}

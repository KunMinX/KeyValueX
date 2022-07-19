package com.kunminx.architecture.data.config.keyvalue;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.KeyValueConfigs;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueBoolean {

  private final String keyName;
  private Boolean value;

  public KeyValueBoolean(@NonNull String keyName) {
    this.keyName = keyName;
  }

  public Boolean get() {
    if (value == null) value = KeyValueConfigs.getKeyValueTools().getBoolean(keyName);
    return value;
  }

  public void set(@NonNull Boolean value) {
    this.value = value;
    KeyValueConfigs.getKeyValueTools().put(keyName, value);
  }
}

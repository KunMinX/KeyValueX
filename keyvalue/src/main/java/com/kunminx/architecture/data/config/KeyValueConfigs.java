package com.kunminx.architecture.data.config;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.store.DefaultKeyValueTool;
import com.kunminx.architecture.data.config.store.KeyValueTool;

import java.util.HashMap;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueConfigs {
  private final static HashMap<String, KeyValueTool> sKeyValueTools = new HashMap<>();
  private static KeyValueTool sKeyValueToolImpl = new DefaultKeyValueTool();

  public static KeyValueTool getKeyValueTool(@NonNull String groupName) {
    KeyValueTool keyValueTool = sKeyValueTools.get(groupName);
    if (keyValueTool == null) {
      keyValueTool = sKeyValueToolImpl.getNewInstance();
      keyValueTool.init(groupName);
      sKeyValueTools.put(groupName, keyValueTool);
    }
    return keyValueTool;
  }

  public static void setKeyValueToolImpl(@NonNull KeyValueTool keyValueTool) {
    sKeyValueToolImpl = keyValueTool;
  }
}
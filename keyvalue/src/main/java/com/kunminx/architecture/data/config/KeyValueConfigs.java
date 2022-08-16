package com.kunminx.architecture.data.config;

import com.kunminx.architecture.data.config.store.DefaultKeyValueTool;
import com.kunminx.architecture.data.config.store.KeyValueTool;

import java.util.HashMap;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueConfigs {
  private final static HashMap<String, KeyValueTool> sKeyValueTools = new HashMap<>();

  public static KeyValueTool getKeyValueTool(String groupName) {
    KeyValueTool keyValueTool = sKeyValueTools.get(groupName);
    if (keyValueTool == null) {
      keyValueTool = new DefaultKeyValueTool();
      keyValueTool.init(groupName);
      sKeyValueTools.put(groupName, keyValueTool);
    }
    return keyValueTool;
  }

  public static void putKeyValueTool(KeyValueTool keyValueTool) {
    sKeyValueTools.put(keyValueTool.getGroupName(), keyValueTool);
  }
}
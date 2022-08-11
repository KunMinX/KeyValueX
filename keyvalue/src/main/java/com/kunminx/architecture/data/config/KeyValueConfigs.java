package com.kunminx.architecture.data.config;

import com.kunminx.architecture.data.config.store.DefaultKeyValueTool;
import com.kunminx.architecture.data.config.store.KeyValueTool;
import com.kunminx.keyvalue.BuildConfig;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueConfigs {
  private static KeyValueTool sKeyValueTool;

  public static KeyValueTool getKeyValueTools() {
    if (sKeyValueTool == null) {
      sKeyValueTool = new DefaultKeyValueTool();
      sKeyValueTool.init(BuildConfig.LIBRARY_PACKAGE_NAME);
    }
    return sKeyValueTool;
  }

  public static void setKeyValueTools(KeyValueTool mKeyValueTools) {
    KeyValueConfigs.sKeyValueTool = mKeyValueTools;
  }
}
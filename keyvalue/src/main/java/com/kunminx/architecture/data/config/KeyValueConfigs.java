package com.kunminx.architecture.data.config;

import com.kunminx.architecture.data.config.store.DefaultKeyValueTool;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueConfigs {
  private static DefaultKeyValueTool mKeyValueTools;

  public static DefaultKeyValueTool getKeyValueTools() {
    if (mKeyValueTools == null) mKeyValueTools = new DefaultKeyValueTool();
    return mKeyValueTools;
  }

  public static void setKeyValueTools(DefaultKeyValueTool mKeyValueTools) {
    KeyValueConfigs.mKeyValueTools = mKeyValueTools;
  }
}
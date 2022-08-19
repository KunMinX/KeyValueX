package com.kunminx.sample;

import android.app.Application;
import com.kunminx.architecture.data.config.KeyValueConfigs;
import com.kunminx.keyvalue.BuildConfig;
import com.kunminx.sample.store.MMKVKeyValueTool;
import com.tencent.mmkv.MMKV;

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    // 如需使用 MMKV，您需额外配置 NDK
    MMKVKeyValueTool mmkvTool = new MMKVKeyValueTool();

    // 模块名根据实际情况配置，消除模块间 keyValue 冲突
    mmkvTool.init(BuildConfig.LIBRARY_PACKAGE_NAME);
    KeyValueConfigs.putKeyValueTool(mmkvTool);
  }

  @Override
  public void onTerminate() {
    MMKV.onExit();
    super.onTerminate();
  }
}

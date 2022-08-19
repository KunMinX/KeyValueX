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
    KeyValueConfigs.setKeyValueToolImpl(new MMKVKeyValueTool());
  }

  @Override
  public void onTerminate() {
    MMKV.onExit();
    super.onTerminate();
  }
}

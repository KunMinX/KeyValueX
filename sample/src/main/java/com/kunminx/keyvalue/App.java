package com.kunminx.keyvalue;

import android.app.Application;

import com.kunminx.architecture.data.config.KeyValueConfigs;
import com.kunminx.keyvalue.store.MMKVKeyValueTool;
import com.tencent.mmkv.MMKV;

public class App extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    MMKVKeyValueTool mmkvTool = new MMKVKeyValueTool();

    // 模块名根据实际情况配置，消除模块间 keyValue 冲突
    mmkvTool.init(BuildConfig.APPLICATION_ID);

    KeyValueConfigs.setKeyValueTools(mmkvTool);
  }

  @Override
  public void onTerminate() {
    MMKV.onExit();
    super.onTerminate();
  }
}

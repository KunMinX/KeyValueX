package com.kunminx.keyvalue;

import android.app.Application;
import com.kunminx.architecture.data.config.KeyValueConfigs;
import com.kunminx.keyvalue.store.MMKVKeyValueTool;
import com.tencent.mmkv.MMKV;

public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();

    MMKVKeyValueTool kvTool = new MMKVKeyValueTool();
    kvTool.init(this);

    KeyValueConfigs.setKeyValueTools(kvTool);
  }

  @Override public void onTerminate() {
    MMKV.onExit();
    super.onTerminate();
  }
}

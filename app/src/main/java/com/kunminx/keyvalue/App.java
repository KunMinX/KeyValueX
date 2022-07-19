package com.kunminx.keyvalue;

import android.app.Application;
import android.util.Log;
import com.kunminx.architecture.data.config.KeyValueConfigs;
import com.kunminx.keyvalue.data.config.store.MMKVKeyValueTool;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVLogLevel;

public class App extends Application {

  @Override public void onCreate() {
    super.onCreate();

    String dir = getFilesDir().getAbsolutePath() + "/mmkv";
    String rootDir = MMKV.initialize(this, dir, MMKVLogLevel.LevelInfo);
    Log.i("MMKV", "mmkv root: " + rootDir);

    MMKVKeyValueTool mmkvTool = new MMKVKeyValueTool();

    // 模块名根据实际情况配置，消除模块间 keyValue 冲突
    mmkvTool.init("sample");

    KeyValueConfigs.setKeyValueTools(mmkvTool);
  }

  @Override public void onTerminate() {
    MMKV.onExit();
    super.onTerminate();
  }
}

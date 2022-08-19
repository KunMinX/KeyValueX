package com.kunminx.sample.store;

import android.util.Log;
import androidx.annotation.NonNull;
import com.kunminx.architecture.data.config.store.KeyValueTool;
import com.kunminx.architecture.data.config.utils.AppUtils;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVContentChangeNotification;
import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;

/**
 * 如需使用 MMKV，您需额外配置 NDK
 * Create by syxc at 2022/7/19
 */
public class MMKVKeyValueTool implements KeyValueTool, MMKVHandler, MMKVContentChangeNotification {

  private MMKV mmkv;
  private String groupName;

  @Override
  public void init(@NonNull String moduleName) {
    String dir = AppUtils.getApp().getFilesDir().getAbsolutePath() + "/mmkv";
    String rootDir = MMKV.initialize(AppUtils.getApp(), dir, MMKVLogLevel.LevelInfo);
    Log.i("MMKV", "mmkv root: " + rootDir);

    // set log level
    MMKV.setLogLevel(MMKVLogLevel.LevelInfo);

    // you can turn off logging
    //MMKV.setLogLevel(MMKVLogLevel.LevelNone);

    // log redirecting & recover logic
    MMKV.registerHandler(this);

    // content change notification
    MMKV.registerContentChangeNotify(this);

    this.groupName = moduleName;
    mmkv = MMKV.mmkvWithID(moduleName);
  }

  @Override public String getGroupName() {
    return groupName;
  }

  @Override
  public void put(@NonNull String keyName, Integer i) {
    mmkv.putInt(keyName, i);
  }

  @Override
  public void put(@NonNull String keyName, Long l) {
    mmkv.putLong(keyName, l);
  }

  @Override
  public void put(@NonNull String keyName, Float f) {
    mmkv.putFloat(keyName, f);
  }

  @Override
  public void put(@NonNull String keyName, Boolean b) {
    mmkv.putBoolean(keyName, b);
  }

  @Override
  public void put(@NonNull String keyName, String s) {
    mmkv.putString(keyName, s);
  }

  @Override
  public Integer getInteger(@NonNull String keyName) {
    return mmkv.getInt(keyName, 0);
  }

  @Override
  public Long getLong(@NonNull String keyName) {
    return mmkv.getLong(keyName, 0);
  }

  @Override
  public Float getFloat(@NonNull String keyName) {
    return mmkv.getFloat(keyName, 0f);
  }

  @Override
  public Boolean getBoolean(@NonNull String keyName) {
    return mmkv.getBoolean(keyName, false);
  }

  @Override
  public String getString(@NonNull String keyName) {
    return mmkv.getString(keyName, "");
  }
  @Override
  public KeyValueTool getNewInstance() {
    return new MMKVKeyValueTool();
  }

  @Override
  public void onContentChangedByOuterProcess(String mmapID) {
    Log.i("MMKV", "other process has changed content of : " + mmapID);
  }

  @Override
  public MMKVRecoverStrategic onMMKVCRCCheckFail(String mmapID) {
    return MMKVRecoverStrategic.OnErrorRecover;
  }

  @Override
  public MMKVRecoverStrategic onMMKVFileLengthError(String mmapID) {
    return MMKVRecoverStrategic.OnErrorRecover;
  }

  @Override
  public boolean wantLogRedirecting() {
    return true;
  }

  @Override
  public void mmkvLog(MMKVLogLevel level, String file, int line, String func, String message) {
    String log = "<" + file + ":" + line + "::" + func + "> " + message;
    switch (level) {
      case LevelDebug:
        Log.d("redirect logging MMKV", log);
        break;
      case LevelNone:
      case LevelInfo:
        Log.i("redirect logging MMKV", log);
        break;
      case LevelWarning:
        Log.w("redirect logging MMKV", log);
        break;
      case LevelError:
        Log.e("redirect logging MMKV", log);
        break;
    }
  }
}

package com.kunminx.keyvalue.store;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import com.getkeepsafe.relinker.ReLinker;
import com.kunminx.architecture.data.config.store.KeyValueTool;
import com.tencent.mmkv.MMKV;
import com.tencent.mmkv.MMKVContentChangeNotification;
import com.tencent.mmkv.MMKVHandler;
import com.tencent.mmkv.MMKVLogLevel;
import com.tencent.mmkv.MMKVRecoverStrategic;

/**
 * Create by syxc at 2022/7/19
 */
public class MMKVKeyValueTool implements KeyValueTool, MMKVHandler, MMKVContentChangeNotification {

  @Override public void init(@NonNull Application application) {
    //String rootDir = MMKV.initialize(application);
    //System.out.println("mmkv root: " + rootDir);

    String dir = application.getFilesDir().getAbsolutePath() + "/mmkv";
    String rootDir = MMKV.initialize(application, dir, new MMKV.LibLoader() {
      @Override
      public void loadLibrary(String libName) {
        ReLinker.loadLibrary(application, libName);
      }
    }, MMKVLogLevel.LevelInfo);
    Log.i("MMKV", "mmkv root: " + rootDir);

    // set log level
    MMKV.setLogLevel(MMKVLogLevel.LevelInfo);

    // you can turn off logging
    //MMKV.setLogLevel(MMKVLogLevel.LevelNone);

    // log redirecting & recover logic
    MMKV.registerHandler(this);

    // content change notification
    MMKV.registerContentChangeNotify(this);
  }

  @Override public void init(@NonNull String moduleName) {
    // ignore
  }

  @Override
  public void put(@NonNull String keyName, Integer i) {
    MMKV.defaultMMKV().putInt(keyName, i);
  }

  @Override
  public void put(@NonNull String keyName, Long l) {
    MMKV.defaultMMKV().putLong(keyName, l);
  }

  @Override
  public void put(@NonNull String keyName, Float f) {
    MMKV.defaultMMKV().putFloat(keyName, f);
  }

  @Override
  public void put(@NonNull String keyName, Boolean b) {
    MMKV.defaultMMKV().putBoolean(keyName, b);
  }

  @Override
  public void put(@NonNull String keyName, String s) {
    MMKV.defaultMMKV().putString(keyName, s);
  }

  @Override
  public Integer getInteger(@NonNull String keyName) {
    return MMKV.defaultMMKV().getInt(keyName, 0);
  }

  @Override
  public Long getLong(@NonNull String keyName) {
    return MMKV.defaultMMKV().getLong(keyName, 0);
  }

  @Override
  public Float getFloat(@NonNull String keyName) {
    return MMKV.defaultMMKV().getFloat(keyName, 0f);
  }

  @Override
  public Boolean getBoolean(@NonNull String keyName) {
    return MMKV.defaultMMKV().getBoolean(keyName, false);
  }

  @Override
  public String getString(@NonNull String keyName) {
    return MMKV.defaultMMKV().getString(keyName, "");
  }

  @Override public void onContentChangedByOuterProcess(String mmapID) {
    Log.i("MMKV", "other process has changed content of : " + mmapID);
  }

  @Override public MMKVRecoverStrategic onMMKVCRCCheckFail(String mmapID) {
    return MMKVRecoverStrategic.OnErrorRecover;
  }

  @Override public MMKVRecoverStrategic onMMKVFileLengthError(String mmapID) {
    return MMKVRecoverStrategic.OnErrorRecover;
  }

  @Override public boolean wantLogRedirecting() {
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
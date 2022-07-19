package com.kunminx.keyvalue.data.config;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.store.KeyValueTool;
import com.tencent.mmkv.MMKV;

/**
 * Create by KunMinX at 2022/7/19
 */
public class MMKVTool implements KeyValueTool {

  MMKV mMMKV;

  @Override
  public void init(@NonNull String moduleName) {
    mMMKV = MMKV.mmkvWithID(moduleName);
  }

  @Override
  public void put(@NonNull String keyName, Integer i) {
    mMMKV.putInt(keyName, i);
  }

  @Override
  public void put(@NonNull String keyName, Long l) {
    mMMKV.putLong(keyName, l);
  }

  @Override
  public void put(@NonNull String keyName, Float f) {
    mMMKV.putFloat(keyName, f);
  }

  @Override
  public void put(@NonNull String keyName, Boolean b) {
    mMMKV.putBoolean(keyName, b);
  }

  @Override
  public void put(@NonNull String keyName, String s) {
    mMMKV.putString(keyName, s);
  }

  @Override
  public Integer getInteger(@NonNull String keyName) {
    return mMMKV.getInt(keyName, 0);
  }

  @Override
  public Long getLong(@NonNull String keyName) {
    return mMMKV.getLong(keyName, 0L);
  }

  @Override
  public Float getFloat(@NonNull String keyName) {
    return mMMKV.getFloat(keyName, 0f);
  }

  @Override
  public Boolean getBoolean(@NonNull String keyName) {
    return mMMKV.getBoolean(keyName, false);
  }

  @Override
  public String getString(@NonNull String keyName) {
    return mMMKV.getString(keyName, "");
  }
}

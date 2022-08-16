package com.kunminx.architecture.data.config.store;

import androidx.annotation.NonNull;

import com.kunminx.architecture.data.config.utils.SPUtils;

/**
 * Create by KunMinX at 2022/7/19
 */
public class DefaultKeyValueTool implements KeyValueTool {

  private SPUtils mSPUtils;
  private String groupName;

  public void init(@NonNull String groupName) {
    this.groupName = groupName;
    mSPUtils = SPUtils.getInstance(groupName);
  }
  @Override
  public String getGroupName() {
    return groupName;
  }

  @Override
  public void put(@NonNull String keyName, Integer i) {
    mSPUtils.put(keyName, i);
  }

  @Override
  public void put(@NonNull String keyName, Long l) {
    mSPUtils.put(keyName, l);
  }

  @Override
  public void put(@NonNull String keyName, Float f) {
    mSPUtils.put(keyName, f);
  }

  @Override
  public void put(@NonNull String keyName, Boolean b) {
    mSPUtils.put(keyName, b);
  }

  @Override
  public void put(@NonNull String keyName, String s) {
    mSPUtils.put(keyName, s);
  }

  @Override
  public Integer getInteger(@NonNull String keyName) {
    return mSPUtils.getInt(keyName);
  }

  @Override
  public Long getLong(@NonNull String keyName) {
    return mSPUtils.getLong(keyName);
  }

  @Override
  public Float getFloat(@NonNull String keyName) {
    return mSPUtils.getFloat(keyName);
  }

  @Override
  public Boolean getBoolean(@NonNull String keyName) {
    return mSPUtils.getBoolean(keyName);
  }

  @Override
  public String getString(@NonNull String keyName) {
    return mSPUtils.getString(keyName);
  }
}
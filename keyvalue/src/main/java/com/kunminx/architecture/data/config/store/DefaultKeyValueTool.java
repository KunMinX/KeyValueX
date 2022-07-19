package com.kunminx.architecture.data.config.store;

import com.kunminx.architecture.data.config.utils.SPUtils;

/**
 * Create by KunMinX at 2022/7/19
 */
public class DefaultKeyValueTool implements KeyValueTool {

  @Override
  public void put(String keyName, Integer i) {
    SPUtils.getInstance().put(keyName, i);
  }

  @Override
  public void put(String keyName, Long l) {
    SPUtils.getInstance().put(keyName, l);
  }

  @Override
  public void put(String keyName, Float f) {
    SPUtils.getInstance().put(keyName, f);
  }

  @Override
  public void put(String keyName, Boolean b) {
    SPUtils.getInstance().put(keyName, b);
  }

  @Override
  public void put(String keyName, String s) {
    SPUtils.getInstance().put(keyName, s);
  }

  @Override
  public Integer getInteger(String keyName) {
    return SPUtils.getInstance().getInt(keyName);
  }

  @Override
  public Long getLong(String keyName) {
    return SPUtils.getInstance().getLong(keyName);
  }

  @Override
  public Float getFloat(String keyName) {
    return SPUtils.getInstance().getFloat(keyName);
  }

  @Override
  public Boolean getBoolean(String keyName) {
    return SPUtils.getInstance().getBoolean(keyName);
  }

  @Override
  public String getString(String keyName) {
    return SPUtils.getInstance().getString(keyName);
  }
}
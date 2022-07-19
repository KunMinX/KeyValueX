package com.kunminx.keyvalue.data.config;

import com.kunminx.architecture.data.config.keyvalue.KeyValueSerializable;
import com.kunminx.architecture.data.config.keyvalue.KeyValueString;
import com.kunminx.keyvalue.data.bean.User;

/**
 * Create by KunMinX at 2022/7/19
 */
public class Configs {
  public final static KeyValueString accountId = new KeyValueString("accountId");
  public final static KeyValueSerializable<User> user = new KeyValueSerializable<>("user");
}

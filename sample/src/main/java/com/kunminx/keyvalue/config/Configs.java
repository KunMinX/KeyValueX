package com.kunminx.keyvalue.config;

import com.kunminx.architecture.data.config.keyvalue.KeyValueBoolean;
import com.kunminx.architecture.data.config.keyvalue.KeyValueInteger;
import com.kunminx.architecture.data.config.keyvalue.KeyValueSerializable;
import com.kunminx.architecture.data.config.keyvalue.KeyValueString;
import com.kunminx.architecture.data.config.utils.KeyValueCreator;
import com.kunminx.keyvalue.bean.User;

/**
 * Create by KunMinX at 2022/7/19
 */
public class Configs {
  public final static KeyValueInteger id = new KeyValueInteger("id");
  public final static KeyValueBoolean isVip = new KeyValueBoolean("isVip");
  public final static KeyValueString accountId = new KeyValueString("accountId");
  public final static KeyValueSerializable<User> user = new KeyValueSerializable<>("user");
  //  public final static Test test = new TestImpl();
  public final static Test test = KeyValueCreator.create(Test.class);
}

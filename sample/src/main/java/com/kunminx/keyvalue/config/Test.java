package com.kunminx.keyvalue.config;

import com.kunminx.architecture.data.config.keyvalue.KeyValueBoolean;
import com.kunminx.architecture.data.config.keyvalue.KeyValueSerializable;
import com.kunminx.architecture.data.config.keyvalue.KeyValueString;
import com.kunminx.keyvalue.annotation.KeyValue;
import com.kunminx.keyvalue.annotation.KeyValueGroup;
import com.kunminx.keyvalue.bean.User;

/**
 * Create by KunMinX at 2022/7/20
 */
@KeyValueGroup
public interface Test {
  @KeyValue
  KeyValueBoolean test();

  @KeyValue
  KeyValueString test1();

  @KeyValue
  KeyValueSerializable<User> user();
}

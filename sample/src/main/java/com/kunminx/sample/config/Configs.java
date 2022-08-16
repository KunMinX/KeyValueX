package com.kunminx.sample.config;

import com.kunminx.architecture.data.config.keyvalue.KeyValueBoolean;
import com.kunminx.architecture.data.config.keyvalue.KeyValueSerializable;
import com.kunminx.architecture.data.config.keyvalue.KeyValueString;
import com.kunminx.keyvalue.annotation.KeyValueX;
import com.kunminx.sample.bean.User;

import java.util.List;
/**
 * Create by KunMinX at 2022/8/16
 */
@KeyValueX
public interface Configs {
  KeyValueBoolean test();
  KeyValueString test1();
  KeyValueSerializable<User> user();
  KeyValueSerializable<List<User>> users();
}

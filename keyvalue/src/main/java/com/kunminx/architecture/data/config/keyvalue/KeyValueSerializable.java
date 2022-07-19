package com.kunminx.architecture.data.config.keyvalue;

import android.util.Base64;

import com.kunminx.architecture.data.config.KeyValueConfigs;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Create by KunMinX at 2022/7/19
 */
public class KeyValueSerializable<T> {

  private final String keyName;
  private T value;

  public KeyValueSerializable(String keyName) {
    this.keyName = keyName;
  }

  public T get() {
    if (value == null) {
      String s = KeyValueConfigs.getKeyValueTools().getString(keyName);
      value = (T) base64StringToObject(s);
    }
    return value;
  }

  public void set(T value) {
    this.value = value;
    String s = objectToBase64String(value);
    KeyValueConfigs.getKeyValueTools().put(keyName, s);
  }

  private String objectToBase64String(Object o) {
    String s = null;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    try {
      ObjectOutputStream oos = new ObjectOutputStream(bos);
      oos.writeObject(o);
      oos.close();
      bos.close();
      s = Base64.encodeToString(bos.toByteArray(), Base64.DEFAULT);
    } catch (Exception e) {
    }
    return s;
  }

  private Object base64StringToObject(String s) {
    Object o = null;
    try {
      byte[] gameByte = android.util.Base64.decode(s.getBytes(StandardCharsets.UTF_8), android.util.Base64.DEFAULT);
      ByteArrayInputStream bis = new ByteArrayInputStream(gameByte);
      ObjectInputStream ois = new ObjectInputStream(bis);
      o = ois.readObject();
      bis.close();
      ois.close();
    } catch (Exception e) {
    }
    return o;
  }
}
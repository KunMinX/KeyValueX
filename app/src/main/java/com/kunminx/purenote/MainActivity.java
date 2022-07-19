package com.kunminx.purenote;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.architecture.data.config.keyvalue.KeyValueSerializable;
import com.kunminx.architecture.data.config.keyvalue.KeyValueString;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    KeyValueString username = new KeyValueString("username");
//    username.set("hahaha");
//    Log.d("---", username.get());

    KeyValueSerializable<TestSerializable> testSerialize = new KeyValueSerializable<>("testParcelable");
    TestSerializable tp = new TestSerializable();
    tp.title = "title1";
    tp.content = "content1";
    testSerialize.set(tp);
    Log.d("---title", testSerialize.get().title);
    Log.d("---content", testSerialize.get().content);
  }

  public static class TestSerializable implements Serializable {
    public String title;
    public String content;
  }
}
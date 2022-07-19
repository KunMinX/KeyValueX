package com.kunminx.keyvalue;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.keyvalue.bean.User;
import com.kunminx.keyvalue.config.Configs;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    User u = new User();
    u.title = "title1";
    u.content = "content1";

    //默认 SP 读写。可注入自定义 KV 读写工具，例如 MMKV 详见 App.java

    findViewById(R.id.btn_write).setOnClickListener(v -> {
      Configs.user.set(u);
    });

    findViewById(R.id.btn_read).setOnClickListener(v -> {
      Log.d("---title", Configs.user.get().title);
      Log.d("---content", Configs.user.get().content);
    });
  }
}
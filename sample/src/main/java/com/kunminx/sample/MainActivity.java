package com.kunminx.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.sample.R;
import com.kunminx.sample.bean.User;
import com.kunminx.sample.config.Configs;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    User u = new User();
    u.title = "title1";
    u.content = "content1";

    List<User> users = new ArrayList<>();
    users.add(u);

    //默认 SP 读写。可注入自定义 KV 读写工具，例如 MMKV 详见 App.java

    findViewById(R.id.btn_write).setOnClickListener(v -> {
      Configs.user.set(u);
      Configs.test.users().set(users);
    });

    findViewById(R.id.btn_read).setOnClickListener(v -> {
//      Log.d("---title", Configs.user.get().title);
//      Log.d("---content", Configs.user.get().content);
      Log.d("---title", Configs.test.user().get().title);
      Log.d("---users", Configs.test.users().get().toString());
      Log.d("---content", Configs.test.users().get().get(0).content);
    });
  }
}
package com.kunminx.purenote;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.purenote.data.Configs;
import com.kunminx.purenote.data.bean.User;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    User u = new User();
    u.title = "title1";
    u.content = "content1";

    findViewById(R.id.btn_write).setOnClickListener(v -> {
      Configs.user.set(u);
    });

    findViewById(R.id.btn_read).setOnClickListener(v -> {
      Log.d("---title", Configs.user.get().title);
      Log.d("---content", Configs.user.get().content);
    });
  }
}
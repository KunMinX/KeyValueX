package com.kunminx.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kunminx.architecture.data.config.utils.KeyValueProvider;
import com.kunminx.sample.bean.User;
import com.kunminx.sample.config.Configs;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO tip：默认 SP 读写。可注入自定义 KV 读写工具，例如 MMKV，
 *  为方便未安装 NDK 开发者，我们另行提供 mmkvSample 分支，
 *  MMKV 示例可见 mmkvSample 分支 App.java
 * <p>
 * Create by KunMinX at 2022/7/19
 */
public class MainActivity extends AppCompatActivity {

  //TODO tip: 混淆会使原来的类消失不见，由于生成类和接口处于同一目录，所以反射时需 keep 相应目录，
  // 如不想 keep，则不可使用反射。在第一次创建接口时，build 一次，获取生成类来使用即可，例如：
  // Configs configs = new ConfigsImpl();

  private final Configs configs = KeyValueProvider.get(Configs.class);

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    User u = new User();
    u.title = "title1";
    u.content = "content1";
    List<User> users = new ArrayList<>();
    users.add(u);

    findViewById(R.id.btn_write).setOnClickListener(v -> {
      configs.user().set(u);
      configs.users().set(users);
    });
    findViewById(R.id.btn_read).setOnClickListener(v -> {
      Log.d("---title", configs.user().get().title);
      Log.d("---users", configs.users().get().toString());
      Log.d("---content", configs.users().get().get(0).content);
    });
  }
}
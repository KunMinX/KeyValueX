> Easy-KeyValue：像 Kotlin “属性代理” 一样简明易用，使 Android Java 项目 key、value、get、put、init 缩减为一，不再 “KV 满天飞”。

&nbsp;

# 背景

源于深夜一段独白：

Key Value 定义几十上百个是很常见的事，目前有更简便方法么，

此为项目中为数不多不受控制之地，指数膨胀，且易埋下一致性隐患，

每新增一 key，需兼顾 value、get、put、init，5 处 …

![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4c5mrfb32j21dq0rgn43.jpg)

随后陆续收到改善建议，有小伙伴提到 “属性代理”，并推荐了群友 DylanCai 开源库 https://github.com/DylanCaiCoding/MMKV-KTX

![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4c5rrtf8aj20ta0swmz7.jpg)

与此同时，受 “属性代理” 启发，本人萌生可在 Java 下将 key、value、get、put、init 缩减为一设计。

&nbsp;

```
implementation 'com.kunminx.arch:key-value:1.2.0-beta'
```

&nbsp;

# 使用 3 步曲：

1.如读写 POJO，需实现 Serializable 接口

```java
public class User implements Serializable {
  public String title;
  public String content;
}
```

2.像往常一样，创建项目配置管理类，如 Configs

```java
//Configs 中不再定义一堆 KEY、VALUE 常量和 get、put、init 静态方法，
//只需一条条 KeyValue 静态变量：

public class Configs {
  public final static KeyValueString accountId = new KeyValueString("accountId");
  public final static KeyValueSerializable<User> user = new KeyValueSerializable<>("user");
}
```

3.在页面等处通过 get( ) set( ) 接口读写 KeyValue

```java
public class MainActivity extends AppCompatActivity {
  ...
          
  //测试持久化写入
  Configs.user.set(u);

  //测试读取
  Log.d("---title", Configs.user.get().title);
  Log.d("---content", Configs.user.get().content);
}
```

Easy-KeyValue 默认使用 SharedPreference 读写，可根据 KeyValueTool 自行注入 MMKV 等实现（详见 MainActivity 示例）。

&nbsp;

# Thanks

[AndroidCodeUtils - SPUtils](https://github.com/Blankj/AndroidUtilCode/blob/d0b890e106be3658d259ca7ec52e232b991f67f1/lib/utilcode/src/main/java/com/blankj/utilcode/util/SPUtils.java)

&nbsp;

# License

```
Copyright 2019-present KunMinX

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
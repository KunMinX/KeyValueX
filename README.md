![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4kltojgmqj21h80dmabg.jpg)

&nbsp;

### [🌏 English README](https://github.com/KunMinX/KeyValueX/blob/main/README_EN.md)

研发小故事：[《KeyValueX 立项 & 迭代心路历程》](https://juejin.cn/post/7121955840319291428)

&nbsp;

# 特性

1.key、value、get、put、init 缩减为一，不再 KV 爆炸

2.使用注解，但无需初始化 build，对巨型项目友好

3.支持 Java

&nbsp;

项目根目录 build.gradle 添加如下依赖：

```
allprojects {
    repositories {
        // ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

模块 build.gradle 添加如下依赖：

```
implementation 'com.github.KunMinX.KeyValueX:keyvalue:2.3.0-beta'
annotationProcessor 'com.github.KunMinX.KeyValueX:keyvalue-compiler:2.3.0-beta'
```

&nbsp;

# 使用 3 步曲

1.创建 KeyValueGroup 接口，例如

```java
@KeyValueX
public interface Test {
  KeyValueInteger days();
  KeyValueString accountId();
  KeyValueSerializable<User> user();
}
```

2.像往常一样，创建项目配置管理类，如 Configs

```java
//Configs 无须定义一堆 KEY、VALUE 常量和 get、put、init 静态方法，
//只需一条 KeyValues 静态变量：

public class Configs {
  public final static Test keyValues = KeyValueCreator.create(Test.class);
}
```

3.在页面等处通过 get( ) set( ) 方法读写 KeyValue

```java
public class MainActivity extends AppCompatActivity {
  ...

  //测试持久化写入
  Configs.keyValues.user().set(u);

  //测试读取
  Log.d("---title", Configs.keyValues.user().get().title);
  Log.d("---content", Configs.keyValues.user().get().content);
}
```

KeyValueX 默认使用 SharedPreference 读写，可根据 KeyValueTool 自行注入 MMKV 等实现（详见 MainActivity 示例）。

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
![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4kltojgmqj21h80dmabg.jpg)

&nbsp;

### [🌏 English README](https://github.com/KunMinX/KeyValueX/blob/main/README_EN.md)

&nbsp;

# 特性

1.根据接口配置自动生成，无需手写 key、value、getter、setter、init 样板代码

2.使用注解，但无需初始化 build，对巨型项目友好

3.通过接口路径 MD5 自动完成分组，消除各组件模块配置冲突

4.KeyValueX 默认 SP 读写，可根据 KeyValueTool 自行注入 MMKV、DataStore 等实现（详见 Git MMKVSample 分支，App.java 示例）。

5.支持 Java

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

> 注意：
>
> 1.建议配置在定义 @KeyValueX 接口所在的模块，以免发生 ClassNotFoundException & ClassCastException 情况
>
> 2.如使用 KeyValueProvider 获取 KeyValue 实例，需在项目 proguard-rules.pro 中须配置 @KeyValueX 接口所在目录，避免被混淆，
> 如欲混淆，勿使用 KeyValueProvider，而是定义完 @KeyValueX 接口后，build 一次，生成 xxxImpl ，并通过 xxxImpl 赋值。

```
implementation 'com.github.KunMinX.KeyValueX:keyvalue:3.6.0-beta'
annotationProcessor 'com.github.KunMinX.KeyValueX:keyvalue-compiler:3.6.0-beta'
```

&nbsp;

# 使用 2 步曲

1.创建 KeyValueGroup 接口，例如

```java
@KeyValueX
public interface Configs {
  KeyValueInteger days();
  KeyValueString accountId();
  KeyValueSerializable<User> user();
}
```

2.在页面等处通过 get( ) set( ) 方法读写 KeyValue

```java
public class MainActivity extends AppCompatActivity {
  //Configs 不可混淆：
  //Configs configs = KeyValueProvider.get(Configs.class);

  //Configs 可被混淆：
  Configs configs = new ConfigImpl();
  
  ...

  //写
  configs.user().set(user);

  //读
  configs.user().get().title;
  configs.user().get().content;
}
```

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
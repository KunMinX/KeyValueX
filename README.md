![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4kltojgmqj21h80dmabg.jpg)

&nbsp;

### [🌏 English README](https://github.com/KunMinX/KeyValueX/blob/main/README_EN.md)

研发小故事：[《KeyValueX 立项 & 迭代心路历程》](https://juejin.cn/post/7121955840319291428)

&nbsp;

# 特性

1.key、value、get、put、init 缩减为一，不再 KV 爆炸

2.使用注解，但无需初始化 build，对巨型项目友好

3.通过接口路径 MD5 自动完成分组，消除各组件模块配置冲突

4.默认 SP 读写，可根据 KeyValueTool 自行注入 MMKV 等实现(示例见 mmkvSample 分支)

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

```
implementation 'com.github.KunMinX.KeyValueX:keyvalue:3.5.0-beta'
annotationProcessor 'com.github.KunMinX.KeyValueX:keyvalue-compiler:3.5.0-beta'
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
  Configs configs = KeyValueProvider.get(Configs.class);
  
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
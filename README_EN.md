![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4k7mxxpjzj21h60dkwfu.jpg)

&nbsp;

Software development stories:[《KeyValueX Project Approval & Iteration Process》](https://blog.devgenius.io/keyvaluex-eliminate-boilerplate-code-and-make-android-projects-no-longer-kv-explosion-3f6fbca31692)

&nbsp;

# Feature

1. Key, value, get, put, init are reduced to one, no longer KV explosion

2. Use annotations, but no need to initialize build, friendly to huge projects

3. Support Java

&nbsp;

Add the following dependencies to the project root directory build.gradle:

```
allprojects {
    repositories {
        // ...
        maven { url 'https://www.jitpack.io' }
    }
}
```

The module build.gradle adds the following dependencies:

```
implementation 'com.github.KunMinX.KeyValueX:keyvalue:2.2.7-beta'
annotationProcessor 'com.github.KunMinX.KeyValueX:keyvalue-compiler:2.2.7-beta'
```

&nbsp;

# Usage

Step 1. Create the KeyValueGroup interface, for example

```java
@KeyValueGroup
public interface Test {
  @KeyValue KeyValueInteger days();
  @KeyValue KeyValueString accountId();
  @KeyValue KeyValueSerializable<User> user();
}
```

Step 2. As usual, create a project configuration management class like Configs

```java
//Configs do not need to define a bunch of KEY, VALUE constants and get, put, init static methods, Just one KeyValues static variable:

public class Configs {
  public final static Test keyValues = KeyValueCreator.create(Test.class);
}
```

Step 3. Read and write KeyValue through the get( ) set( ) method on the page, etc.

```java
public class MainActivity extends AppCompatActivity {
  ...

  //Test persistent write
  Configs.keyValues.user().set(u);

  //Test read
  Log.d("---title", Configs.keyValues.user().get().title);
  Log.d("---content", Configs.keyValues.user().get().content);
}
```

KeyValueX uses SharedPreference to read and write by default, and can be injected into MMKV and other implementations according to KeyValueTool (see the MainActivity example for details).

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
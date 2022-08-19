![](https://tva1.sinaimg.cn/large/e6c9d24ely1h4k7mxxpjzj21h60dkwfu.jpg)

&nbsp;

Software development stories:[《KeyValueX Project Approval & Iteration Process》](https://blog.devgenius.io/keyvaluex-eliminate-boilerplate-code-and-make-android-projects-no-longer-kv-explosion-3f6fbca31692)

&nbsp;

# Feature

1. Key, value, get, put, init are reduced to one, no longer KV explosion

2. Use annotations, but no need to initialize build, friendly to huge projects

3. Automatically complete grouping through the interface path MD5 to eliminate the configuration conflict of each component module

4. KeyValueX uses SharedPreference to read and write by default, and can be injected into MMKV and other implementations according to KeyValueTool (see the App.java).

5. Support Java

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
see main branch README ...

```

&nbsp;

# Usage

Step 1. Create the KeyValueGroup interface, for example

```java
@KeyValueX
public interface Configs {
  KeyValueInteger days();
  KeyValueString accountId();
  KeyValueSerializable<User> user();
}
```

Step 2. Read and write KeyValue through the get( ) set( ) method on the page.

```java
public class MainActivity extends AppCompatActivity {
  private final Configs configs = KeyValueProvider.get(Configs.class);
  
  ...
          
  // persistent write
  configs.user().set(user);

  // read
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
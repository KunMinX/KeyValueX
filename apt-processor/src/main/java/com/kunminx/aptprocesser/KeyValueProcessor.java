package com.kunminx.aptprocesser;

import com.google.auto.service.AutoService;
import com.kunminx.aptannotation.KeyValue;
import com.kunminx.aptannotation.KeyValueGroup;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * Create by KunMinX at 2022/7/20
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class KeyValueProcessor extends AbstractProcessor {
  private Filer mFiler;
  private Types mTypeUtils;
  private Elements mElementUtils;
  private Messager mMessenger;

  @Override
  public synchronized void init(ProcessingEnvironment pEnv) {
    super.init(pEnv);
    mTypeUtils = pEnv.getTypeUtils();
    mElementUtils = pEnv.getElementUtils();
    mMessenger = pEnv.getMessager();
    mFiler = pEnv.getFiler();
  }

  @Override
  public boolean process(Set<? extends TypeElement> types, RoundEnvironment rEnv) {
    if (types == null || types.isEmpty()) {
      return false;
    }

//    @KeyValueGroup(name = "sample")
//    public class KeyValues {
//      @KeyValue
//      KeyValueString username;
//      @KeyValue
//      KeyValueSerializable<User> user;
//    }

//    public class KeyValues {
//      public KeyValues(){
//        KeyValueTool tool = new KeyValueTool();
//        tool.init("sample");
//        KeyValueConfig.setKeyValueTools(tool);
//      }
//      public final KeyValueString username = new keyValueString("username");
//      public final KeyValueSerializable<User> user = new KeyValueSerializable<>("user);
//    }

    Set<? extends Element> rootElements = rEnv.getElementsAnnotatedWith(KeyValueGroup.class);

    if (rootElements != null && !rootElements.isEmpty()) {
      for (Element element : rootElements) {
        String name = element.getSimpleName().toString();
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(name + "Impl").addModifiers(Modifier.PUBLIC);
        TypeElement typeElement = (TypeElement) element;

        List<? extends Element> members = mElementUtils.getAllMembers(typeElement);
        for (Element childElement : members) {
          if (childElement instanceof VariableElement) {
            VariableElement variableElement = (VariableElement) childElement;
            KeyValue keyValue = variableElement.getAnnotation(KeyValue.class);
            if (keyValue == null) continue;
            FieldSpec fb = FieldSpec.builder(ClassName.get(variableElement.asType()), variableElement.getSimpleName().toString())
                    .addModifiers(Modifier.PUBLIC)
                    .addModifiers(Modifier.FINAL)
                    .addModifiers(Modifier.STATIC)
                    .initializer("new $T($S)", ClassName.get(variableElement.asType()), variableElement.getSimpleName().toString())
                    .build();
            classBuilder.addField(fb);
          }
        }
        TypeSpec typeSpec = classBuilder.build();

        JavaFile javaFile = JavaFile.builder(typeElement.getQualifiedName().toString() + "Impl", typeSpec)
                .build();
        try {
          javaFile.writeTo(mFiler);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return true;
  }

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    HashSet<String> hashSet = new HashSet<>();
    hashSet.add(KeyValueGroup.class.getCanonicalName());
    hashSet.add(KeyValue.class.getCanonicalName());
    return hashSet;
  }
}
package com.kunminx.keyvalue.apt;

import com.google.auto.service.AutoService;
import com.kunminx.keyvalue.annotation.KeyValueX;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * Create by KunMinX at 2022/7/20
 */
@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class KeyValueProcessor extends AbstractProcessor {
  private Filer mFiler;
  private Elements mElementUtils;

  @Override
  public synchronized void init(ProcessingEnvironment pEnv) {
    super.init(pEnv);
    mElementUtils = pEnv.getElementUtils();
    mFiler = pEnv.getFiler();
  }

  @Override
  public boolean process(Set<? extends TypeElement> types, RoundEnvironment rEnv) {
    if (types == null || types.isEmpty()) {
      return false;
    }
    Set<? extends Element> rootElements = rEnv.getElementsAnnotatedWith(KeyValueX.class);
    if (rootElements != null && !rootElements.isEmpty()) {
      for (Element element : rootElements) {
        String name = element.getSimpleName().toString();
        String groupName = element.getAnnotation(KeyValueX.class).groupName();
        if (groupName.isEmpty()) groupName = getMd5(element.getEnclosingElement().toString());
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder(name + "Impl").addModifiers(Modifier.PUBLIC);
        TypeElement typeElement = (TypeElement) element;
        List<? extends Element> members = mElementUtils.getAllMembers(typeElement);
        for (Element childElement : members) {
          if (childElement instanceof ExecutableElement) {
            ExecutableElement executableElement = (ExecutableElement) childElement;
            String methodName = executableElement.getSimpleName().toString();
            boolean isContinue = false;
            switch (methodName) {
              case "getClass":
              case "hashCode":
              case "equals":
              case "toString":
              case "notify":
              case "notifyAll":
              case "wait":
                isContinue = true;
              default:
            }
            if (isContinue) continue;
            String varName = executableElement.getSimpleName().toString();
            String backVarName = "_" + varName;
            TypeName typeName = ClassName.get(executableElement.getReturnType());
            FieldSpec fb = FieldSpec.builder(typeName, backVarName)
                    .addModifiers(Modifier.PRIVATE)
                    .build();
            classBuilder.addField(fb);
            MethodSpec mb = MethodSpec.methodBuilder(varName)
                    .addModifiers(Modifier.PUBLIC)
                    .returns(typeName)
                    .addStatement("if($L == null) $L = new $T($S, $S);", backVarName, backVarName, typeName, groupName, varName)
                    .addStatement("return $L", backVarName)
                    .build();
            classBuilder.addMethod(mb);
          }
        }
        classBuilder.addSuperinterface(typeElement.asType());
        TypeSpec typeSpec = classBuilder.build();
        JavaFile javaFile = JavaFile.builder(typeElement.getEnclosingElement().toString(), typeSpec)
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
    hashSet.add(KeyValueX.class.getCanonicalName());
    return hashSet;
  }

  private String getMd5(String str) {
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    byte[] bs = new byte[0];
    if (md5 != null) {
      bs = md5.digest(str.getBytes());
    }
    StringBuilder sb = new StringBuilder(40);
    for (byte x : bs) {
      if ((x & 0xff) >> 4 == 0) {
        sb.append("0").append(Integer.toHexString(x & 0xff));
      } else {
        sb.append(Integer.toHexString(x & 0xff));
      }
    }
    return sb.toString();
  }
}
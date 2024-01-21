package com.group.libraryapp.dto.user.request;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UserCreateRequest {

  @NotNull
  private String name;
  @Nullable // 이걸 통해 코틀린에서 타입 확인 가능
  private Integer age;

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public UserCreateRequest(String name, Integer age) {
    this.name = name;
    this.age = age;
  }
}

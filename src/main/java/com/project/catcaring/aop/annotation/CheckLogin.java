package com.project.catcaring.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  로그인 상태 여부  

  불필요한 로그인에 대한 중복 로직들을 줄이기 위해 AOP 사용했습니다. 
  해당 클래스는 Aspect에 대한 어노테이션을 생성합니다. 

  @Target 으로 메서드를 대상으로 어노테이션 사용 가능 범위와
  @Retention 으로 애노테이션의 라이프사이클을 런타임시까지 지정해 주었습니다. 

  @author suna.park
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckLogin {
}

package com.project.catcaring.aop.aspect;

import com.project.catcaring.error.LoginErrorException;
import com.project.catcaring.error.ProcessErrorException;
import com.project.catcaring.service.user.LoginService;
import com.project.catcaring.service.user.LoginSessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

/**
    로그인 관련 Aspect로 로그인 체크 AOP 에 대한 구현체입니다. 
    재사용이 빈번한 로직이며 비즈니스 로직이 아니기에 AOP로 따로 관리하는것이
    유지 보수 관점에서도 효과적입니다. 

    @Aspect 를 통해 클래스가 Aspect를 나타냄을 명시하고
    @Component 로 빈에 자동적으로 생성시켰습니다. 
    라이버리에 종속되어 있지않은 유연한 로그를 남기기 위해 @Slf4j 를 사용하였습니다. 

    @author suna.park
 */
@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class UserLoginAspect {

  private final LoginService loginSessionService;

/**
    CheckLogin 어노테이션이 붙은 메소드 실행하기 전 해당 로직을 실행합니다. 
 */
  @Before("@annotation(com.project.catcaring.aop.annotation.CheckLogin)")
  public void checkLogin() throws HttpClientErrorException {
    // 세선에 저장되어 있는 사용자의 ID 가져오기. 
    Long currentUserId = loginSessionService.getCurrentUserId();

    // 사용자의 권한이 없는 경우 로그 남기고 권한이 없다는 에러 발생 
    if (currentUserId == null) {
      log.info(" ===== 회원이 로그인이 필요합니다. ===== ");
      throw new LoginErrorException(HttpStatus.UNAUTHORIZED);
    }
    log.info(" ===== 회원이 로그인 되어 있는 상태입니다 ===== ");
  }
}

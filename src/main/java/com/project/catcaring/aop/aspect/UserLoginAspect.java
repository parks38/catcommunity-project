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

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class UserLoginAspect {

  private final LoginService loginSessionService;

  @Before("@annotation(com.project.catcaring.aop.annotation.CheckLogin)")
  public void checkLogin() throws HttpClientErrorException {
    Long currentUserId = loginSessionService.getCurrentUserId();

    if (currentUserId == null) {
      log.info(" ===== 회원이 로그인이 필요합니다. ===== ");
      throw new LoginErrorException(HttpStatus.UNAUTHORIZED);
    }
    log.info(" ===== 회원이 로그인 되어 있는 상태입니다 ===== ");
  }
}

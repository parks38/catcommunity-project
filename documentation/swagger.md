Swagger 사용 
---

### 단계 1. 라이버리 의존성 주입  
```
    implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
    implementation group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'
```

### 단계 2. SwaggerConfiguration 생성 


### 단계 3. 코드에 사용하기
 [swagger annotation]  
 - `@Api(value="", tags="")` : 클래스가 swagger resource 명시 
   - value : 사용자 지정 이름
    - tags : 여러 태그 정의 가능
   
- `@ApiOperation(value="", notes="")` : 해당 api 명세 
    - value : 현재 api 에 대한 정의 
    - notes  : 현재 api comment
    
- `@ApiParam(value="~", required="~", example="~")`   
  : 파라미터 상세 명세 
    - value : parameter 설명  
    - required : 필수 여부  
    - example : 예시 

 ###Q.  /swagger-ui.html 403 에러 뜨는 경우?  <br>
 : 이 경우에는 spring security 권한과 관련이 있습니다.

```
@Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/auth/**", "/posts/**", "/", "/comments/**" ,"/users/**", "/mappers/**",
            "/swagger-ui.html", "/swagger-ui.html/**", "/swagger-resources/**", "/webjars/**", "/v2/api-docs")
        .permitAll()
        .anyRequest()
        .authenticated();
  }
```
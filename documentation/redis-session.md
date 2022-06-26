Redis Session
---
`key-value` 구조의 비정형 데이터를 저장 관리하기 위한 비관계형 데이터 베이스 관리 시스템.   
- [자료 구조]
    - String
    - Set
    - Sorted Set
    - Hash
    - List    
    
### 단계 1. 의존성 주입  
```
// spring에서 redis에 대한 의존성
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
// spring에서 redis를 session storage로 사용하기 위한 의존성
implementation 'org.springframework.session:spring-session-data-redis'
implementation 'org.springframework.session:spring-session-jdbc'
```

### Redis Terminal 명령어  
```
// 시작
> brew services start redis
// 정지
> brew services stop redis
// 재시작
> brew services restart redis 

// redis 실행
> redis-cli
000.0.0.0:6379> ping
PONG

// 모든 키 확인
> KEYS '*' 
// value
> GET <your-key>

```
# 🐱 길냥이를 부탁해

### 📌 프로젝트 개요
'길냥이를 부탁해'는 다음카카오의 서비스를 모티브로 제작한 길고양이들과 서울시민의 공생을 목표로 시민들이 직접 오프라인 집사가 될 수 있는 건강한 지역사회를 위한 프로젝트를 기획했습니다. 기존 보안 문제로 운영 중단된 서비스를 활용하여 저만의 회원 등급제도 알고리즘을 통해 문제를 해결하고 자유로운 정보제공 기능을 유지한 서비스 제공으로 서비스의 만족도를 높였습니다.

### 📌 프로젝트 목표

- '길냥이를 부탁해'와 같은 커뮤니티 게시판 서비스에 사용자 권한 제한 로직을 통한 문제점 보완
- 객체 지향적인 올바른 코드 작성
- 클린 코드 작성
- CI/CD를 통한 자동화를 이용하여 협업이 쉬운 프로젝트 구현

#### 💻 개발 환경

Java, Spring Boot, Gradle, MySQL, Mybatis

### ⛓️ Repo 원본 Link ###
- PR/ commit message 확인 : https://github.com/f-lab-edu/cat-caring-community
- 프로젝트 상세 내용 정리 : https://www.notion.so/ssunsoolzip/e092e57afb0f49119af6597f8864c2a8

### 📌 프로젝트 중점 사항

- 버전 관리
- 서버의 확장성
- 의존적이지 않은 코드 작성
- Jenkins 이용 CI/CD 환경 구축

### 📌 핵심 기능

- 회원가입 및 로그인
- 회원 등급 로직
    - 회원끼리의 권한 부여
- 게시판 작성
- 게시판 정보 보기 권한

### 📁 프로젝트 ISSUE 
| ISSUE | 링크 |
|-----|------|
| 기술스택 사용 여부 | https://www.notion.so/ssunsoolzip/7aa03f6fda434309bff31ba59ec6b3dc |
| spring AOP | https://www.notion.so/ssunsoolzip/AOP-checkLoginAndProcessResult-Transactional-9db40e64bb6e44ebaad3f07651fd3905 |
| Web MVC |https://www.notion.so/ssunsoolzip/Spring-Web-MVC-74693deeee7f4a45955e6399ec030420 |

### ⛓️ Github PR 방식

#### ✔️ 브랜치 전략

- Main : 배포했거나 곧 배포할 코드 관리합니다.
- Develop : 배포할 것을 개발하는 코드를 관리합니다. 배포할 시에 Master로 merge 합니다.
- Feature : 기능 개발을 진행할 때 사용합니다. 기능을 완성할 때까지 유지하고 완성 시 Develop 브랜치로 merge 합니다.
- Release : 배포를 준비하는 브랜치로 배포를 필요한 메타데이터를 준비합니다.
- Hotfix :  배포한 버전에서 발생한 버그를 수정하는 브랜치입니다.


````````

[다음카카오-길냥이를 부탁해 참고자료]

- http://www.itdaily.kr/news/articleView.html?idxno=57924
- http://www.ekoreanews.co.kr/news/articleView.html?idxno=7476

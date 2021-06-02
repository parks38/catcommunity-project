# 🐱 길냥이를 부탁해

### 📌 프로젝트 개요

'길냥이를 부탁헤'는 다음카카오에서 출시한 적이 있던 서비스를 모티브로 제작한 우리 지역 길냥이들과 사람이 공존하는 건강한 지역사회를 위한 프로젝트입니다. 해당 웹사이트의
기능이였던 커뮤니티 게시판 기능과 함께 사용자별 정보의 권한 기능을 추가하여 사용자 경험 개선에 중점을 두어 서비스를 제작하였습니다.

### 📌 프로젝트 목표

- '길냥이를 부탁해'와 같은 커뮤니티 게시판 서비스에 사용자 권한 제한 로직을 통한 문제점 보완
- 객체 지향 디자인 패턴을 적용한 올바른 코드 작성
- 문서화와 TDD를 이용한 코드 작성에 우선순위
- CI/CD를 통한 자동화를 이용하여 협업이 쉬운 프로젝트 구현

#### 💻 개발 환경

Java, Spring Boot, Gradle, MySQL, Redis

### ⛓️ Repo 원본 Link ###
https://github.com/f-lab-edu/cat-caring-community

### 📌 프로젝트 중점 사항

- 버전 관리
- 서버의 확장성
- 의존적이지 않은 코드 작성
- Redis Cache 이용한 사용자 권한 제어 기능 구현
- Jenkins 이용 CI/CD 환경 구축

### 📌 핵심 기능

- 회원가입 및 로그인
- 회원 등급 로직
    - 회원끼리의 권한 부여
- 게시판 작성
- 게시판 정보 보기 권한

### 📁 프로젝트 ISSUE 
----------
| ISSUE | 링크 |
| 기술스택 사용 여부 | https://www.notion.so/ssunsoolzip/7aa03f6fda434309bff31ba59ec6b3dc |
---------

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

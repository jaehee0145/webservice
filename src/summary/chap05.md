### chapter 05 스프링 시큐리티와 OAuth2.0으로 로그인 기능 구현하기  

### 세션 관리 방법 
1. 톰캣 세션을 사용
    - 별다른 설정을 하지 않는 기본적인 경우
    - 톰캣(WAS)에 세션이 저장되기 때문에 2대 이상의 WAS가 구동되는 환경에서는 톰캣들 간의 세션 공유를 위한 추가 설정이 필요 
2. MySQL 같은 DB에 저장
   - 여러 WAS간 공용 세션을 사용할 수 있는 가장 쉬운 방법
   - 로그인 요청마다 DB IO가 발생해 성능상 이슈 발생 가능성
   - 보통 로그인 요청이 많이 없는 백오피스, 사내 시스템에서 사용
3. Redis, Memcached와 같은 메모리 DB를 사용
    - B2C 서비스에서 가장 맣이 사용
    - 실제 서비스로 사용하기 위해서는 Embedded Redis 같은 방식이 아닌 외부 메모리 서버가 필요 

### 기존 테스트에 시큐리티 적용하기
1. `No qualifying bean of type 'com.summer.webservice.springboot.config.auth.CustomOAuth2UserService'`
   - CustomOAuth2UserService 생성하는데 필요한 소셜로그인 관련 설정값들이 없기 때문
   - src/main 환경과 test/main 환경의 차이
   - application.properties가 없으면 main에서 가져오는데 다른 설정은 가져오지 않음
   - 테스트용 application.properties 생성해주면 됨
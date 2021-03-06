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
   - **테스트용 application.properties 생성해주면 됨**

2. 302 status code
   - 인증되지 않은 사용자의 요청을 이동
   - **Mock User 사용**

3. @WebMvcTest 에서 CustomOAuth2UserService를 찾을 수 없음  
   - @WebMvcTest는 WebSecurityConfigurerAdapter, WebMvcConfigurer를 비롯한 @ControllerAdvice, @Controller를 읽는다. 즉, @Repository, @Service, @Component는 스캔 대상이 아니다.  
   - SecurityConfig는 읽었지만 이를 생성하기 위해 필요한 service를 읽을 수 없어서 에러
   - **@WebMvcTest 에서 excludeFilters 옵션을 사용해서 SecurityConfig를 읽지 않게함**

3-1. At least one JPA metamodel must be present
   - @EnableJpaAuditing 를 사용하려면 최소 하나의 @Entity 클래스가 필요한데 @MebMvcTest는 당연히 없다.
   - **@EnableJpaAuditing 과 @SpringBootApplication 을 분리**
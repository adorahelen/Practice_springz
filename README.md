# 스프링 공부
<img width="700" alt="image" src="https://github.com/user-attachments/assets/4de3a958-0604-40e6-8709-92fb61e0a7e9">

## 목차 : 
   
1. 자바에 대한 간단한 역사(SE? EE?)
   - 1996년 JDK 1.0 출시 => 1998년 JS2E 1.2 => 2014년 SE 8
   - 1997년 서블릿 1.0 출시 => 1999년 J2EE 1.2 => 2013년 EE 7
   - SE (Java Standard Edition) : 가장 대중적인 자바 플랫폼(우리가 일반적으로 설치하는 JDK)
   - [java.lang.*, java.util.*, java.awt.*, javax.rmi.*, javax.net.*]
   - EE (Java Enterprise Edition) : Java SE에서 API가 추가된 것, 서버 개발에 필요한 기능을 다수 포함
   - [ JSP, Servlet, JDBC, JNDI, JTA, EJB 등 ]
   - 서블릿 1.0 : HTTP 요청에 응답할 수 있는 축소된 애플리케이션 1997년 출시
   - 서블릿 2.2 : JDBC, JSP, JMS, JTA, 등을 포함하여 1999년 출시 (J2EE) <- 자바2 플랫폼 엔터프라이즈 에디션 
   - 자바 EE 5 (2006년) : JPA 1.0, 공용어노테이션 API 1.0
   - 자바 EE 6 (2009년) : 엔터프라이즈 애플리케이션 기술 ["CDI 1.0"(자바 컨텍스트, 의존성 주입)] + Bean(빈)1.0, 어노테이션 기반 프로그래밍
   - 자바 EE 7 (2013년) : 웹소켓 API, JSON 처리용 자바 API
     * JDBC, try-catch-finally => try-with-resource [try(Connection connection = a.getConnection()),,,try + catch]
   <img width="700" alt="image" src="https://github.com/user-attachments/assets/6b4bff2b-69de-45ca-803d-ff842fceccf0">


2. 자바 플랫폼&엔터프라이즈 애플리케이션
   - 서블릿 : 모든 자바 웹 애플리케이션의 핵심 컴포넌트로 HTTP 요청을 수신하고 응답하는 역할
   - JSP : HTML의 String을 직접 출력하는 작업 없이 인터페이스 만들 수 있음
   - 웹 컨테이너 : 자바 EE 웹 어플리케이션은 자바EE application sever 또는 웹 컨테이너 == 서블릿 컨테이너에서 실행된다.
   - 아파치 톰캣(웹 컨테이너), 글래스피시, 제이보스 및 와일드플라이 등
      * 즉 스프링에 내장된 서버를 사용하지 않는다면, 위에 나열된 서버를 설치하고 구성해야 한다. + JSP/서블릿 이용
        <img width="700" alt="image" src="https://github.com/user-attachments/assets/41b2a9f1-ec85-440b-b713-2495e591a43e">

    
3. 스프링 프레임워크
   - 스프링에서는 스프링 컨테이너(빈=객체)안에서 관리 : 제어의 역전
      * 빈 등록 방법은 @Component, @Configuraion, (@SpringbootApplication은 안에 ComponentScan보유)
      * @Bean은 메소드 대상 <-> @Component는 클래스 대상 (@Service,@Repository,@Controller, @Configuration,는 까보면 있음
   - 컴포넌트 스캔으로 위에서 설정한 컴포넌트 안에 빈들을 읽어와, 상황에 맞게 관리 : 의존성 주입
      * @Autowired : 필드, 생성자, setter메소드에 대해 스프링 컨테이너가 자동으로 빈 주입
   - 요약정리 [컨테이너 안에서 빈을 관리한다. 빈을 주입하거나 빈을 생성하거나 삭제하거나 : Component > @Bean, @Autowired]
   <img width="700" alt="image" src="https://github.com/user-attachments/assets/fe47bc50-e3d1-47a3-8970-8dfbe8957f5c">

   
4. JPA + 하이버네이트 ORM 등
   - H2 : 자바로 작성되어 있는 RDBMS이다. 인메모리 기반이라 재실행시 초기화 (개발시 테스트용)
   - ORM : 자바의 객체와 데이터베이스를 연결하는 프로그래밍 기법 (object-relation-mapping) , DB value를 객체처럼
         * SQL을 사용하지 않고, 자바 언어로만 데이터베이스에 접근해서 다루는 도구 -> ORM
         * SQL Mapper(Mybatis, jdbcTemplate) / ORM(JPA, Hibernate)
         * ORM 안에서, JPA는 인터페이스이고, Hibernate가 프레임워크
     
  <img width="700" alt="image" src="https://github.com/user-attachments/assets/61a6c6a0-5c67-432c-a7c3-e87981585879">
  <img width="700" alt="image" src="https://github.com/user-attachments/assets/8a5a88ae-ba47-400c-a9ac-5134fa84faf3">

     
 
5. 스프링 시큐리티

   

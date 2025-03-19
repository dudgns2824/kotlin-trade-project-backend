## 폴더 구조 예시 (헥사고널 아키텍쳐 + 도메인 주도 개발 방식 + CQRS 패턴 + MSA)

```
│      
├── 서비스명-service/                   # 서비스      
│   ├── src/      
│   │   ├── domain/                 # 도메인 모델      
│   │   │   ├── 도메인/               # 도메인 관련     
│   │   │   │   ├── port # port      
│   │   │   │   │   ├── in (in port)      
│   │   │   │   │   │   ├── query (조회 관련 in port)       
│   │   │   │   │   │   ├── command (Create,Update,Delete 관련 in port)       
│   │   │   │   │   ├── out (out port)
│   │   │   │   │   │   ├── query (조회 관련 out port)       
│   │   │   │   │   │   ├── command (Create,Update,Delete 관련 out port)       
│   │   │   │   ├── service # service 모음      
│   │   │   │   │   ├── query (조회 관련 서비스)       
│   │   │   │   │   ├── command (Create,Update,Delete 관련 서비스)       
│   │   │   │   ├── enumeration # enum 모음  
│   │   │   │   ├── exception # exception 모음          
│   │   ├── application/  # (adapter in과 연결 되는) 어플리케이션 usecase 모음 해당 구현체에서 도메인 별 in port 호출 + 도메인 의 조합으로 이루어진 비즈니스 로직 adapter in 에서 호출 되어 사용됨.       
│   │   │   ├── query
│   │   │   ├── command    
│   │   │── adapter       
│   │   │   │── in # rest api controller      
│   │   │   │   │── web/ # REST API      
│   │   │   │   │── grpc/ # GRPC      
│   │   │   │   │── kafka/ # KAFKA      
│   │   │   │── out # out adapter      
│   │   │   │   │── jpa      
│   │   │   │   │   ├── 도메인 명      
│   │   │   │   │   │   ├── entity      
│   │   │   │   │   │   │   ├── id # entity embeddedId 모음      
│   │   │   │   │   │   ├── repository      
│   │   │   │   │   │   │   ├── query (조회 관련 repository)       
│   │   │   │   │   │   │   │   ├── interface (jpaRepository)       
│   │   │   │   │   │   │   │   ├── support (JPAQueryFactory를 이용한 querydsl로 작성된 구현체)       
│   │   │   │   │   │   │   ├── command (Create,Update,Delete 관련 repository)       
│   │   │   │   │   │   │   │   ├── interface (jpaRepository)       
│   │   │   │   │   │   │   │   ├── support (JPAQueryFactory를 이용한 querydsl로 작성된 구현체)       
│   │   ├── infrastructure/         # 보안, DB 연결 등      
│   │   │   ├── config/             # DB 설정      
│├── build.gradle            # Gradle 설정      
│      
├── api-gateway/                      # API Gateway
│   ├── src/
│   │   ├── routes/               # routes      
│   │   ├── filters/               # filters      
│   │   ├── security/           # JWT 및 보안 인증 관련 코드      
│   ├── build.gradle                  # API Gateway 관련 설정
│
├── eureka-server/                    # Eureka Server (서비스 디스커버리)
│   ├── src/
│   ├── build.gradle                  # Eureka 서버 관련 설정
│
└── spring-cloud-config/              # Spring Cloud Config Server
    ├── src/
    ├── build.gradle                  # Spring Cloud Config Server 설정      
```
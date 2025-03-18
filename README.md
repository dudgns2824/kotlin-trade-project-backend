## 폴더 구조 예시 (헥사고널 아키텍쳐 + 도메인 주도 개발 방식 + CQRS 패턴)

```
│      
├── 서비스명-service/                   # 서비스      
│   ├── src/      
│   │   ├── domain/                 # 도메인 모델      
│   │   │   ├── user/               # 도메인 관련      
│   │   │   │   ├── UserEntity.kt   # 도메인 엔티티 모델      
│   │   │   │   ├── UserService.kt  # 서비스      
│   │   │   │   ├── UserRepository.kt # 사용자 리포지토리      
│   │   ├── application/            # 애플리케이션 서비스      
│   │   │   ├── UserApplicationService.kt  # 사용자 관련 애플리케이션 서비스      
│   │   ├── infrastructure/         # 보안, DB 연결 등      
│   │   │   ├── config/             # DB 설정      
│   │   │   ├── security/           # JWT 인증 관련 코드      
│   │   ├── build.gradle            # Gradle 설정      
│      
├── api-gateway/                      # API Gateway
│   ├── src/
│   │   ├── controller/               # 사용자 관련 컨트롤러
│   ├── build.gradle                  # API Gateway 관련 설정
│   ├── application.yml               # Eureka 설정 및 API Gateway 설정
│
├── eureka-server/                    # Eureka Server (서비스 디스커버리)
│   ├── src/
│   │   ├── application.yml           # Eureka 설정
│   ├── build.gradle                  # Eureka 서버 관련 설정
│
└── spring-cloud-config/              # Spring Cloud Config Server
    ├── src/
    │   ├── application.yml           # Config 서버 설정
    ├── build.gradle                  # Spring Cloud Config Server 설정
```

## 명명 규칙 (파일명)

### 클래스, 인터페이스 명명 규칙
```
기본적으로 ts 앞까지 붙여서 파일 생성 user.entity.ts -> UserEntity      
query-jwt.use-case.ts -> QueryJwtUseCase      
```

### 파일 이름이 두 의미로 띄워서 만들어야 할 경우
```
example) userRole.ts      
 -> user-role.type.ts 중간에 하이픈 넣어서 명명      
database는 한 단어이므로 database.ts      
```

### 포트와 상속받아 사용하는 구현체에는 CQRS 패턴을 적용 권고
```
CQRS(Command Query Responsibility Segregation) 패턴을 적용.      

Command (생성, 수정, 삭제): 상태를 변경하는 로직을 포함      example) command-jwt.use-case.ts
Query (조회, 읽기): 데이터 조회만 담당      example) query-jwt.use-case.ts
```

### dto request, response 명명 규칙
```
request -> request-이름.dto.ts      
response -> response-이름.dto.ts      
```

### enumeration 명명 규칙
```
이름.type.ts 으로 명명 ex) user-role.type.ts      
export enum UserRoleType {      
  ADMIN = 'admin',      
  USER = 'user',      
}      
```
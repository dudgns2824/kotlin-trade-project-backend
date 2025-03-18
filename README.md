## 폴더 구조 예시 (헥사고널 아키텍쳐 + 도메인 주도 개발 방식 + CQRS 패턴)

```
무슨 근스트js여 kotlin해~
src/      
│── domain/ DDD를 위한 도메인 모음      
│   ├── domain-도메인 명 (추상체)/      
│   │   ├── src/main/kotlin      
│   │   │   ├── dto/ response dto model      
│   │   │   │   ├── response/ response dto model      
│   │   │   │   ├── request/ 요청 dto model        
│   │   │   ├── enumeration/ enum 모음      
│   │   │   ├── port/ 포트       
│   │   │   │   ├── in/ in-포트      
│   │   │   │   │   ├── query       
│   │   │   │   │   ├── command      
│   │   │   │   ├── out/ out-포트      
│   │   │   │   │   ├── query      
│   │   │   │   │   ├── command    
│   ├── domain-도메인 명-client (구현체)/      
│   │   ├── src/main/kotlin      
│   │   │   ├── entity (entity 모음)      
│   │   │   ├── enumeration (exception 관련)      
│   │   │   ├── repository/ querydsl 구현체 및 jpa 추상체 (out adapter)      
│   │   │   ├── service/ 서비스 (비즈니스 로직 구현체 폴더)      
│   │   │   │   ├── query      
│   │   │   │   ├── command      
│   │   │   ├── util      
│── 프로젝트 명      
│   ├── adater-data-jpa   jpa 및 db 연결을 위한 폴더      
│   │   ├── src/main/kotlin      
│   │   │   ├── config/ db 설정      
│   ├── connector rest api (in adapter) + service 호출 역할      
│   │   ├── src/main/kotlin      
│   │   │   ├── annotation/ 커스텀 어노테이션       
│   │   │   ├── config/ 설정       
│   │   │   ├── constant/ 상수       
│   │   │   ├── controller/ 컨트롤러       
│   │   │   ├── dto/ dto       
│   │   │   │   ├── request/ 요청 dto model        
│   │   │   ├── resolver/ 설정       
│   │   │   ├── scheduler/ 스케줄러       
│   │   │   ├── service/ 서비스 구현체 (추상화 할 필요가 없으므로 구현체로 바로 구현)       
│   │   │   ├── util/        
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
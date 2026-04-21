# Schedule Develop

## 📌 프로젝트 소개
Spring Boot와 JPA를 활용하여 일정 관리 API를 구현한 프로젝트입니다.  
일정 CRUD, 유저 CRUD, 회원가입 기능을 단계적으로 구현하였습니다.

---

## 🛠️ 개발 환경
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Gradle

---

## 📂 프로젝트 구조

```bash
src/main/java/com/example/scheduledevelop
├── basic
│   └── entity
│       └── Base.java
├── schedule
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
├── user
│   ├── controller
│   ├── dto
│   ├── entity
│   ├── repository
│   └── service
└── ScheduleDevelopApplication.java
```

## ✅ 구현 기능
Lv1. 일정 CRUD
일정 생성
일정 전체 조회
일정 단건 조회
일정 수정
일정 삭제
Lv2. 유저 CRUD
유저 생성
유저 전체 조회
유저 단건 조회
유저 수정
유저 삭제
연관관계 구현
기존 일정의 작성 유저명 필드를 제거
일정이 유저 고유 식별자(user_id)를 통해 유저를 참조하도록 변경
Schedule과 User 간 연관관계 설정
Lv3. 회원가입
User 엔티티에 password 필드 추가
회원가입 시 비밀번호 저장
비밀번호가 8자 미만일 경우 if문으로 예외 처리



## 📑 API 명세서

<details>
<summary>👤 유저 API</summary>

내용 작성

<details>
<summary>📌 일정 API</summary>

# Schedule API

## Domain

```text
http://localhost:8080
````

---

## 일정 생성 API

### URL

```text
/schedules
```

### Method

```text
POST
```

---

## 1. 설명

새로운 일정을 등록합니다.

---

## 2. 요청 (Request)

### a. Parameter & Query String

없음

| 이름 | 데이터 타입 | 설명 |
| -- | ------ | -- |
| 없음 | -      | -  |

---

### b. Request Headers

없음

| 이름 | 데이터 타입 | 설명 |
| -- | ------ | -- |
| 없음 | -      | -  |

---

### c. Request Body

```json
{
  "title": "일정이름",
  "content": "일정 내용"
}
```

| 이름      | 데이터 타입 | 설명    |
| ------- | ------ | ----- |
| title   | String | 일정 이름 |
| content | String | 일정 내용 |

---

## 3. 응답 (Response)

### a. Response Headers

없음

| 이름 | 데이터 타입 | 설명 |
| -- | ------ | -- |
| 없음 | -      | -  |

---

### b. Response Body

### 성공 응답 : `201 Created`

```json
{
  "scheduleId": 1,
  "userId": 1,
  "title": "일정이름",
  "content": "일정 내용",
  "username": "홍길동",
  "createdAt": "2026-03-11T00:00:00.000Z",
  "modifiedAt": "2026-04-11T00:00:00.000Z"
}
```

| 이름         | 데이터 타입        | 설명    |
| ---------- | ------------- | ----- |
| scheduleId | Long          | 일정 ID |
| userId     | Long          | 유저 ID |
| title      | String        | 일정 이름 |
| content    | String        | 일정 내용 |
| username   | String        | 작성자   |
| createdAt  | LocalDateTime | 생성 일시 |
| modifiedAt | LocalDateTime | 수정 일시 |

</details>
```

내용 2

</details>

<details>
<summary>🔐 인증 API</summary>

내용 작성

</details>

<details>
<summary>📅 일정 API</summary>

내용 작성

</details>

<details>
<summary>💬 댓글 API</summary>

내용 작성

</details>





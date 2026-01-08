#1. 1차 API 문서:
Backend → Frontend 

## 📌 1. 접속자 수 조회

---

### 🔹 [GET] `/comento/users` - 접속자 수 조회

**설명**:

서비스에 접속한 user 수를 조회하는 API

---

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost/comento/users`
- **Headers**: 없음.
- **Form Data**: 없음.

---

### 📥 응답 예시 (`200 OK`)

```json
{
   "connectedUserCount": 128
}

```

---

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 500 | INERNAL_SERVER_ERROR | 서버 오류 |

---

---

## 📌 2. 부서 별 접속자 수 조회

---

### 🔹 [GET] `/comento/users/{department_id}` - 부서 별 접속자 수 조회

**설명**:

부서 별로 해당 서비스에 접속한 수를 조회하는 API

---

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost/comento/users/{department_id}`
- **Headers**: 없음.
- **PathVariable**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| department_id | Integer (필수) | 부서 ID |
- **Form Data**: 없음.

---

### 📥 응답 예시 (`200 OK`)

```json
{
  "department": {
    "id": 3,
    "name": "Engineering"
  },
  "connectedUserCount": 27
}

```

---

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 404 | 존재하지 않는 부서입니다. | 존재하지 않는 부서 ID 일 때 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

## 📌 3. 해당 날짜 로그인 요청 수 조회

---

### 🔹 [GET] `/comento/logins/count?date={login_date}` - 해당 날짜 로그인 요청 수 조회

**설명**:

해당 날짜 로그인 요청 수를 조회하는 API

---

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost/comento/logins/count?date={login_date}`
- **Headers**: 없음.
- **Form Data**: 없음.
- **Query Parameter:**

| 이름 | 타입 | 필수 | 설명 |
| --- | --- | --- | --- |
| date | string (YYYY-MM-DD) | ✅ | 해당 날짜 로그인 요청 수 조회 |

---

### 📥 응답 예시 (`200 OK`)

```json
{
  "date": "2026-01-03",
  "loginCount": 342
}
```

---

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | 날짜 형식이 올바르지 않습니다. | 날짜 형식 올바르지 않을 때 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

## 📌 4. 로그인 요청 수 조회

---

### 🔹 [GET] `/comento/logins/count` - 로그인 요청 수 조회

**설명**:

전체 로그인 요청 수를 조회하는 API

---

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost/comento/logins/count`
- **Headers**: 없음.
- **Form Data**: 없음.

---

### 📥 응답 예시 (`200 OK`)

```json
{
  "loginCount": 342
}
```

---

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

## 📌 5. 게시글 작성 수 조회

---

### 🔹 [GET] `/comento/posts/count` - 게시글 작성 수 조회

**설명**:

게시글 작성 수를 조회하는 API

---

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost/comento/posts/count`
- **Headers**: 없음.
- **Form Data**: 없음.

---

### 📥 응답 예시 (`200 OK`)

```json
{
"board": {
"id": 3,
"title": "자유게시판"
},
"postCount": 1
}

```

---

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

<작성 문서>
- Word:: [API문서_코멘토_권태윤_260103.docx](https://github.com/user-attachments/files/24415496/API._._._260103.docx)
- notion:: https://www.notion.so/API-2dd98cfebe1e80d68de2cbf9e0749274?source=copy_link

# 2. REST API

## 2-1. HTTP 통신이란?

HTTP(HyperText Transfer Protocol)는 클라이언트(브라우저, 앱)가 서버(웹 서버, API 서버)에 요청(Request)을 보내고 응답(Response)을 받기 위한 통신 규칙(프로토콜)이다.

### HTTP 통신 구조
HTTP는 요청(Request) → 응답(Response) 구조로 동작한다.

#### 요청(Request)
클라이언트가 서버에 보내는 데이터
- 요청 메서드 (GET, POST 등)
- URL
- Header
- Body (선택)

예시:
GET /api/v1/boards/1 HTTP/1.1  
Host: example.com  
Authorization: Bearer xxx  

#### 응답(Response)
서버가 클라이언트에 반환하는 데이터
- 상태 코드 (200, 404 등)
- Header
- Body

예시:
HTTP/1.1 200 OK  
Content-Type: application/json  

{
  "id": 1,
  "title": "게시글 제목"
}

### HTTP의 주요 특징
- 무상태성(Stateless): 서버는 이전 요청을 기억하지 않으며, 로그인 정보는 쿠키·세션·JWT로 보완한다.
- 비연결성(Connectionless): 요청과 응답 후 연결을 종료하며, HTTP/1.1부터 Keep-Alive를 지원한다.
- 텍스트 기반 통신: JSON, HTML 등 사람이 읽을 수 있는 형식이다.

### HTTP 메서드
- GET: 데이터 조회
- POST: 데이터 생성
- PUT: 데이터 전체 수정
- PATCH: 데이터 일부 수정
- DELETE: 데이터 삭제

### HTTP 상태 코드
- 200: 성공
- 201: 생성 성공
- 400: 잘못된 요청
- 401: 인증 필요
- 403: 권한 없음
- 404: 리소스 없음
- 500: 서버 오류

### HTTP vs HTTPS
- HTTP: 평문 통신, 포트 80
- HTTPS: SSL/TLS 적용 암호화 통신, 포트 443
※ 실제 서비스에서는 HTTPS 사용이 필수이다.

### 백엔드 개발 관점에서의 HTTP
- Spring Controller의 @GetMapping, @PostMapping
- REST API 설계
- JWT 인증 (Authorization Header)
- Next.js ↔ Spring 서버 통신

## 2-2. 브라우저에 URL 입력 후 요청하여 서버에서 응답하는 과정

1. URL 입력  
사용자가 브라우저 주소창에 다음과 같은 URL을 입력한다.  
https://www.example.com/boards/1  
브라우저는 프로토콜(https), 도메인(www.example.com), 경로(/boards/1)를 해석한다.

2. DNS 조회 (Domain → IP)  
브라우저 캐시, OS 캐시, 라우터 캐시를 확인한 뒤 ISP DNS 서버에 질의하여 IP 주소를 획득한다.  
네트워크 통신은 IP 주소 기반으로 이루어진다.

3. TCP 연결 (3-way handshake)  
클라이언트와 서버는 신뢰성 있는 연결을 위해 3-way handshake를 수행한다.  
SYN → SYN+ACK → ACK 순서로 연결이 수립된다.

4. TLS 핸드셰이크 (HTTPS인 경우)  
서버 인증서를 전달받아 검증하고 대칭키를 생성하여 암호화 통신을 준비한다.  
HTTP인 경우 해당 과정은 생략된다.

5. HTTP 요청 전송  
브라우저는 서버로 HTTP 요청을 전송한다.  
GET /boards/1 HTTP/1.1  
Host: www.example.com  

6. 서버 내부 처리 (Spring 기준)  
요청은 Web Server/WAS를 통해 수신된 후 Filter, Interceptor를 거쳐 Controller에 매핑된다.  
Service 로직이 실행되고 DB 조회 후 응답 데이터가 생성된다.

7. HTTP 응답 반환  
서버는 처리 결과를 HTTP 응답으로 반환한다.

8. 브라우저 렌더링  
브라우저는 HTML을 파싱해 DOM을 생성하고, CSSOM과 결합해 Render Tree를 만든다.  
이후 Layout과 Paint 과정을 거쳐 화면에 출력한다.

9. 추가 리소스 요청  
HTML에 포함된 CSS, JavaScript, Image 등에 대해 추가 HTTP 요청이 발생한다.

전체 흐름 요약  
URL 입력 → DNS 조회 → TCP 연결 → TLS 핸드셰이크 → HTTP 요청 → 서버 처리 → HTTP 응답 → 브라우저 렌더링

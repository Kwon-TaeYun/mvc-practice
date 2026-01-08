1. 1차 API 문서:
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

2. RestAPI ?
2-1. HTTP 통신이란?

1️⃣ HTTP란?
HTTP (HyperText Transfer Protocol) 는
👉 클라이언트(브라우저, 앱) 가
👉 서버(웹 서버, API 서버) 에
요청(Request)을 보내고, 서버가 응답(Response)을 주는 규칙(프로토콜) 입니다.

2️⃣ HTTP 통신 구조: 요청 → 응답 구조.

📤 요청(Request): 클라이언트가 서버에 보내는 것
- 요청 메서드 (GET, POST 등)
- URL
- 헤더(Header)
- 바디(Body, 선택)

예시:
GET /api/v1/boards/1 HTTP/1.1
Host: example.com
Authorization: Bearer xxx

📥 응답(Response): 서버가 클라이언트에 보내는 것
- 상태 코드 (200, 404 등)
- 헤더(Header)
- 바디(Body)

예시:
HTTP/1.1 200 OK
Content-Type: application/json

{
  "id": 1,
  "title": "게시글 제목"
}

3️⃣ HTTP의 주요 특징
✅ 무상태성 (Stateless)

서버는 이전 요청을 기억하지 않음

로그인 정보 → 쿠키, 세션, JWT로 보완

✅ 비연결성 (Connectionless)

요청 1번 → 응답 1번 → 연결 종료

성능 개선을 위해 HTTP/1.1부터 Keep-Alive 사용

✅ 텍스트 기반

사람이 읽을 수 있음 (JSON, HTML 등)

4️⃣ HTTP 메서드
메서드	의미
GET	데이터 조회
POST	데이터 생성
PUT	데이터 전체 수정
PATCH	데이터 일부 수정
DELETE	데이터 삭제
5️⃣ HTTP 상태 코드
코드	의미
200	성공
201	생성 성공
400	잘못된 요청
401	인증 필요
403	권한 없음
404	리소스 없음
500	서버 오류
6️⃣ HTTP vs HTTPS
HTTP	HTTPS
평문 통신	암호화 통신
보안 취약	SSL/TLS 적용
포트 80	포트 443

👉 실제 서비스에서는 HTTPS 필수

7️⃣ 백엔드 개발 관점에서의 HTTP

Spring Controller의 @GetMapping, @PostMapping

REST API 설계

JWT 인증 (Authorization 헤더)

Next.js ↔ Spring 서버 통신

2-2. 브라우저에 URL 입력 후 요청하여 서버에서 응답하는 과정
1️⃣ URL 입력: 사용자가 브라우저 주소창에 입력

https://www.example.com/boards/1

브라우저는 다음을 해석합니다:
- 프로토콜: https
- 도메인: www.example.com
- 경로: /boards/1

2️⃣ DNS 조회 (Domain → IP): 브라우저는 도메인을 IP 주소로 바꿔야 합니다.
- 브라우저 캐시 확인
- OS 캐시 확인
- 라우터 캐시 확인
- ISP DNS 서버에 질의
- 최종적으로 IP 획득 (예: 203.0.113.10)

📌 이유: 네트워크 통신은 IP 주소로만 가능

3️⃣ TCP 연결 (3-way handshake)
- 서버 IP를 알게 되면 TCP 연결을 시도합니다.

3-way handshake
클라이언트 → 서버 : SYN
서버 → 클라이언트 : SYN + ACK
클라이언트 → 서버 : ACK

👉 연결 완료

4️⃣ TLS 핸드셰이크 (HTTPS인 경우)
HTTPS라면 암호화 통신을 위한 추가 과정이 있습니다.

서버 인증서 전달
인증서 검증 (CA)
대칭키 생성 및 공유
이후부터 데이터는 암호화

📌 HTTP면 이 과정은 없음

5️⃣ HTTP 요청 전송
브라우저가 서버로 HTTP 요청을 보냅니다.

예시:
GET /boards/1 HTTP/1.1
Host: www.example.com
User-Agent: Chrome
Accept: text/html

6️⃣ 서버 내부 처리
서버에서 일어나는 일 (Spring 기준)

요청 수신 (웹 서버 / WAS)

필터 (JWT 인증, 보안 필터 등)

인터셉터

컨트롤러 매핑 (@GetMapping)

서비스 로직 실행

DB 조회

응답 데이터 생성

7️⃣ HTTP 응답 반환
서버가 결과를 응답합니다.

HTTP/1.1 200 OK
Content-Type: text/html

<html>...</html>


또는

Content-Type: application/json

8️⃣ 브라우저 렌더링
브라우저가 응답을 해석하여 화면에 표시

HTML 파싱 → DOM 생성

CSS 파싱 → CSSOM 생성

DOM + CSSOM → Render Tree

Layout (배치 계산)

Paint (화면에 그림)

9️⃣ 추가 요청 발생
HTML 안에 포함된 리소스:
- CSS
- JS
- 이미지

👉 각각 추가 HTTP 요청 발생

🔁 전체 흐름 한 줄 요약
URL 입력 → DNS → TCP → TLS → HTTP 요청 → 서버 처리 → HTTP 응답 → 브라우저 렌더링

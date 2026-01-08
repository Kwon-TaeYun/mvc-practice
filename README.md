# 1. 1차 API 문서

## 📌 1. 접속자 수 조회

### 🔹 [GET] /comento/users - 접속자 수 조회

설명  
서비스에 접속한 사용자 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/users  
- Headers: 없음  
- Body: 없음  

응답 예시 (200 OK)  
{
  "connectedUserCount": 128
}

에러 응답  
- 500 INTERNAL_SERVER_ERROR : 서버 오류

---

## 📌 2. 부서 별 접속자 수 조회

### 🔹 [GET] /comento/users/{department_id} - 부서 별 접속자 수 조회

설명  
부서별로 해당 서비스에 접속한 사용자 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/users/{department_id}  
- Headers: 없음  

Path Variable  
- department_id (Integer, 필수): 부서 ID  

응답 예시 (200 OK)  
{
  "department": {
    "id": 3,
    "name": "Engineering"
  },
  "connectedUserCount": 27
}

에러 응답  
- 404 : 존재하지 않는 부서입니다.  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

## 📌 3. 해당 날짜 로그인 요청 수 조회

### 🔹 [GET] /comento/logins/count?date={login_date}

설명  
특정 날짜의 로그인 요청 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/logins/count  
- Headers: 없음  

Query Parameter  
- date (String, YYYY-MM-DD, 필수): 조회 날짜  

응답 예시 (200 OK)  
{
  "date": "2026-01-03",
  "loginCount": 342
}

에러 응답  
- 400 : 날짜 형식이 올바르지 않습니다.  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

## 📌 4. 전체 로그인 요청 수 조회

### 🔹 [GET] /comento/logins/count

설명  
전체 로그인 요청 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/logins/count  
- Headers: 없음  

응답 예시 (200 OK)  
{
  "loginCount": 342
}

에러 응답  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

## 📌 5. 게시글 작성 수 조회

### 🔹 [GET] /comento/posts/count

설명  
게시글 작성 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/posts/count  
- Headers: 없음  

응답 예시 (200 OK)  
{
  "board": {
    "id": 3,
    "title": "자유게시판"
  },
  "postCount": 1
}

에러 응답  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

## 작성 문서
- Word: API문서_코멘토_권태윤_260103.docx  
- Notion: https://www.notion.so/API-2dd98cfebe1e80d68de2cbf9e0749274  

---

# 2. REST API

## 2-1. HTTP 통신이란?

HTTP(HyperText Transfer Protocol)는 클라이언트(브라우저, 앱)가 서버(웹 서버, API 서버)에 요청(Request)을 보내고 응답(Response)을 받기 위한 통신 규칙(프로토콜)이다.

HTTP 통신 구조  
HTTP는 요청(Request) → 응답(Response) 구조로 동작한다.

요청(Request) 구성 요소  
- 메서드 (GET, POST 등)  
- URL  
- Header  
- Body (선택)  

응답(Response) 구성 요소  
- 상태 코드  
- Header  
- Body  

HTTP 특징  
- 무상태성(Stateless): 서버는 이전 요청을 기억하지 않음 (쿠키, 세션, JWT로 보완)  
- 비연결성(Connectionless): 요청/응답 후 연결 종료 (HTTP/1.1 Keep-Alive)  
- 텍스트 기반 통신(JSON, HTML 등)  

HTTP 메서드  
- GET: 조회  
- POST: 생성  
- PUT: 전체 수정  
- PATCH: 일부 수정  
- DELETE: 삭제  

HTTP 상태 코드  
- 200 성공  
- 201 생성 성공  
- 400 잘못된 요청  
- 401 인증 필요  
- 403 권한 없음  
- 404 리소스 없음  
- 500 서버 오류  

HTTP vs HTTPS  
- HTTP: 평문 통신, 포트 80  
- HTTPS: SSL/TLS 암호화, 포트 443  

---

## 2-2. 브라우저에 URL 입력 후 요청/응답 과정

1. URL 입력  
2. DNS 조회 (Domain → IP)  
3. TCP 연결 (3-way handshake)  
4. TLS 핸드셰이크 (HTTPS)  
5. HTTP 요청 전송  
6. 서버 처리 (Filter → Interceptor → Controller → Service → DB)  
7. HTTP 응답 반환  
8. 브라우저 렌더링 (DOM → CSSOM → Render Tree → Layout → Paint)  
9. 추가 리소스 요청 (CSS, JS, Image)

전체 흐름 요약  
URL 입력 → DNS → TCP → TLS → HTTP 요청 → 서버 처리 → HTTP 응답 → 브라우저 렌더링

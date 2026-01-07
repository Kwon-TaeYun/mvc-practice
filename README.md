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

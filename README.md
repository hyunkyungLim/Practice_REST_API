# Practice_REST_API
REST API 연습 예제입니다.
## 공통

---

- 모든 오퍼레이션의 응답 형식은 `application/json` 형식으로 구현
- REST API 명세를 기반으로 구현
- HTTP 응답 규약을 최대한 준수
    - `HTTP Method`, `HTTP Code`, `HTTP Header` 등을 적절히 활용
- 공통 응답 양식

```json
{
	"code": 200,
	"message": "성공",
	"data": ...
}
```

## 회원 생성

---

### 이메일 중복 확인

- 요청

```
GET /member/sign-up/check-email
```

- 요청 Parameter

| Name | Type | Description |
| --- | --- | --- |
| email | String | 사용자가 입력한 이메일 |

### 닉네임 중복 확인

- 요청

```
GET /member/sign-up/check-nickname
```

- 요청 Parameter

| Name | Type | Description |
| --- | --- | --- |
| nickname | String | 사용자가 입력한 닉네임 |

### 회원 생성

- 요청

```
POST /member/sign-up
Content-Type: application/json
```

- 요청 Body

| Name | Type | Description |
| --- | --- | --- |
| email | String | 이메일 |
| nickname | String | 닉네임 |
| password | String | 비밀번호 |
| passwordRe | String | 비밀번호 재입력 |
| gender | String | 성별 |
| regionCode | Number | 지역 코드 |

## 댓글

---

### 댓글 작성

- 요청

```
POST /comment
Content-Type: application/json
X-MEMBER-ID: {memberId}
{
	"commentId": Number,
	"contentId", String,
	"content": String
}
```

- 요청 Body

| Name | Type | Description |
| --- | --- | --- |
| commentId | Number | 댓글 고유 ID |
| contentId | String | 콘텐츠 고유 ID |
| content | String | 댓글 내용 |

### 댓글 수정

- 요청

```
PUT /comment
Content-Type: application/json
X-MEMBER-ID: {memberId}
{
	"commentId": Number,
	"contentId", String,
	"content": String
}
```

- 요청 Body

| Name | Type | Description |
| --- | --- | --- |
| commentId | Number | 댓글 고유 ID |
| contentId | String | 콘텐츠 고유 ID |
| content | String | 댓글 내용 |

### 댓글 삭제

- 요청

```
DELETE /comment/{commentId}
X-MEMBER-ID: {memberId}
```

- 요청 Path properties

| Name | Type | Description |
| --- | --- | --- |
| commentId | Number | 댓글 고유 ID |

### 댓글 목록 조회

- 요청

```json
GET /comment
```

- 요청 Parameter

| Name | Type | Description |
| --- | --- | --- |
| contentId | String | 콘텐츠 고유 ID |

## 콘텐츠 북마크

---

### 콘텐츠 북마크 생성

- 요청

```
POST /bookmark
Content-Type: application/json
X-MEMBER-ID: {memberId}
```

- 요청 Body

| Name | Type | Description |
| --- | --- | --- |
| contentId | String | 콘텐츠 고유 ID |

### 콘텐츠 북마크 취소

- 요청

```
DELETE /bookmark
X-MEMBER-ID: {memberId}
```

- 요청 Parameter

| Name | Type | Description |
| --- | --- | --- |
| contentId | String | 콘텐츠 고유 ID |

### 콘텐츠 북마크 목록 조회

- 요청

```
GET /bookmark
X-MEMBER-ID: {memberId}
```

## 콘텐츠

---

### 콘텐츠 목록 조회

- 요청

```
GET /content
```

### 콘텐츠 상세 조회

- 요청

```
GET /content/{contentId}
```

- 요청 Path properties

| Name | Type | Description |
| --- | --- | --- |
| contentId | String | 콘텐츠 고유 ID |

## 코드 목록

---

### 지역 코드 조회

- 요청

```
GET /region-code
GET /region-code/{sido}
GET /region-code/{sido}/{sigungu}
```

- 요청 Path properties

| Name | Type | Description |
| --- | --- | --- |
| sido | Number | 광역시/도 코드 |
| sigungu | Number | 시/군/구 코드 |

## 콘텐츠 통계

---

### 콘텐츠별 사용자 활동 통계

- 요청

```
GET /statistics/content
```

# 작성 예시

## 회원 생성

---

### 이메일 중복 확인

- 요청

```
GET /member/sign-up/check-email
```

- 요청 프로퍼티

| Name | Type | Description |
| --- | --- | --- |
| email | String | 사용자가 입력한 이메일 |
- 응답

```json
{
	"code": 200,
	"message": "성공",
	"data": true
}
```

- 응답 프로퍼티

| Name | Type | Description |
| --- | --- | --- |
| code | Number | 응답 코드 |
| message | String | 응답 메세지 |
| data | Boolean | 중복 확인 결과 값 |

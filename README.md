# Practice_REST_API
REST API 연습 예제입니다.
## 공통

# 기능적 요구사항

## 회원 생성

---

### 이메일 중복 확인

- 사용자는 ‘확인' 버튼을 통해 이메일 중복 여부를 확인한다.
- 일반적인 이메일 정규식 확인을 수행한다.

### 닉네임 중복 확인

- 사용자는 ‘중복 확인’ 버튼을 통해 닉네임 중복 여부를 확인한다.
- 최대 허용하는 이메일의 자릿수는 문자 구분없이 20자로 제한한다.

### 거주지 선택

- 사용자는 3개의 Select Box에서 행정구역 단위로 거주지를 선택한다.
- `시/도`, `시/군/구`, `읍/면/동` 3단계 기준으로 선택 가능하다.
    - ex) 서울시 중구 장충단로 - 서울시(1) 중구(2) 장충단로(3)
- 상세 주소는 제외한다.

### 비밀번호 입력

- 사용자는 ‘비밀번호’와 ‘비밀번호 확인’을 각각 입력하여 동등함을 비교한다.

### 성별 선택

- 사용자는 라디오 박스에서 자신의 성별을 입력한다.

### 회원 생성

- 사용자는 ‘회원 가입' 버튼을 클릭시 자신이 입력한 정보를 기반하여 사용자가 생성된다.
- 회원 생성에 필요한 요소는 `이메일`, `닉네임`, `거주지 지역 코드`, `비밀번호`, `성별`이다.

## 댓글

---

### 댓글 작성

- 사용자는 콘텐츠 상세 화면에서 댓글을 작성한다.

### 댓글 수정

- 사용자는 콘텐츠 상세 화면 댓글 목록에서 자신의 댓글에 한해 댓글을 수정한다.

### 댓글 삭제

- 사용자는 콘텐츠 상세 화면 댓글 목록에서 자신의 댓글에 한해 댓글을 삭제한다.

### 댓글 목록 조회

- 콘텐츠 상세 페이지에서 해당 콘텐츠의 댓글 목록을 조회한다.
- 댓글 목록 조회시 필요한 속성값은 `댓글 ID`, `콘텐츠 ID`, `작성자 닉네임`, `작성일시`, `댓글 내용`이다.

## 콘텐츠 북마크

---

### 콘텐츠 북마크 생성

- 사용자는 콘텐츠 상세 페이지에서 ‘북마크' 아이콘을 클릭할 시 북마크 처리된다.

### 콘텐츠 북마크 취소

- 사용자는 콘텐츠 상세 페이지에서 ‘북마크 취소' 아이콘을 클릭할 시 북마크가 취소된다.

### 콘텐츠 북마크 목록 조회

- 사용자는 별도로 자신이 북마크한 콘텐츠의 목록만을 조회한다.

## 콘텐츠

---

### 콘텐츠 목록 조회

- 콘텐츠 목록 페이지에서 콘텐츠의 목록을 조회할 수 있다.
- 콘텐츠 목록 조회시 필요한 속성값은 `uid`, `주소`, `카테고리`, `위도`, `경도`, `콘텐츠명`, `콘텐츠 개요`이다.

### 콘텐츠 상세 조회

## 콘텐츠 통계

---

### 콘텐츠별 사용자 활동 통계 조회

- 관리자는 콘텐츠별 `북마크 수`, `댓글 수`를 조회한다.


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

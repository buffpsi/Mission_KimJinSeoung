## Title: [2Week] kim jin seoung

### 미션 요구사항 분석 & 체크리스트

---

**1. 필수미션
- 1. 한명의 인스타회원이 다른 인스타회원에게 중복으로 호감표시를 할 수 없습니다.
- 2. 한명의 인스타회원이 11명 이상의 호감상대를 등록 할 수 없습니다.
- 3. 케이스 4 가 발생했을 때 기존의 사유와 다른 사유로 호감을 표시하는 경우에는 성공으로 처리한다.

배경
- 호감상대등록과 호감표시는 동의어입니다.
-  현재 호감표시기능이 구현되어 있고 아래와 같은 예외처리는 이미 구현되어 있습니다.
-  케이스 1 : 현재 로그인을 하지 않으면 호감표시를 할 수 없습니다.
-  케이스 2 : 현재 본인의 인스타ID를 등록하지 않은 회원은 호감표시를 할 수 없습니다.
-  케이스 3 : 현재 본인이 본인의 인스타ID를 호감상대로 등록할 수 없습니다.


케이스 4 SQL
```SQL
SELECT *
FROM likeable_person
WHERE from_insta_member_id = 1
  AND to_insta_member_id = 2;
```

케이스 5 SQL
```SQL
SELECT COUNT(*)
FROM likeable_person
WHERE from_insta_member_id = 1;
```

케이스 6 SQL
```SQL
UPDATE likeable_person
SET modify_date = NOW(),
attractive_type_code = 2
WHERE id = 5;
```

---
**2. 선택미션 - 네이버 로그인**

배경
- 현재 일반 로그인과 카카오, 구글 로그인까지 구현되어 있다.
-  네이버 로그인도 카카오 로그인 구현과정을 그대로 따라하면 된다.

목표
- 카카오 로그인이 가능한것 처럼, 네이버 로그인으로도 가입 및 로그인 처리가 되도록 해주세요.
   - 스프링 OAuth2 클라이언트로 구현해주세요.
- 네이버 로그인으로 가입한 회원의 providerTypeCode : NAVER

SQL
```SQL
# 최초로 네이버 로그인을 통해서 가입이 될 때 실행되어야 할 SQL
# 네이버 앱에서의 해당 회원번호를 2731659195 라고 가정하면
INSERT INTO `member`
SET create_date = NOW(),
modify_date = NOW(),
provider_type_code = 'NAVER',
username = 'NAVER__2731659195',
password = '',
insta_member_id = NULL;
```
---
**체크리스트**
- [x] 1. 필수 미션
- [x] 2. 필수 미션
- [x] 3. 필수 미션1
- [ ] 선택 미션
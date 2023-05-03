## Title: [1Week] kim jin seoung

### 미션 요구사항 분석 & 체크리스트

---

**1. 필수미션 - 호감상대 삭제**

배경

- 현재 localhost:8080/likeablePerson/delete/{id} 형태의 url을 처리해야한다
- 엔티티들은 member-instaMember(insta_member_id를 통해 연결)
- -likeableperson-instaMember(from_insta_member_user 와 to_insta_member_user 관계로 연결)

목표

- localhost:8080/likeablePerson/delete/{id} 형태의 url을 처리하기위해 컨트롤러와 서비스에서는 delete을 처리하기 위한 로직을 작성해야한다.
    - 삭제를 처리하기 전에 해당 항목에 대한 소유권이 본인(로그인한 사람)에게 있는지 체크해야 한다.
- 삭제 후 다시 호감목록 페이지로 돌아와야 한다.
    - rq.redirectWithMsg 함수 사용

SQL

```SQL
DELETE
FROM likeable_person
WHERE id = 5;
```

---
**2. 선택미션 - 구글 로그인**

배경

- 현재 일반 로그인과 카카오 로그인까지 구현되어 있다.
    - 일반 회원의 providerTypeCode : GRAMGRAM
    - 카카오 로그인으로 가입한 회원의 providerTypeCode : KAKAO
    - 스프링 OAuth2 클라이언트로 구현되어 있다.
    - 카카오 개발자 도구에서 앱 등록, 앱으로 부터 앱키(REST API)를 받아서 프로젝트에 삽입하는 과정이 선행되었음
- 구글 로그인도 카카오 로그인 구현과정을 그대로 따라하면 된다.

목표

- 카카오 로그인이 가능한것 처럼, 구글 로그인으로도 가입 및 로그인 처리가 되도록 해주세요.
    - 스프링 OAuth2 클라이언트로 구현해주세요.
- 구글 로그인으로 가입한 회원의 providerTypeCode : GOOGLE

SQL

```SQL
#
최초로 구글 로그인을 통해서 가입이 될 때 실행되어야 할 SQL
# 구글 앱에서의 해당 회원번호를 2731659195 라고 가정
INSERT INTO `member`
SET create_date = NOW(),
modify_date = NOW(),
provider_type_code = 'GOOGLE',
username = 'GOOGLE__2731659195',
password = '',
insta_member_id = NULL;
```

---
**체크리스트**

- [x] 필수 미션
- [ ] 선택 미션

### 1주차 미션 요약

---

**[접근 방법]** ```

- 필수 미션(호감 삭제)
    - [x] 1.likeableperson에 있는 객체라면 삭제할 수 있게하기
    - [x] 2.소유권자의 권한을 통해서 삭제할 수 있게하기
    - [x] 3.rq클래스와, Rsdata를 활용한 리팩토링까지
      **[특이사항]**
      아쉬웠던 점
- 구글 인증 까지 해볼 수 있었지만 코드 캐치업을 제대로 하지 않은 상태에서 필수과제를 하다보니 리팩토링 과정이 많이 필요했다. TTD방식으로 접근하는 법에대해서 알았더라면 좀더 시간을 줄일 수 있었을 것이다.
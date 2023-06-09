![calorieCheckerMainLogo](https://user-images.githubusercontent.com/96284736/225597223-1d862c67-c72a-48be-975b-004d87f1e559.jpg)
# calorieChecker
개인프로젝트</br>
2023.02.23~</br>
JPA와 시큐리티를 학습후 그것들을 적용하여 calorieChecker페이지를 만들었습니다.</br>
전체적인 기능은 오늘먹은 음식에 대한 칼로리를 기록하고 달력으로 그동안 기록한 것을 확인하고 다이어트를 하는 기능을 개발하자는 생각으로 만들었습니다.
# 목차
 - [사용 기술](https://github.com/jungtaemin/Calorie-chacker#사용-기술)
 - [ERD](https://github.com/jungtaemin/Calorie-chacker#ERD)
 - [핵심 기능](https://github.com/jungtaemin/Calorie-chacker#핵심-기능)
 - [프로젝트 후기](https://github.com/jungtaemin/Calorie-chacker#프로젝트-후기)
# 사용 기술


**프레임워크 / 라이브러리**

- java 11 openjdk
- springboot
- SpringBoot Security
- SpringBoot Jpa

**Build tool**
- Gradle

**Data base**
- mysql

**프론트엔드**
- Thymeleaf
- Bootstrap 5
- html/css
- jQuery

**라이브러리**
- Lombok
- MapStruct
# 프로젝트 설계

# ERD
![캡처erd](https://user-images.githubusercontent.com/96284736/225562174-703888f3-71c8-4a18-8d5c-05cc49c5139e.PNG)
* user 테이블은 oauth2 회원가입 정보저장 테이블입니다.
* upload 는 calorie 저장시 이미지 등록을 하면 저장되는 이미지정보 테이블입니다.

# 핵심 기능
## 오늘의 칼로리 적기
### 칼로리 등록
![createCalorie](https://user-images.githubusercontent.com/96284736/225451612-422c6db8-760c-4e4f-9b28-787db677ba79.gif)
* 오늘의 칼로리 적기에서 칼로리 등록하기 버튼을 클릭해서 모달폼에서 음식이름,칼로리,이미지,메모 정보를 입력한 뒤 등록하면 칼로리가 등록된다.
* 밤12시가 지나서 다른날이되기전까지는 칼로리 와 몸무게 기록들은 계속남아있으며 하루가 지날때까지 수정하거나 지울 수 있다.
* x버튼을 누르면 칼로리를 삭제할 수 있다.
* 오늘의 총칼로리는 오늘 저장한 칼로리의 합을 자동으로 계산후 보여준다.
### 칼로리 기록
![showCalander](https://user-images.githubusercontent.com/96284736/225451629-a8efe313-1de1-4150-b032-5bad681364d9.gif)
* 오늘의몸무게를 적고 기록하기를 누르면 총칼로리 정보와 몸무게 정보 그리고 칼로리 정보를 칼로리 기록 달력에 기록한다.
* 기록한 날은 달력에 총칼로리와 몸무게를 출력하고 기록하지 않은날은 출력을 하지않는다.
### 칼로리 상세보기
![detailCalorie](https://user-images.githubusercontent.com/96284736/225451639-0bae1259-c1be-41b6-b063-c250c9cfc1df.gif)
* 칼로리를 클릭하면 등록했던 등록정보들을 볼 수 있다.
## 칼로리 기록 달력
### 칼로리 달력에서 상세보기
![detailCalander](https://user-images.githubusercontent.com/96284736/225451651-1eea249c-0f54-4f92-8a83-da7a7cce32e7.gif)
* 클릭하면 그날 기록한 칼로리와 몸무게를 확인가능하고 칼로리 클릭시 이미지와 메모를 포함한 등록했던 모든 정보를 상세모달로 확인 가능하다.
## OAuth2 소셜 로그인
![dddd](https://user-images.githubusercontent.com/96284736/177117919-f8bfda71-3dc3-4d8a-9d14-97cee6a7419d.PNG)

![ddsda](https://user-images.githubusercontent.com/96284736/177117932-7a2b073d-689c-4aff-b873-879f190402a8.PNG)

![222222](https://user-images.githubusercontent.com/96284736/177118328-d9453773-4556-4a9d-9eb2-28cc04083ab7.PNG)

``` 소셜 로그인을 구현하기위해 스프링시큐리티와 OAuth2를 사용하였습니다.로그인을 하지않으면 글이 등록되지않게 시큐리티의 인가기능으로  로그인된 회원만 글쓰기 권한을 주었습니다.```

## validation
![vali1](https://user-images.githubusercontent.com/96284736/177123414-5d69066c-b1bb-4dc0-9798-da980709a0e1.PNG)
![vali2](https://user-images.githubusercontent.com/96284736/177123421-cb6dbcd7-b026-4a70-8169-37dccd859909.PNG)


```articleForm을 만들어 먼저 view로 폼을 보내서 입력값을 받아 @Validated 로 validation을 적용.글의 내용과 제목을 다 적지않으면 글이 등록되지않으며 각각 제목을 적어주세요,내용을  오류메세지와함께 다시 작성폼으로 돌아온다.  ```


## CRUD
### 글등록
![1p](https://user-images.githubusercontent.com/96284736/177152969-b177ce42-365c-45bc-8529-4c185846e29a.PNG)
```게시글 1페이지```
![2p](https://user-images.githubusercontent.com/96284736/177152976-6c0c1fba-e31f-4cfc-81eb-9d8075f19d5a.PNG)
```게시글 2페이지-글쓰기폼에서 validation을 거치면 글이 등록되는데 최신순 10개씩 페이지가 나뉘어 10개가 넘어 페이지가 2페이지로 넘어갔다.jpa 페이징기능을 사용하여 구현하였다.제목과 구글닉네임+#providerId를 작성자로 작성일(jpa Auditing으로 구현),추천수를 table로 보여준다.글 내용은 클릭하면 상세페이지에서 보인다.```
![게시판~](https://user-images.githubusercontent.com/96284736/177153177-59eee828-7906-4dd1-9034-1a1551b321e0.PNG)
```게시글을 클릭하면 나오는 게시글 상세 페이지 ```
### 글수정
![new](https://user-images.githubusercontent.com/96284736/177153407-665aa189-32ca-4d18-bac0-6ef263884a72.PNG)


``` 내 글 수정/삭제를 누르면 로그인된 아이디로 쓴 글만 게시판별로 나누어서 보여줍니다. ```


![수정~~](https://user-images.githubusercontent.com/96284736/177154490-762396a5-436c-4054-9520-2176380cc3f3.PNG)


``` 수정 버튼을 누르면 작성했던 글을 수정할 수 있습니다.```


![수정함2](https://user-images.githubusercontent.com/96284736/177154506-f4b46468-fb6e-44a1-9674-29921cf707bb.PNG)
![수정함3](https://user-images.githubusercontent.com/96284736/177154540-0bb2ab6f-4f9c-475e-a3eb-c874a9aad430.PNG)



``` 수정 버튼을 눌러 수정한 이미지. 코드로는 service에서 변경감지를 사용해서 Article article = articleRepositoryPort.findById(articleId).orElseThrow();-article객체를 repositorty에서 꺼낸다음 article에 수정 메소드를 만든뒤 article.edit(articleDtoCardBox.getContent(),articleDtoCardBox.getTitle()); -article의 필드값을 변경하고 자동으로 transaction메소드가 끝나면 변경감지로 자동으로 수정되게한다. ```


### 글삭제
![삭제함1](https://user-images.githubusercontent.com/96284736/177154769-57db37f5-25ce-4269-8cd4-4fc1d90d6fd9.PNG)
![삭제함2](https://user-images.githubusercontent.com/96284736/177154777-6c556a5f-754a-40d8-90a8-5ebfbb47981b.PNG)



``` 삭제 버튼을 눌러 삭제한 이미지.코드로는 jpaRepository에서 articleRepository.deleteById(id) 메소드로 articleId로 삭제 ```


## 검색
![검색함](https://user-images.githubusercontent.com/96284736/177154955-63e6cd20-7890-4cbb-aad6-15a454f40ef1.PNG)
![검색함2](https://user-images.githubusercontent.com/96284736/177154958-4c1ae32b-cc7a-43fc-ad7c-03bd1237cdf3.PNG)


``` 쿼리 메소드 @Query 어노테이션을 사용 like %:??% 를 써서 제목과 내용으로 검색되게 만들었습니다. ```



# 프로젝트 후기

mybatis는 익숙했지만 jpa를 쓰는 회사로 갈수는 없을까 해서 되든안되든 일단 jpa로 프로젝트를 만들어는 보자는 생각으로 jpa를 사용한 프로젝트를 만들어 보았습니다.</br>
jpa는 연관관계나 이런개념도 공부하고 제가 거의 생각하면서 코드를 만들려고 노력하였습니다.제가 만든 프로젝트정도로는 jpa를 쓸수 있다고 확실히 말씀드릴수 있을 것 같습니다.</br>
소셜로그인 같은경우는 저는 시큐리티에 익숙하지않아서 보고 치면서 구현을 많이했습니다.</br>
그렇게 해서라도 구현한 이유는 로그인한 정보로 user테이블로 조인해서 개개인이 칼로리정보를 관리하게하기위함이었고 제가 생각한 사이트구현에 꼭 필요한 부분이었기 때문입니다.</br>
혼자서 만든 프로젝트이기때문에 프로젝트를 하면서 전체적인 부분을 전부 코드를 짤 수 있었고 막히는 부분을 해결하면서 새로 알게 된 것도  많습니다.</br>
혼자서 처음부터 끝까지 만든것에 의미를 두고 제가 생각한 처음 계획했던 기능은 다 구현한것 같습니다.만들고 나서 느낀것은 제가 그래도 처음하고자 마음먹은것을 그대로 결국 만들었구나라는 뿌듯함과 포기하지않았던 노력이 저자신에게 칭찬해주고싶습니다.


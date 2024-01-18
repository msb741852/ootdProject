## 👕 오늘 뭐 입지? 

---

### 프로젝트 소개

- 상황 : 저는 외출 하기 전에 항상 오늘 기온이 어떤지 보고 옷을 골라입고 외출합니다.
어떤 옷을 입는게 좋을지 고민될 때 기온별 옷차림표를 참고해서 옷을 골라입고 외출했습니다. 

- 문제 발생 : 하지만 기온별 옷차림표에는 제가 없는 옷들도 있기 때문에 차림표의 추천대로 입지 못하는 경우도 있었습니다.

-> 그래서 내가 어떤 기온대에 어떤 옷을 입었는지 기록하고, 특정 기온대에 입었던 옷들 중 추천해주는 서비스를 만들면 좋겠다고 생각해서 '오늘 뭐 입지?' 프로젝트를 시작하게 되었습니다.

### 개발 기간
2023.12 (2주)


### 사용 기술

- JAVA (11)
- Spring Framework (MVC 패턴)
- MyBatis
- MySql
- JavaScript
- Jquery

### 기본 세팅 (DB)
[쿼리문](https://fallacious-quasar-f1f.notion.site/255c87b446214bde8379becd118e000d?pvs=4)

- DB username = bitstudy
- DB password = tiger123

---

### 📃 페이지 설명 & 기능 설명
<br>

#### 로그인 페이지
<img width="482" alt="스크린샷 2023-12-20 오전 11 19 49" src="https://github.com/msb741852/ootdProject/assets/75235831/e3d5587a-7e10-45a8-908a-69fb587baf74">

- 해당 사이트를 이용하기 위해서는 로그인이 되어 있어야 한다. 인덱스 페이지는 로그인 페이지로 설정하였다.
- 사용자가 입력한 아이디와 비밀번호가 데이터베이스에 있는 정보인지 확인 후, 
  - 일치하는 정보 ⭕️ : 메인페이지로 이동.
  - 일치하는 정보 ❌ : 로그인 페이지에서 일치하는 정보가 없다고 띄워준다.
- 회원가입 버튼 클릭 시 -> 회원가입 페이지로 이동

<br>

#### 회원가입 페이지
<img width="482" alt="스크린샷 2023-12-20 오전 11 32 30" src="https://github.com/msb741852/ootdProject/assets/75235831/af6e2feb-1f37-491d-bb09-6fda4718f5cd">

- input 의 조건에 맞지 않는 값을 넣을 경우 modal 창 띄워준다.
- input을 모두 작성하고 가입하기 버튼을 눌렀을 때, 데이터베이스에 일치하는 아이디가 있는지 확인
  - 일치하는 아이디 ⭕️ : 이미 존재하는 아이디 출력
  - 일치하는 아이디 ❌ : 데이터베이스에 정보가 등록되며, 로그인페이지로 이동
- back 버튼 클릭 시 로그인 페이지로 이동

<br>

#### 로딩 페이지
<img width="482" alt="image" src="https://github.com/msb741852/ootdProject/assets/75235831/bcbbd6d2-8476-4605-bd63-3f5d0882b544">

- 사용자 브라우저 내에 쿠키 중 날짜 쿠키가 있는 지 확인 후
  - 날짜 쿠키가 있을 경우:
    - 오늘 날짜와 비교,
      - 쿠키에 저장된 날짜와 오늘 날짜가 같을 경우 : 메인페이지로 이동
      - 쿠키에 저장된 날짜와 오늘 날짜가 다를 경우 : OpenWeather API를 통해 오늘의 최저, 최고 기온을 가져와 쿠키에 저장하고 난 후, 메인페이지로 이동한다.
  - 날짜 쿠키가 없을 경우: 날짜 쿠키, 최저 기온, 최고 기온 쿠키를 저장하고 난 후 메인페이지로 이동.

<br>

#### 로그인 후 공통 부분
- 모든 페이지에(로그인, 회원가입, 로딩 페이지 제외)서 로그인 세션이 있는지 확인
  - 로그인 세션이 없을 경우, 로그인 페이지로 이동
- 로고(오늘 뭐 입지?) 
  - 클릭 시 메인페이지로 이동
- LOGOUT
  - 클릭 시 '세션 초기화' 되며 로그인 페이지로 이동
- 최저 기온, 최고 기온
  - 오늘의 최저 기온, 최고 기온을 나타내며 쿠키에서 값을 가져와서 출력한다.
- 메뉴 바
  - HOME : 클릭 시 메인페이지로 이동
  - CLOTHES : 클릭 시 옷장 페이지로 이동
  - TODAY : 클릭 시 오늘의 착장 페이지로 이동
  - PAST : 클릭 시 과거 착장 페이지로 이동

#### 메인 페이지
![image](https://github.com/msb741852/ootdProject/assets/75235831/c1049e5a-fb72-4145-828f-5473ac96293c)

- 해당 기온에 추천할 데이터가 없을 경우(왼쪽 사진), 해당 기온에 추천할 데이터가 있을 경우(오른쪽 사진)
- 최저 기온, 최고 기온 쿠키 값을 기준으로 최저 기온(+1, -1)값, 최고 기온(+1, -1)값 모두 만족하는 데이터를 출력한다.
  - Ex) 오늘 최저 기온: -1도, 최고 기온: 4도
    - 최저 기온 : -2 ~ 0도 && 최고 기온 : 3 ~ 5도에 해당하는 착장 기록 데이터

<br>

#### 옷장 페이지
<img width="482" alt="image" src="https://github.com/msb741852/ootdProject/assets/75235831/4dcf74c1-c79a-4110-b55b-a703f8689299">

- 사용자의 고유번호를 기준으로 옷장을 불러와 출력한다.
  - 상의 탭 버튼을 클릭 시 상의를, 하의 탭을 클릭 시 하의를, 아우터 탭을 클릭 시 아우터를 출력한다.
  - (탭의 기본 선택은 상의로 한다.)
- 세션에 저장된 닉네임을 출력한다.
- 자신이 갖고 있는 옷들을 별칭으로 저장, 수정, 삭제하는 페이지이다.
- 옷장에서 저장한 옷들을 오늘의 착장 등록하는 페이지에서 사용할 수 있다.

<br>

#### 오늘의 착장 페이지
<img width="482" alt="image" src="https://github.com/msb741852/ootdProject/assets/75235831/9ff661ba-4027-4da3-a66a-b128a153c443">

- 오늘 어떤 옷을 입었는지 등록할 수 있다.
- 상의, 하의, 아우터는 쿠키에 저장된 사용자 고유번호를 기준으로 해당 사용자의 옷장에 저장된 옷들을 출력한다.
- 상의, 하의, 피드백은 필수 입력이고, 아우터는 선택적으로 등록할 수 있다.
- 선택한 옷들과 작성한 피드백, 오늘 최저 기온, 최고 기온이 데이터베이스에 저장된다.

<br>

#### 착장 기록 페이지
<img width="482" alt="image" src="https://github.com/msb741852/ootdProject/assets/75235831/6c7cad3c-ba82-412a-b157-6880d59622ad">

- 달(월)을 선택할 수 있고, 기본적으로 오늘 날짜 기준으로 해당 달(월)의 데이터를 출력한다.
- 선택한 달의 기록했던 착장들을 출력한다.
- 선택한 달의 기록했던 착장이 없을 경우 데이터가 없다고 출력.
- 착장 기록을 수정(상의, 하의, 아우터, 피드백 수정 가능) 및 삭제 가능.

---

### 오류 수정

- 과거 착장 오류 수정
  - 문제 : 한 자리 달들은 출력이 되지 않는 오류였다.
  - 해결 : mapper 에서 넘어오는 달이 10 보다 작을 경우 0을 붙여서 검색할 수 있도록 변경 

<img width="612" alt="image" src="https://github.com/msb741852/ootdProject/assets/75235831/64b38f37-2afa-4917-8571-5521c9038f14">
 

### 알게 된 점
- mapper 내에서 꺽쇠 (<)를 사용하지 못하니 &lt 를 사용했는데 <= 를 대신 할 &lte는 되지 않는 것이다. %lt; 까지 작성하고 뒤에 =를 추가해주면 <= 와 같이 사용할 수 있다는 점을 알게 되었습니다.

<img width="1215" alt="image" src="https://github.com/msb741852/ootdProject/assets/75235831/4a3dedee-1761-4417-8181-9fcd0db604a9">

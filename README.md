구름 과제 목차

프론트엔드
1. [넷플릭스 클론 코딩](#1-넷플릭스-클론-코딩)
2. [to do list](#2-to-do-list)
3. [Github Finder](#3-Github-Finder)
4. [Spread Sheet](#4-Spread-Sheet)
5. [react CRUD](#5-react-CRUD)



---
## 1. 넷플릭스 클론 코딩

css, html을 사용해서 만든 페이지입니다.


<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/0d2928b9-8c11-4cca-99c4-5646000fd959"></div>


---
## 2. to do list 

css, html, javascript로 만든 to do list 페이지입니다.

### 기능
리스트 생성, 수정, 삭제, 체크 박스 클릭 시 취소선, 전체 삭제를 구현했습니다.

리스트 생성

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/1ce96539-b0cf-470d-a795-b8082e7355e8
"></div>
<br>
<br>

리스트 수정

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/0bc4e68f-b21d-4dbc-b5a0-bf74cde75c05"></div>
<br>
<br>

리스트 삭제

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/bb826bdc-1a47-4adf-80c0-249a4ea54d95"></div>
<br>
<br>

스크롤, 취소선 전체 삭제 

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/a100612d-b629-41ec-9752-70342a8fdd33"></div>


---

## 3. Github Finder

javascript, html, css로 작성한 화면입니다.

github rest api 를 사용하여 git 사용자와 사용자의 리파지토리 정보를 받아 출력하는 페이지입니다.


사용자에게 github user을 입력받아 user의 정보를 출력합니다. 

리파지토리는 수정일순으로 정렬됩니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/a5f0b43f-c33b-47fc-a9d6-5428e4871358"></div>
<br>
<br>

사용자가 잘못된 정보를 입력했을 때 알림.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/dbfa14a9-3d84-440a-ba29-274475542b1c"></div>



---


## 4. Spread Sheet

구글의 Spread sheet를 클론코딩한 페이지입니다.


테이블의 모든 칸에 입력 가능하고, 좌측상단에 focus된 셀의 좌표값을 표시해줍니다.
focus된 셀의 행과 열의 헤더에 하이라이트됩니다.

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/5b12cef4-0b20-4303-9eef-d15791fdfd01"></div>

<br>
<br>

좌측상단의 "Export SpreadSheet"를 클릭하면 Blob 객체를 사용하여 CSV 데이터를 포함하는 새로운 Blob을 생성합니다. 

이후 URL.createObjectURL를 사용하여 url 생성 후 클릭하여 사용자에게 다운받을 경로와 파일 이름을 받은 후 저장합니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/b3979970-1e94-42b3-be8e-d2920a8540b9"></div>

<br>
<br>

다운받은 scv파일을 구글 spread sheet에서 import하여 값이 같은지 확인합니다.

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/fb0f16d9-5931-47da-aebf-e887e7cc63a1"></div>

<br>
<br>



## 5. react CRUD 


리액트를 사용하여 로컬스토리지 CRUD 기능이 있는 예산계산기입니다.

개발하면서 재사용성 높은 코드를 구현하기 위해 컴포넌트를 최대한 분리하여 개발했습니다.


생성기능입니다. 지출항목과 비용을 작성하고 제출버튼을 누르면 해당 아이템이 추가되고 알람으로 알려줍니다.

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/31a6cbee-46ca-4c21-bd2d-8fbff12eefbc"></div>

<br>
<br>

수정기능입니다. 수정하고 싶은 아이템의 수정버튼을 누르면 입력에 수정 아이템의 값이 들어가 수정할 수 있게 됩니다. 

수정을 다 했으면 제출버튼에서 바뀐 수정버튼을 눌러 수정을 완료합니다.


<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/1675f98f-7efa-43d2-89da-0314f5651919"></div>

<br>
<br>

삭제버튼입니다. 삭제하고 싶은 아이템의 삭제버튼을 눌러 아이템 단일 삭제를 할 수 있습니다.

모든 아이템을 삭제하고 싶으면 목록 지우기버튼을 눌러 모두 삭제합니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/bce96b2b-fa70-4a64-bbf6-6ac26da8b6aa"></div>

<br>
<br>
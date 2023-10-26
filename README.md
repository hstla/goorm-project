# 구름 과제 목차

## 백엔드

1. [LinkedList 구현하기](#1-LinkedList-구현)
2. [장바구니 구현하기](#2-장바구니-구현)
3. [응답/에러모델 만들기](#응답/에러모델-만들기)


## 프론트엔드
1. [넷플릭스 클론 코딩](#1-넷플릭스-클론-코딩)
2. [to do list](#2-to-do-list)
3. [Github Finder](#3-Github-Finder)
4. [Spread Sheet](#4-Spread-Sheet)
5. [react CRUD](#5-react-CRUD)
6. [shopping mall](#6-shopping-mall)
7. [note app](#7-note-app)


---

# 백엔드

## 1. LinkedList 구현

### 설명

Node 클래스를 Doubly Linked list로 구현하여 자바의 LinkedList 의 add(generic g), get(index i), delete(index i) 메서드를 구현했습니다.

노드에 들어가는 데이터의 타입은 LinkedList를 생성할 때 정할 수 있도록 제네릭으로 구현했습니다.

Iterable 를 implements 하여 for-each 로 순회 가능하도록 했습니다.

구현한 LinkedList 로 Queue 와 stack 를 구현했습니다.

Junit5와 AssertJ 로 테스트 코드를 작성했습니다.


[LinkedList 구현 폴더 링크](https://github.com/hstla/goorm-project/tree/main/b1-LinkedList)

## 2. 장바구니 구현

HashSet과 HashMap 으로 장바구니를 구현했습니다.

### 설명

HashSet으로 상품 목록을 만들고, HashMap을 사용해서 장바구니에 상품을 저장합니다.

HashSet에 같은 상품이 중복되지 않도록 equals와 hashCode메서드를 override 했습니다. equals는 key가 같은 상품을 같다고 구현했고, hashCode는 key, name, price 값을 이용하도록 설정했습니다.

장바구니(Cart)에 상품을 추가하려면 수량을 정해야 하고 showItems(), addProduct(), removeProduct() 메서드를 구현하여 장바구니 보기, 상품 추가, 상품 삭제를 구현했습니다.

장바구니에서 상품 제거 시 장바구니에 담긴 상품이 없거나 제거하려는 상품의 수가 기존 상품의 수보다 많으면 에러를 반환합니다.

장바구니 보기 기능은 장바구니에 들어 있는 상품 이름과 상품 개수를 출력합니다.

Junit5와 AssertJ로 테스트 코드를 작성했습니다.


[장바구니 구현 폴더 링크](https://github.com/hstla/goorm-project/tree/main/b2-shoppingBasket)



## 3. 응답/에러모델 만들기

spring mvc 를 사용하여 API 요구사항에 맞게 구현했습니다.

### 설명

API 요구사항

성공 응답 예시와 에러 응답 예시

<div style="display: flex; justify-content: center; align-items: flex-start; width: 100%;">
    <img src="https://github.com/hstla/goorm-project/assets/83001865/1d03a51f-54d0-46a4-a90f-afc203c403bb" width="300" style="display: block;">
    <img src="https://github.com/hstla/goorm-project/assets/83001865/cb19d346-7184-4c53-a545-5c6b0298ffc8" width="300" style="margin-left: 40px; display: block;">
</div>

성공 응답과 에러 응답을 하나의 FORM에서 처리하기 위해 제네릭을 사용해서 ApiResponse를 구현했습니다.

프로젝트에 필요한 에러를 enum에 정의하고 RuntimeException을 확장한 CustomException을 구현했고 @ExceptionHandler를 사용하여 커스텀 에러를 처리했습니다.

리파지토리 인터페이스를 도입하여 클래스 간의 연결을 느슨하게 만들었습니다.

MockMvc를 사용하여 HTTP 요청을 시뮬레이션해서 스프링 MVC의 동작을 테스트했습니다.

[응답/에러모델 만들기 링크](https://github.com/hstla/goorm-project/tree/main/b3-Create-Error-Models)



# 프론트엔드

## 1. 넷플릭스 클론 코딩

### 설명

css, html을 사용해서 만든 페이지입니다.

<br>
<br>

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/0d2928b9-8c11-4cca-99c4-5646000fd959"></div>


---
## 2. to do list 

### 설명

css, html, javascript로 만든 to do list 페이지입니다.

### 구현 기능

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

### 설명

javascript, html, css로 작성한 화면입니다.

github rest api 를 사용하여 git 사용자와 사용자의 리파지토리 정보를 받아 출력하는 페이지입니다.

### 구현 기능

사용자에게 github user을 입력받아 user의 정보를 출력합니다. 

리파지토리는 수정일순으로 정렬됩니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/a5f0b43f-c33b-47fc-a9d6-5428e4871358"></div>
<br>
<br>

사용자가 잘못된 정보를 입력했을 때 알림.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/dbfa14a9-3d84-440a-ba29-274475542b1c"></div>



---


## 4. Spread Sheet

### 설명

구글의 Spread sheet를 클론코딩한 페이지입니다.

### 구현 기능

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

### 설명

리액트를 사용하여 로컬스토리지 CRUD 기능이 있는 예산계산기입니다.

개발하면서 재사용성 높은 코드를 구현하기 위해 컴포넌트를 최대한 분리하여 개발했습니다.

### 구현 기능


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

## 6. shopping mall

### 설명

react, typescript, vite를 사용하여 쇼핑몰을 구현했습니다.

fakestoreapi.com 에서 필요한 아이템 데이터를 사용했습니다.


### 구현 기능

firebase의 이메일/비밀번호를 사용하여 회원가입, 로그인기능을 구현했습니다.

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/bbca2066-b9e4-488d-b444-2b0bdd86a704"></div>

<br>
<br>

fakestoreapi.com 에서 가져온 아이템 정보를 카테고리별로 보여주는 홈화면입니다.

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/1ba31689-ac4f-4592-8494-8cb1bc8d182e"></div>

<br>
<br>

로컬스토리지를 사용하여 장바구니 기능을 구현했습니다.

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/c5c674d3-616e-4235-ad1b-8247c756f236"></div>

<br>
<br>

<div align="center"><img src="https://github.com/hstla/hstla.github.io/assets/83001865/dad5e008-8b87-463d-abdd-7c902a9778c0"></div>

<br>
<br>


## 7. note app

### 설명

create,read ,update, delete가 가능한 노틍 앱입니다.

노트 태그기능, 정렬기능을 추가하였습니다.

typescript, react로 구현했고, redux를 사용하여 상태 관리했습니다.

### 구현 기능

노트 생성

노트를 생성하면서 배경색, 중요도, 태그를 넣을 수 있습니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/9422518b-e628-4a04-9afd-831cfc8f86a4"></div>

<br>
<br>

사이드바에서 태그별로 노트를 확인 할 수 있습니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/ebb5f3aa-f644-468a-9fbf-d6b27538c05b"></div>

<br>
<br>

노트의 내용을 수정할 수 있습니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/9a1a5e34-fa86-4342-83aa-5707a6988ca3"></div>

<br>
<br>

삭제버튼을 누른 노트는 Trash태그로 이동합니다. Trash로 이동해 노트를 완전삭제할 수 있습니다.

<div align="center"><img src="https://github.com/hstla/goorm-project/assets/83001865/8bbafebe-b644-442d-8b26-4298ae5a6757"></div>

<br>
<br>

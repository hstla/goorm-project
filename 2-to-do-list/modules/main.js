import { deleteBtnListener, allDeleteTodos } from './delete.js';
import { modifyBtnListener } from './modify.js';

const headerButton = document.querySelector('.newBtn');
const listsContainer = document.querySelector('.lists');
const allDeleteBtn = document.querySelector('.allDelete');

// 리스트 모두 삭제
allDeleteBtn.addEventListener('click', allDeleteTodos);


// 새로고침 시 localStorage에서 todos를 가져와 뿌림. 
const savedTodos = JSON.parse(localStorage.getItem('todos')) || [];
savedTodos.forEach(todo => {
  displayTodo(todo);
});

// TodoList 만들기 버튼 누를 때 이벤트
headerButton.addEventListener('click', createInputForTodo);

// TODO 항목을 생성하고 반환하는 함수
function createTodoItem(todoText) {
  const newListBox = document.createElement('div');
  newListBox.classList.add('listBox');

  newListBox.innerHTML = `
        <div>
            <input type="checkbox">
            <span>${todoText}</span>
        </div>
        <div>
            <button class="modify">
                <img src="img/modify.png">
            </button>
            <button class="delete">
                <img src="img/delete.png">
            </button>
        </div>
    `;

  return newListBox;
}

// TODO를 화면에 표시하는 함수
function displayTodo(todoText) {
  const newListBox = createTodoItem(todoText);
  deleteBtnListener(newListBox);
  modifyBtnListener(newListBox);
  checkLineThrough(newListBox);

  if (listsContainer.firstChild) {
    listsContainer.insertBefore(newListBox, listsContainer.firstChild);
  } else {
    listsContainer.appendChild(newListBox);
  }
}

// 체크되면 텍스트에 밑줄 추가 함수
function checkLineThrough(newListBox) {
  const checkbox = newListBox.querySelector('input[type="checkbox"]');
  checkbox.addEventListener('change', function () {
    const span = newListBox.querySelector('span');
    if (checkbox.checked) {
      span.style.textDecoration = 'line-through';
    } else {
      span.style.textDecoration = 'none';
    }
  });
}

// 새로운 TODO 항목 입력을 위한 input 생성
function createInputForTodo() {
  const newListBox = document.createElement('div');
  newListBox.classList.add('listBox');
  newListBox.innerHTML = `
        <div>
            <input type="text" placeholder="TODO 입력" class="todoInput">
        </div>
    `;

  const inputField = newListBox.querySelector('input[type="text"]');

  inputField.addEventListener('blur', function () {
    const value = inputField.value;
    if (value.trim() !== "") {
      displayTodo(value);
      saveTodo(value);
    }
    newListBox.remove();
  });

  inputField.addEventListener('keyup', function (event) {
    if (event.key === "Enter") {
      inputField.blur();
    }
  });

  if (listsContainer.firstChild) {
    listsContainer.insertBefore(newListBox, listsContainer.firstChild);
  } else {
    listsContainer.appendChild(newListBox);
  }
  inputField.focus();
}

// localStorage에 TODO 항목 저장함수
function saveTodo(todoText) {
  const todos = JSON.parse(localStorage.getItem('todos')) || [];
  todos.push(todoText);
  localStorage.setItem('todos', JSON.stringify(todos));
}
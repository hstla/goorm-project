// 로컬 저장소의 값 변경 함수
function changeTodo(text, changeText) {
  const todos = JSON.parse(localStorage.getItem('todos'));
  const index = todos.indexOf(text);
  todos[index] = changeText;
  localStorage.setItem('todos', JSON.stringify(todos));
}

// span을 input으로 변경 후 값 리턴
function createInputElement(placeholder, callback) {
  const inputField = document.createElement('input');
  inputField.type = 'text';
  inputField.placeholder = placeholder;

  inputField.addEventListener('blur', callback);
  inputField.addEventListener('keyup', function (event) {
    if (event.key === "Enter") {
      inputField.blur();
    }
  });

  return inputField;
}


// 입력받은 값으로 변경 후 span으로 변환
function modifyBtnListener(newListBox) {
  const modifyBtn = newListBox.querySelector('.modify');
  const todoSpan = newListBox.querySelector('span');

  modifyBtn.addEventListener('click', function () {
    const currentText = todoSpan.textContent;
    const inputField = createInputElement(currentText, function () {
      const newText = inputField.value.trim();
      if (newText !== "") {
        changeTodo(currentText, newText);
        todoSpan.textContent = newText;
      }
      inputField.replaceWith(todoSpan);
    });

    todoSpan.replaceWith(inputField);
    inputField.focus();
  });
}

export { modifyBtnListener };
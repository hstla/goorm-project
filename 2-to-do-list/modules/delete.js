// 로컬저장소에서 값 삭제
function deleteTodo(deleteText) {
  const todos = JSON.parse(localStorage.getItem('todos'));
  const index = todos.indexOf(deleteText);
  if (index !== -1) {
    todos.splice(index, 1);
    localStorage.setItem('todos', JSON.stringify(todos));
  }
}

// 버튼 클릭되면 값 삭제
function deleteBtnListener(newListBox) {
  const deleteBtn = newListBox.querySelector('.delete');
  const todoSpan = newListBox.querySelector('span');

  deleteBtn.addEventListener('click', function () {
    deleteTodo(todoSpan.textContent);
    newListBox.remove();
  });
}

function allDeleteTodos() {
  const isDelete = confirm("리스트를 모두 지우시겠습니까?");
  if (isDelete) {
    localStorage.setItem('todos', JSON.stringify([]));
    const allTodoItems = document.querySelectorAll('.listBox');
    allTodoItems.forEach(item => item.remove());
  }
}

export { deleteBtnListener, allDeleteTodos };
document.addEventListener("DOMContentLoaded", function () {
  const table = document.querySelector('.mytable');

  table.addEventListener('focus', function (event) {
    const td = event.target.parentElement;
    const tr = td.parentElement;

    // 현재 행의 첫 번째 td와 현재 열의 첫 번째 th에 하이라이트 클래스 추가
    tr.querySelector('td').classList.add('highlighted');
    table.querySelector(`th:nth-child(${Array.from(tr.children).indexOf(td) + 1})`).classList.add('highlighted');

  }, true);

  table.addEventListener('blur', function (event) {
    // 모든 하이라이트 클래스 제거
    table.querySelectorAll('.highlighted').forEach(el => el.classList.remove('highlighted'));
  }, true);
});


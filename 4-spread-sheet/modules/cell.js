document.addEventListener('DOMContentLoaded', function () {
  const inputs = document.querySelectorAll('table.mytable input');
  // console.log(inputs);

  inputs.forEach(input => {
    input.addEventListener('blur', function () {
      document.querySelector('.cell-location b').textContent = '';
    });

    input.addEventListener('focus', function (event) {
      const td = event.target.parentElement;
      const tr = td.parentElement;

      const col = String.fromCharCode(65 + td.cellIndex - 1);
      const row = tr.rowIndex;

      document.querySelector('.cell-location b').textContent = col + row;
    });
  });
})
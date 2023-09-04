document.querySelector('.div-bnt button').addEventListener('click', function () {
  const table = document.querySelector('.mytable');
  let csv = [];

  for (let i = 1; i < table.rows.length; i++) {
    let row = table.rows[i];
    let rowData = [];
    for (let j = 1; j < row.cells.length; j++) {
      let cell = row.cells[j];
      let input = cell.querySelector('input');
      if (input) {
        rowData.push(input.value);
      } else {
        rowData.push(cell.textContent);
      }
    }
    console.log(rowData);
    csv.push(rowData.join(','));
  }

  // CSV 데이터 생성
  let csvData = new Blob([csv.join('\n')], { type: 'text/csv' });
  let csvURL = URL.createObjectURL(csvData);

  let tempLink = document.createElement('a');
  tempLink.href = csvURL;

  tempLink.download = 'my_data.csv';

  document.body.appendChild(tempLink);
  tempLink.click();
  document.body.removeChild(tempLink);
});

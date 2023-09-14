import React from 'react';

function TotalExpense({ totalCost }) {
  return (
    <div className='w-3/5 m-1 text-right text-3xl'>
      총지출액: <span>{totalCost}</span>원
    </div>
  );
}

export default TotalExpense;

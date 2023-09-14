import React from 'react';

function ClearList({ clearList }) {
  return (
    <div className='mt-4'>
      <button
        className="bg-green-600 hover:bg-red-600 text-white font-bold py-2 px-4 rounded transition transform hover:-translate-y-1 hover:shadow-2xl"
        onClick={clearList}
      >
        목록 지우기
      </button>
    </div>
  );
}

export default ClearList;

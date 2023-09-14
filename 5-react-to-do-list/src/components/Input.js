import React from 'react';

function Input({ expense, setExpense, cost, setCost, handleAction, editingIndex }) {
  return (


    <div>
      <div className='flex space-x-4 justify-center'>
        <label className='flex flex-col items-start text-orange-400 w-1/2'>
          <span className='mb-2'>지출항목</span>
          <input
            type='text'
            placeholder='예) 렌트비'
            className=' w-full text-black border-b border-green-700 outline-none'
            value={expense}
            onChange={e => setExpense(e.target.value)}
          />
        </label>
        <label className='flex flex-col items-start text-orange-400 w-1/2'>
          <span className='mb-2'>비용</span>
          <input
            type='number'
            className=' text-black w-full border-b border-green-700 outline-none'
            value={cost}
            onChange={e => setCost(e.target.value)}
          />
        </label>
      </div>
      <div className='mt-4'>
        <button
          className="hover:bg-blue-500 font-bold py-2 px-4 rounded bg-green-600 text-white transition transform hover:-translate-y-1 hover:shadow-2xl"
          onClick={handleAction}
        >
          {editingIndex !== null ? "수정" : "제출"}
        </button>
      </div>
    </div>
  );
}

export default Input;

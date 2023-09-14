import React from 'react';

function ListItem({ item, index, handleEdit, deleteData }) {
  return (
    <div key={index} className='flex justify-between items-center mb-2 p-2 border transition transform hover:-translate-y-1 hover:shadow-lg'>
      <span className='flex-1 text-left'>{item.name}</span>
      <span className='flex-1 text-center text-gray-400'>{item.price}</span>
      <div className='flex-1 text-right'>
        <button
          className="mx-2 bg-green-500 hover:bg-yellow-400 text-white font-bold py-1 px-2 rounded"
          onClick={() => handleEdit(index)}
        >
          수정
        </button>
        <button
          className="bg-red-500 hover:bg-red-600 text-white font-bold py-1 px-2 rounded"
          onClick={() => deleteData(index)}
        >
          삭제
        </button>
      </div>
    </div>
  );
}

export default ListItem;

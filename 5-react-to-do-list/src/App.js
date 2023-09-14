import './App.css';
import { useState } from "react";
import Alert from './components/Alert.js';
import ClearList from './components/ClearList';
import Header from './components/Header';
import Input from './components/Input';
import ListItem from './components/ListItem';
import TotalExpense from './components/TotalExpense';


const initialTodoData = localStorage.getItem("todoData")
  ? JSON.parse(localStorage.getItem("todoData"))
  : [];

function App() {
  const [todoData, setTodoData] = useState(initialTodoData);
  const [expense, setExpense] = useState('');
  const [cost, setCost] = useState(0);
  const [editingIndex, setEditingIndex] = useState(null);

  const handleEdit = (index) => {
    setExpense(todoData[index].name);
    setCost(todoData[index].price);
    setEditingIndex(index);
  };

  const handleUpdate = () => {
    const updatedTodoData = [...todoData];
    updatedTodoData[editingIndex] = {
      name: expense,
      price: cost
    };
    setTodoData(updatedTodoData);
    localStorage.setItem("todoData", JSON.stringify(updatedTodoData));
    setExpense('');
    setCost(0);
    setEditingIndex(null);

    showAlert("아이템이 수정되었습니다.", "bg-green-500");
  };

  const [alert, setAlert] = useState({
    active: false,
    message: "",
    color: ""
  });

  const showAlert = (message, color) => {
    setAlert({
      active: true,
      message: message,
      color: color
    });

    setTimeout(() => {
      setAlert({
        ...alert,
        active: false
      });
    }, 3000);
  };

  const getTotalCost = () => {
    return todoData.reduce((acc, item) => acc + Number(item.price), 0);
  };

  const handleSubmit = () => {
    const newData = {
      name: expense,
      price: cost
    };
    setTodoData([...todoData, newData]);
    setExpense('');
    setCost(0);
    localStorage.setItem("todoData", JSON.stringify([...todoData, newData]));

    showAlert("아이템이 생성되었습니다.", "bg-green-500");
  };

  const clearList = () => {
    setTodoData([]);
    localStorage.setItem("todoData", JSON.stringify([]));

    showAlert("아이템이 삭제되었습니다.", "bg-red-500");
  };

  const deleteData = (indexRemove) => {
    const updatedTodoData = todoData.filter((_, index) => index !== indexRemove);
    setTodoData(updatedTodoData);
    localStorage.setItem("todoData", JSON.stringify(updatedTodoData));

    showAlert("아이템이 삭제되었습니다.", "bg-red-500");
  };

  return (
    <div className='flex flex-col items-center justify-center w-screen h-screen bg-orange-300'>
      <Alert alert={alert} />
      <Header />
      <div className='w-3/5 p-6 m-4 bg-white rounded'>
        <div>
          <Input
            expense={expense}
            setExpense={setExpense}
            cost={cost}
            setCost={setCost}
            handleAction={editingIndex !== null ? handleUpdate : handleSubmit}
            editingIndex={editingIndex}
          />

          {/* todoData 목록 표시 */}
          <div className='mt-4'>
            {todoData.map((item, idx) => (
              <ListItem
                item={item}
                index={idx}
                handleEdit={handleEdit}
                deleteData={deleteData} />
            )
            )}
          </div>
          {/* 목록 지우기 버튼 추가 */}
          <ClearList clearList={clearList} />
        </div>
      </div>
      <TotalExpense totalCost={getTotalCost()} />
    </div >
  );
}

export default App;

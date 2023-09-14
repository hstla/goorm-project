
import React from 'react';

function Alert({ alert }) {
  return (
    <div className={`flex flex-col w-3/5 ${alert.active ? alert.color : ""}`}>
      <div className={`text-white text-center py-4 ${alert.active ? "" : "hidden"}`}>
        {alert.message}
      </div>
    </div>
  );
}

export default Alert;

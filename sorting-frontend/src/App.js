import React, { useState } from 'react';
import axios from 'axios';

function App() {
  const [sortedArray, setSortedArray] = useState([]);

  const handleSort = async (type) => {
    try {
      const response = await axios.post(`http://localhost:8080/api/sort/${type}`, {
        array: [5, 2, 9, 1, 5, 6]
      });
      setSortedArray(response.data);
    } catch (error) {
      console.error("Error while sorting:", error);
    }
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <h1>Sorting Visualizer</h1>
      <button onClick={() => handleSort('bubble')}>Bubble Sort</button>
      <button onClick={() => handleSort('insertion')} style={{ marginLeft: '10px' }}>Insertion Sort</button>
      <h2>Sorted Array:</h2>
      <p>{sortedArray.join(', ')}</p>
    </div>
  );
}

export default App;

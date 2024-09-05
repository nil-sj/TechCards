import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

import { Starter } from './components/Starter.jsx';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Starter/>
      </header>
    </div>
  );
}

export default App;

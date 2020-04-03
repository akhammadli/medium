import React from 'react';
import './App.css';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Palindrome from './Palindrome'

function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <span>Palindrome checker</span>
        </header>
        <div>
          <Route exact path='/' component={Palindrome} />
        </div>
      </div>
    </Router>
  );
}

export default App;

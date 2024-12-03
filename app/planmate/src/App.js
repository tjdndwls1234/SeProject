// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Login from './pages/Login';
import Register from './pages/Register';
import Course from './pages/Course';
import Transcript from './pages/Transcript';
import Prerequisite from './pages/Prerequisite';
import Index from './pages/Index';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Index />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/transcript" element={<Transcript />} />
        <Route path="/prerequisite" element={<Prerequisite />} />
      </Routes>
    </Router>
  );
}

export default App;

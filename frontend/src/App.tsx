//import { useState } from 'react'
//import reactLogo from './assets/react.svg'
//import './App.css'
//<SalesCard/>

import NotificationButton from "./components/notificationButton"
import Header from "./components/notificationButton/Header"
import SalesCard from "./components/SalesCard"

function App() {
  return (
    <>
      <Header />
      <main>
        <section id="sales">
          <div className="dsmeta-container">
            <SalesCard />
          </div>
        </section>
      </main>
    </>
  )
}

export default App

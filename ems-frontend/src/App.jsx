import './App.css'
import HeaderComponent from './Component/HeaderComponent'
import FooterComponent from './Component/FooterComponent'
import ListEmployeeComponent from './Component/ListEmployeeComponent'

import { BrowserRouter, Routes, Route } from 'react-router-dom'
import EmployeeComponent from './Component/EmployeeComponent'

function App() {
  return (
    <BrowserRouter>
      <HeaderComponent />

      <Routes>
        {/*//http://localhost:3000 */}
        <Route path="/" element={<ListEmployeeComponent />} />

        {/*//http://localhost:3000/employees */}
        <Route path="/employees" element={<ListEmployeeComponent />} />

        {/*//http://localhost:3000/add-employee */}
        <Route path="/add-employee" element={<EmployeeComponent/>}/>

        {/*//http://localhost:3000/update-employee/1 */}
        <Route path="/update-employee/:id" element={<EmployeeComponent />} />

      </Routes>

      <FooterComponent />
    </BrowserRouter>
  )
}

export default App

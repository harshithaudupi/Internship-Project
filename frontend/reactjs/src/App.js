import  React from 'react';
// import { useState } from 'react';
import Container from '@mui/material/Container';
// import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import LogIn from './components/LogIn';
import {BrowserRouter,Routes,Route} from 'react-router-dom';
import Register from './components/Register';
import Home from './components/Home';
import HomeRO from './components/HomeRO';
import ViewCom from './components/ViewCom';
import FileACom from './components/FileACom';
import ResolvedComplaints from './components/ResolvedComplaints';
import UnresolvedComplaints from './components/UnresolvedComplaints';
import Completed from './components/Completed';
import About from './components/About';




export default function App() {
  // const [token, setToken] = useState(localStorage.getItem("authToken"));
  return (
    <Container maxWidth="sm">
      <Box sx={{ my: 4 }}>
      
        <BrowserRouter>
   
                   <Routes>
                      <Route path='/' index element={<LogIn/>}/>
                      <Route path='/register' element={<Register/>}/>
                      <Route path='/home' element={<Home/>}/> 
                      <Route path='/viewcom' element={<ViewCom/>}/>
                      <Route path='/fileacom' element={<FileACom/>}/>
                      <Route path='/homero' element={<HomeRO/>}/>
                      <Route path='/resolvedComplaints' element={<ResolvedComplaints/>}/>
                      <Route path='/unresolvedComplaints' element={<UnresolvedComplaints/>}/>
                      <Route path='/completed' element={<Completed/>}/>
                      <Route path='/about' element={<About/>}/>
                   </Routes>
         </BrowserRouter>
      
        </Box>
    </Container>
  );

}




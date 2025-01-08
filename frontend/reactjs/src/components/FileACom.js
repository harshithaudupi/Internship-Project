import * as React from 'react';
import {useState} from 'react'
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import AddAPhotoIcon from '@mui/icons-material/AddAPhoto';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { red } from '@mui/material/colors';
//import { AppBar } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import MyAppBar from './MyAppBar';
import axios from 'axios';


const theme = createTheme();


export default function FileACom() {
  const navigate = useNavigate();

  const[complaintType,setcomplaintType]=useState("");
  const[complaintDetails,setcomplaintDetails]=useState("");
  const[dateOfReg,setdateOfReg]=useState("");
  const[state,setstate]=useState("");
  const[locality,setlocality]=useState("");
  const[hSno,sethSno]=useState("");
  const[landmark,setlandmark]=useState("");

  
   
  const navigateCompleted=async(e)=>{
       navigate("/completed");
  }

  const handleSubmit=(event) => {
    
    event.preventDefault(); 

    const data = {
      "complaintType":complaintType,
      "complaintDetails":complaintDetails,
      "dateOfReg": dateOfReg,
      "state": state,
      "locality": locality,
      "hSno": hSno,
      "landmark" : landmark
    };

    try{
      axios.post("http://localhost:1090/complaints/fileAComplaint",data);
      navigateCompleted();
      
    }
    catch(error){
      console.error(error);
    }
    
  };
 
  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
           <MyAppBar/>
        <Box
          sx={{
            marginTop: 3,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
            
          <Typography component="h1" variant="h5">
            e-Sahayatha
          </Typography>
          <Avatar sx={{ m: 1, bgcolor: red[400] }}>
            <AddAPhotoIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Upload Photos
          </Typography>
          </Box>
          
          <Box component="form" onSubmit={handleSubmit} noValidate sx={{ mt: 1 }}>
          <FormControl fullWidth>
                 <InputLabel id="complaintType">Complaint Type</InputLabel>
            <Select
              labelId="complaintType"
              id="complaintType"
              label="complaintType"
              onChange={(e) =>setcomplaintType(e.target.value)}
             >
               <MenuItem value="Non Sweeping Of Roads">Non Sweeping Of Roads</MenuItem>
               <MenuItem value="Non Clearing Of Garbage">Non Clearing Of Garbage</MenuItem>
               <MenuItem value="Damage Of Street Lights">Damage Of Street Lights</MenuItem>
               <MenuItem value="Water Logging">Water Logging</MenuItem>
               <MenuItem value="Potholes">Potholes</MenuItem>
          
           </Select>
         </FormControl> 
            <TextField
              margin="normal"
              required
              fullWidth
              id="complaintDetails"
              label="complaintDetails"
              name="complaintDetails"
              onChange={(e) =>setcomplaintDetails(e.target.value)}
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="dateOfReg"
              label="dateOfReg"
              name="dateOfReg"
              onChange={(e) =>setdateOfReg(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="state"
              label="State"
              name="state"
              onChange={(e) =>setstate(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="locality"
              label="locality"
              name="locality"
              onChange={(e) =>setlocality(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="hSno"
              label="hSno"
              name="hSno"
              onChange={(e) =>sethSno(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="landmark"
              label="landmark"
              id="landmark"
              onChange={(e) =>setlandmark(e.target.value)}
            />
            
            <Button
              
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              onClick={handleSubmit}
            
            >
              File Complaint
            </Button>
            
          </Box>
       
       
      </Container>
    </ThemeProvider>
  );
}

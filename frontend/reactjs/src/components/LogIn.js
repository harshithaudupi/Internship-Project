import React,{useState} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { red } from '@mui/material/colors';
import axios from 'axios';

import { useNavigate, Link } from 'react-router-dom';



const theme = createTheme();

export default function LogIn() {

  const [password, setPassword] = useState("");
  const [username, setUsername] = useState("");
  const navigate = useNavigate();
  const navigateHome=()=>{
    navigate("/home");
 }
 
 const handleSubmit = async (event) => {
  event.preventDefault(); 

  const data = {
    "username": username,
    "password": password,
  };

  try {
    
    const response = await axios.post("http://localhost:1090/users/loginUser", data);

   
    if (response.status === 200) {
      alert("Login is Successful");
      navigateHome(); 
    }
  } catch (error) {
  
    if (error.response) {
      if (error.response.status === 401) {
        alert("Invalid username or password. Please try again.");
      } else if (error.response.status === 500) {
        alert("Server error. Please try again later.");
      } else {
        alert("Unexpected error occurred. Please check your input and try again.");
      }
    } else {
      console.error("Error:", error);
      alert("Could not connect to the server. Please try again later.");
    }
  }
};

 
  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
           <Typography component="h1" variant="h5">
            e-Sahayatha
          </Typography>
          <Avatar sx={{ m: 1, bgcolor: red[400]}}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Log In
          </Typography>
          <Box component="form"noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="User Name"
              name="username"
              autoComplete="current-username"
              onChange={(e) =>setUsername(e.target.value)}
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              onChange={(e) =>setPassword(e.target.value)}
              autoComplete="current-password"
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
            />
            <Button
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              onClick={handleSubmit}
            >
            Log In
            </Button>
           
            <nav>
                   <Link to="/register">Don't have an account to Register?</Link> 
            </nav> 

              
              
          </Box>
        </Box>
       
      </Container>
    </ThemeProvider>
  );
}

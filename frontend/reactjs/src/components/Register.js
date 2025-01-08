import  React , {useState}from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { red } from '@mui/material/colors';
import { useNavigate } from 'react-router-dom';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import InputLabel from '@mui/material/InputLabel';
import axios from 'axios';



const theme = createTheme();

export default function Register() {
  
  
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [firstName,setFirstName]=useState("");
  const [lastName,setLastName]=useState("");
  const [email,setEmail]=useState("");
  const [state,setState]=useState("");
  const [pNo,setPno]=useState("");
  const [role,setRole]=useState("");

  const navigate = useNavigate();
  const navigateLogin=()=>{
     navigate("/");
  }
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = {
      "username":username,
      "password":password,
      "firstName":firstName,
      "lastName":lastName,
      "email":email,
      "state":state,
      "pNo":pNo,
      "role":role
    };
    try{
      axios.post("http://localhost:1090/users/registerUser",data);
      navigateLogin();
      
    }
    catch(error){
      console.error(error);
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
          <Avatar sx={{ m: 1, bgcolor: red[400] }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Register Yourself Here
          </Typography>
          <Box component="form" noValidate sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="username"
              name="username"
              onChange={(e) =>setUsername(e.target.value)}
              autoFocus
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="password"
              type="password"
              id="password"
              onChange={(e) =>setPassword(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="firstName"
              label="firstName"
              name="firstname"
              onChange={(e) =>setFirstName(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="lastName"
              label="lastName"
              name="lastName"
              onChange={(e) =>setLastName(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email"
              name="email"
              onChange={(e) =>setEmail(e.target.value)}
              
            />
            <TextField
              margin="normal"
              required
              fullWidth
              id="state"
              label="State you reside in"
              name="state"
              onChange={(e) =>setState(e.target.value)}
              
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="pNo"
              label="pNo"
              type="phonenumber"
              id="pNo"
              onChange={(e) =>setPno(e.target.value)}
            />
            

           <FormControl fullWidth>
                   <InputLabel id="Select-Role-label">Role</InputLabel>
            <Select
              labelId="role"
              id="role"
              label="role"
              onChange={(e) =>setRole(e.target.value)}
             >
               <MenuItem value="USER">CITIZEN</MenuItem>
               <MenuItem value="ADMIN">REDRESSAL OFFICER</MenuItem>
               
          
           </Select>
         </FormControl> 
            
            <Button
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              onClick={handleSubmit}
            >
              Continue
            </Button>
          </Box>
        </Box>
        
      </Container>
    </ThemeProvider>
  );
}

import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import CheckCircleIcon from '@mui/icons-material/CheckCircle';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { green } from '@mui/material/colors';
import { useNavigate } from 'react-router-dom';



const theme = createTheme();

export default function Completed() {
  const navigate= useNavigate();
  const navigateHome=()=>{
    navigate("/home");
  }

  return (
    <ThemeProvider theme={theme}>
      <Container component="main" maxWidth="xs">
        <CssBaseline />
        <Box
          sx={{
            marginTop: 20,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Avatar sx={{ m: 1, bgcolor: green[500] }}>
            <CheckCircleIcon />
          </Avatar>
          <Typography component="h1" variant="h5" >
            THANK YOU, YOUR COMPLAINT HAS BEEN REGISTERED SUCCESSFULLY !
          </Typography>
          <Box >
          
            <Button
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              onClick={()=>{navigateHome();}}
            >
              Continue
            </Button>
           
          </Box>
        </Box>
        
      </Container>
    </ThemeProvider>
  );
}

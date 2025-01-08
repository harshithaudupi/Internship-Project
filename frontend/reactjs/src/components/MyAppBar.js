import React from 'react';
import { AppBar, Button,Toolbar} from '@mui/material';
import Typography from '@mui/material/Typography';
import { useNavigate } from 'react-router-dom';
import { Home as HomeIcon, Info as InfoIcon, Logout as LogoutIcon } from '@mui/icons-material'; 
const MyAppBar = () => {
  const navigate = useNavigate();
  
  const navigateHome=()=>{
        navigate("/home");
    }

  const navigateAbout = () => {
        navigate("/about");
  };

  const handleLogout = () => {
       navigate("/");
  };

  return (
    <AppBar
      sx={{
        backgroundColor: '#3f51b5',
        display: 'flex',
        justifyContent: 'center', // Centers all buttons horizontally
        alignItems: 'center',    // Aligns content vertically in the center
        height: '40px',          // Optional: Adjust the height if needed
      }}
    >
    <Toolbar
        sx={{
          display: 'flex',
          justifyContent: 'space-between', 
          width: '100%',                  
        }}
      >
         <Typography component="h1" variant="h5">
            e-Sahayatha
          </Typography>
          <Button
          color="inherit"
          onClick={navigateHome}
          startIcon={<HomeIcon />} // Icon added at the start
        >
          Home
        </Button>
        <Button
          color="inherit"
          onClick={navigateAbout}
          startIcon={<InfoIcon />} // Icon added at the start
        >
          About
        </Button>
        <Button
          color="inherit"
          onClick={handleLogout}
          startIcon={<LogoutIcon />} // Icon added at the start
        >
          Logout
        </Button>
       </Toolbar>
   </AppBar>
  );
};

export default MyAppBar;

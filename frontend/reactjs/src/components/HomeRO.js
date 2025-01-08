import * as React from 'react';
import { AppBar, CardHeader,Card, Avatar, Button} from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import { red } from '@mui/material/colors';
import Grid from '@mui/material/Grid';
import PriorityHighIcon from '@mui/icons-material/PriorityHigh';
import DoneIcon from '@mui/icons-material/Done';
import {useNavigate} from 'react-router-dom';




const theme = createTheme();

export default function HomeRO(){
  
  const navigate=useNavigate();

  const navigateResolved=()=>{
    navigate("/resolvedComplaints");
  }
  const navigateUnresolved=()=>{
    navigate("/unresolvedComplaints");
  }
    return(
        <ThemeProvider theme={theme}>
          <CssBaseline />
            <AppBar title="Home">
            
            <Typography component="h1" variant="h5">
              Home RO
            </Typography>
            </AppBar> 
            <Typography component="h1" variant="h5" gutterBottom={true} >
                       e-Sahayatha
            </Typography>
          <Box>
          <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
             <Grid item xs={6} >
             <Avatar sx={{ m: 1, bgcolor: red[400] }}>
                  <DoneIcon/>
                </Avatar>
                <Button onClick={()=>{navigateResolved();}}>RESOLVED COMPLAINTS</Button>
             </Grid>
             <Grid item xs={6}>
                <Avatar sx={{ m: 1, bgcolor: red[400] }}>
                  <PriorityHighIcon/>
                </Avatar>
                <Button onClick={()=>{navigateUnresolved();}}>UNRESOLVED COMPLAINTS</Button>
             </Grid>
          </Grid>
          </Box>
          
          
          
          
          <Box> 
            <Typography component="h1" variant="h5">
              Updates
            </Typography>
            
             <Card> 
               <CardHeader title="Non-Sweeping Of Roads"
               variant="outlined"
               sx={{p:1}}></CardHeader>
               <Button>FEEDBACK</Button>
             </Card>  

             <Card>
             <CardHeader title="Cutting Of Trees"
             variant="outlined"
             sx={{p:1}}></CardHeader>
             <Button>FEEDBACK</Button>
             </Card>

             <Card>
              <CardHeader title="Water Clog"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>FEEDBACK</Button>
             </Card>
             
             <Card>
              <CardHeader title="Cable wires"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>FEEDBACK</Button>
             </Card>

             <Card>
              <CardHeader title="Potholes"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>FEEDBACK</Button>
              </Card>

             <Card>
              <CardHeader title="Street Lights"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>FEEDBACK</Button>
              </Card>

              
               <Card>
              <CardHeader title="Non-Clearing Of Garbage"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>FEEDBACK</Button>
             </Card>
          
           
           </Box> 
      </ThemeProvider>
    );
}
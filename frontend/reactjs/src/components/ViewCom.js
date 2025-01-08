import * as React from 'react';
import { AppBar, CardHeader,Card, Avatar, Button} from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
//import Link from '@mui/material/Link';
import CheckCircleOutlineIcon from '@mui/icons-material/CheckCircleOutline';
import { red } from '@mui/material/colors';
import ErrorOutlineIcon from '@mui/icons-material/ErrorOutline';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router-dom';

  

const theme = createTheme();

export default function ViewCom(){
   const navigate=useNavigate();
    const navigateHome=()=>{
        navigate("/home");
    }

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
            
           <Button 
              size="small"
              variant="small"
              onClick={()=> {navigateHome();}}>Home</Button>
            </AppBar> 
            <Typography component="h1" variant="h5" gutterBottom={true} >
                       e-Sahayatha
            </Typography>
          <Box>
          <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
             <Grid item xs={6} >
             <Avatar sx={{ m: 1, bgcolor: red[400] }}>
                  <CheckCircleOutlineIcon/>
                </Avatar>
                <Button onClick={()=>{navigateResolved();}}>RESOLVED COMPLAINTS</Button>
             </Grid>
             <Grid item xs={6}>
                <Avatar sx={{ m: 1, bgcolor: red[400] }}>
                  <ErrorOutlineIcon/>
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
                <Button>VIEW</Button>
            
               </Card>  

               <Card>
               <CardHeader title="Cutting Of Trees"
               variant="outlined"
               sx={{p:1}}></CardHeader>
                  <Button>FEEDBACK</Button>
                  <Button>VIEW</Button>
               </Card>

               <Card>
               <CardHeader title="Water Clog"
               variant="outlined"
               sx={{p:1}}></CardHeader>
                  <Button>FEEDBACK</Button>
                  <Button>VIEW</Button>
               </Card>
             
               <Card>
               <CardHeader title="Cable wires"
               variant="outlined"
               sx={{p:1}}></CardHeader>
                  <Button>FEEDBACK</Button>
                  <Button>VIEW</Button>
               </Card>

               <Card>
               <CardHeader title="Potholes"
               variant="outlined"
               sx={{p:1}}></CardHeader>
                  <Button>FEEDBACK</Button>
                  <Button>VIEW</Button>
               </Card>

               <Card>
               <CardHeader title="Street Lights"
               variant="outlined"
               sx={{p:1}}></CardHeader>
                  <Button>FEEDBACK</Button>
                  <Button>VIEW</Button>
               </Card>

               
               <Card>
                  <CardHeader title="Non-Clearing Of Garbage"
                  variant="outlined"
                  sx={{p:1}}></CardHeader>
                     <Button>FEEDBACK</Button>
                     <Button>VIEW</Button>
               </Card>
            
          
           </Box> 
      </ThemeProvider>
    );
}

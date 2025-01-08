import * as React from 'react';
import { CardHeader,Card, Avatar, Button} from '@mui/material';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import AddIcon from '@mui/icons-material/Add';
import { red } from '@mui/material/colors';
import SearchIcon from '@mui/icons-material/Search';
import Grid from '@mui/material/Grid';
import { useNavigate } from 'react-router-dom';
import MyAppBar from './MyAppBar';


const theme = createTheme();

export default function Home(){
    const navigate=useNavigate();
    const navigateFile=() => {
     navigate("/fileacom");
     
    }

    const navigateView= () => {
      navigate("/viewcom");
     
    }
   


    return(
        <ThemeProvider theme={theme}>
          <CssBaseline />
            <MyAppBar/>
           
          <Box>
          <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
             <Grid item xs={6} >
             <Avatar sx={{ m: 1, bgcolor: red[400] }}>
                  <AddIcon/>
                </Avatar>
               <Button 
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
                onClick={()=>{navigateFile();}}>
             FILE A NEW COMPLAINT
             </Button>
            
                
             </Grid>
             <Grid item xs={6}>
                <Avatar sx={{ m: 1, bgcolor: red[400] }}>
                  <SearchIcon/>
                </Avatar>
                <Button
                 fullWidth
                 variant="contained"
                 sx={{ mt: 3, mb: 2 }}
                 onClick={()=>{navigateView();}}>
             VIEW COMPLAINT
            </Button>
           
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
               <Button>Open</Button>
             </Card>  

             <Card>
             <CardHeader title="Cutting Of Trees"
             variant="outlined"
             sx={{p:1}}></CardHeader>
             <Button>Open</Button>
             </Card>

             <Card>
              <CardHeader title="Water Clog"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>Open</Button>
             </Card>
             
             <Card>
              <CardHeader title="Cable wires"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>Open</Button>
             </Card>

             <Card>
              <CardHeader title="Potholes"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>Open</Button>
              </Card>

             <Card>
              <CardHeader title="Street Lights"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>Open</Button>
              </Card>

              
               <Card>
              <CardHeader title="Non-Clearing Of Garbage"
              variant="outlined"
              sx={{p:1}}></CardHeader>
              <Button>Open</Button>
             </Card>
          
           
           </Box> 
      </ThemeProvider>
    );
}
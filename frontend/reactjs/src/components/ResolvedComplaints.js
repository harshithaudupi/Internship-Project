import React from "react";
import Avatar from '@mui/material/Avatar';
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import { CardHeader,Card, Button} from '@mui/material';
import { Box } from "@mui/material";
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { red } from '@mui/material/colors';
import Container from '@mui/material/Container';
import DoneIcon from '@mui/icons-material/Done';

const theme = createTheme();
export default function ResolvedComplaints(){
   


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
               <DoneIcon/>
            </Avatar>
            <Typography component="h1" variant="h5">
              RESOLVED COMPLAINTS
            </Typography>
            <Box component="form"  noValidate sx={{ mt: 1 }}>
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
                
            </Box>
          </Box>
         
        </Container>
      </ThemeProvider>
    );
  }
  

import React from "react";
import Avatar from '@mui/material/Avatar';
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import { Box } from "@mui/material";
import { createTheme, ThemeProvider } from '@mui/material/styles';
import Container from '@mui/material/Container';
import { CardHeader,Card, Button} from '@mui/material';
import { red } from '@mui/material/colors';
import PriorityHighIcon from '@mui/icons-material/PriorityHigh';

const theme = createTheme();
export default function UnresolvedComplaints(){
   


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
              <PriorityHighIcon/>
            </Avatar>
            <Typography component="h1" variant="h5">
              UNRESOLVED COMPLAINTS
            </Typography>
            <Box component="form"  noValidate sx={{ mt: 1 }}>
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
          </Box>
         
        </Container>
      </ThemeProvider>
    );
  }
  

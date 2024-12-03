import { createTheme } from '@mui/material';

const theme = createTheme({
    palette: {
        primary: {
            main: '#1976d2',
        },
        secondary: {
            main: '#dc004e',
        },
        background: {
            default: '#333333',
        },
    },
    typography: {
        fontFamily: 'Arial, sans-serif',
    },
});

export default theme;

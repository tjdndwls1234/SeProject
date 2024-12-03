import {
    Box,
    ThemeProvider,
} from "@mui/material";
import React from "react";
import Header from "components/Header"
import theme from "theme"


const Screen = () => {
    return (
        <ThemeProvider theme={theme}>
            <Box sx={{ minHeight: "100vh", bgcolor: "white" }}>
                <Header />
            </Box>
        </ThemeProvider>
    )
}

export default Screen
import {
    ThemeProvider,
    Box,
    Button,
    Container,
    Paper,
    TextField,
    Typography,
} from '@mui/material';
import React from 'react';
import theme from 'theme';

const Screen = () => {
    return (
        <ThemeProvider theme={theme}>
            <Box
                sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    minHeight: '100vh',
                    alignItems: 'center',
                    justifyContent: 'center',
                    backgroundColor: 'background.default',
                }}
            >
                <Container maxWidth="xs">
                    <Box
                        sx={{
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                            mb: 4,
                        }}
                    >
                        <Typography
                            variant="h1"
                            component="h1"
                            sx={{
                                fontFamily: "'Istok Web', sans-serif",
                                fontWeight: 'bold',
                                color: 'white',
                                fontSize: '64px',
                            }}
                        >
                            Planmate
                        </Typography>
                    </Box>
                    <Paper
                        elevation={3}
                        sx={{
                            p: 4,
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                            gap: 2,
                        }}
                    >
                        <TextField
                            fullWidth
                            label="아이디"
                            variant="outlined"
                            margin="normal"
                        />
                        <TextField
                            fullWidth
                            label="비밀번호"
                            type="password"
                            variant="outlined"
                            margin="normal"
                        />
                        <Button
                            fullWidth
                            variant="contained"
                            color="primary"
                            sx={{ mt: 2 }}
                        >
                            로그인
                        </Button>
                        <Button
                            fullWidth
                            variant="outlined"
                            color="secondary"
                            sx={{ mt: 2 }}
                        >
                            회원가입
                        </Button>
                    </Paper>
                </Container>
            </Box>
        </ThemeProvider>
    );
};

export default Screen;

import {
    ThemeProvider,
    Box,
    Button,
    Container,
    Paper,
    TextField,
    Typography,
} from '@mui/material';
import React, { useState } from "react";
import theme from 'theme';
import { Link, useNavigate } from 'react-router-dom';

const Screen = () => {
    const navigate = useNavigate()

    const [formData, setFormData] = useState({
        id: "",
        password: "",
    });
    const [errors, setErrors] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };
    const validate = () => {
        const newErrors = {};
        if (!formData.id) newErrors.id = "아이디를 입력하세요.";
        if (!formData.password) newErrors.password = "비밀번호를 입력하세요.";

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        if (validate()) {
            fetch("/api/login", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ id: formData.id, pw: formData.password }),
            })
                .then((response) => {
                    if (!response.ok) {
                        return {}
                    }
                    return response.json()
                })
                .then((data) => {
                    localStorage.setItem("token", data.token);
                    localStorage.setItem("studentCode", data.studentCode);
                    navigate('/')
                })
        }
    };


    return (
        <ThemeProvider theme={theme}>
            <Box
                component="form"
                onSubmit={handleSubmit}
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
                            variant="outlined"
                            label="아이디"
                            name="id"
                            value={formData.id}
                            error={!!errors.id}
                            helperText={errors.id}
                            onChange={handleChange}
                        />
                        <TextField
                            fullWidth
                            variant="outlined"
                            label="비밀번호"
                            type="password"
                            name="password"
                            value={formData.password}
                            error={!!errors.password}
                            helperText={errors.password}
                            onChange={handleChange}
                        />
                        <Button
                            fullWidth
                            variant="contained"
                            color="primary"
                            type="submit"
                        >
                            로그인
                        </Button>
                        <Button
                            component={Link}
                            to="/register"
                            fullWidth
                            variant="outlined"
                            color="third"
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

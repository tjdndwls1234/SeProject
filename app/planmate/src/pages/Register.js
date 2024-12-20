import {
    Box,
    Button,
    Container,
    Paper,
    TextField,
    ThemeProvider,
    Typography,
    Autocomplete
} from "@mui/material";
import React, { useState, useEffect } from "react";
import { useNavigate } from 'react-router-dom';
import theme from "theme";

const RegisterTextField = ({ ...props }) => {
    return (
        <TextField
            variant="outlined"
            fullWidth
            sx={{ mb: 2 }}
            {...props}
        >
        </TextField>
    )
}
const Content = () => {
    const navigate = useNavigate();

    const [departments, setDepartments] = useState([
       // { id: 1, label: "컴퓨터과학부" },
        //{ id: 2, label: "전기전자컴퓨터공학부" },
        //{ id: 3, label: "기계공학과" },
    ]);

    useEffect(() => {
        fetch('/api/departments')
            .then(response => {
                if (!response.ok) {
                    navigate("/login");
                }
                else {
                    return response.json();
                }
            })
            .then(data => {
                const transformedData = data.map(department => ({
                    id: department.departmentCode,
                    label: department.departmentName
                }));
                setDepartments(transformedData);
            })
    }, []);


    const [formData, setFormData] = useState({
        id: "",
        password: "",
        confirmPassword: "",
        name: "",
        departmentId: null,
    });
    const [errors, setErrors] = useState({});

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleDepartmentChange = (e, department) => {
        const value = department ? department.id : null
        setFormData({ ...formData, ["departmentId"]: value });
    }

    const validate = () => {
        const newErrors = {};
        if (!formData.id) newErrors.id = "아이디를 입력하세요.";
        if (!formData.password) newErrors.password = "비밀번호를 입력하세요.";
        if (!formData.confirmPassword)
            newErrors.confirmPassword = "비밀번호 확인을 입력하세요.";
        else if (formData.password !== formData.confirmPassword)
            newErrors.confirmPassword = "비밀번호가 일치하지 않습니다.";
        if (!formData.name) newErrors.name = "이름을 입력하세요.";
        if (!formData.departmentId) newErrors.departmentId = "학과를 선택하세요.";

        setErrors(newErrors);
        return Object.keys(newErrors).length === 0;
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log("Selected Department ID:", formData.departmentId);
        if (validate()) {
            fetch("/api/signup", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    studentCode: null,
                    studentName: formData.name,
                    departmentCode: formData.departmentId,
                    departmentName: formData.departmentName,
                    id: formData.id,
                    pw: formData.password
                }),
            }).then((response) => {
                if (response.ok) {
                    if (response.text() === "Sign Up Success"){
                        alert(response.text());
                        navigate('/login');
                    }
                    else
                        alert(response.text());
                }
                else {
                    alert("서버 오류입니다.");
                    navigate('/login')
                }
            })
        }
    };

    return (
        <ThemeProvider theme={theme}>
            <Box
                sx={{
                    display: "flex",
                    flexDirection: "column",
                    minHeight: "100vh",
                    alignItems: "center",
                    justifyContent: "center",
                    bgcolor: "background.default",
                }}
            >
                <Container maxWidth="xs">
                    <Box
                        sx={{
                            display: "flex",
                            flexDirection: "column",
                            alignItems: "center",
                            mb: 4,
                        }}
                    >
                        <Typography
                            variant="h1"
                            component="div"
                            sx={{
                                fontFamily: "'Istok Web', sans-serif",
                                fontWeight: "bold",
                                color: "white",
                                fontSize: 64,
                            }}
                        >
                            Planmate
                        </Typography>
                    </Box>

                    <Paper
                        elevation={3}
                        sx={{
                            p: 3,
                            borderRadius: 2,
                            borderColor: "border.default",
                        }}
                    >
                        <Box
                            component="form"
                            onSubmit={handleSubmit}
                            sx={{
                                display: "flex",
                                flexDirection: "column",
                                gap: 0,
                            }}
                        >
                            <RegisterTextField
                                label="아이디"
                                name="id"
                                value={formData.id}
                                error={!!errors.id}
                                helperText={errors.id}
                                onChange={handleChange}
                            />
                            <RegisterTextField
                                label="비밀번호"
                                type="password"
                                name="password"
                                value={formData.password}
                                onChange={handleChange}
                                error={!!errors.password}
                                helperText={errors.password}
                            />
                            <RegisterTextField
                                label="비밀번호 확인"
                                type="password"
                                name="confirmPassword"
                                value={formData.confirmPassword}
                                onChange={handleChange}
                                error={!!errors.confirmPassword}
                                helperText={errors.confirmPassword}
                            />
                            <RegisterTextField
                                label="이름"
                                name="name"
                                value={formData.name}
                                onChange={handleChange}
                                error={!!errors.name}
                                helperText={errors.name}
                            />
                            <Autocomplete
                                options={departments}
                                sx={{ mb: 2 }}
                                name="department"
                                onChange={handleDepartmentChange}
                                renderInput={(params) => <TextField {...params} error={!!errors.departmentId} helperText={errors.departmentId} label="학과" />}
                            />
                            <Button
                                variant="contained"
                                color="primary"
                                fullWidth
                                type="submit"
                                sx={{
                                    bgcolor: "primary.main",
                                    color: "primary.contrastText",
                                    borderRadius: 2,
                                }}
                            >
                                가입하기
                            </Button>
                        </Box>
                    </Paper>
                </Container>
            </Box>
        </ThemeProvider>
    );
};

export default Content;


import ArrowDropDownIcon from "@mui/icons-material/ArrowDropDown";
import {
    Box,
    Container,
    MenuItem,
    Paper,
    Select,
    Stack,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    TextField,
    ThemeProvider,
    Typography,
} from "@mui/material";
import { React, useState, useEffect } from "react";
import Header from "components/Header"
import theme from "theme"

const TableHeadCell = ({ isLastColumn = false, children, sx = {}, ...props }) => {
    return (
        <TableCell
            sx={[{
                textAlign: "center",
                color: "white",
                fontWeight: "bold",
                borderRight: isLastColumn ? "none" : "1px solid #ccc",
                padding: "5px"
            }, sx]}
            {...props}
        >
            {children}
        </TableCell>
    );
}

const TableBodyCell = ({ isLastColumn = false, children, sx = {}, ...props }) => {
    return (
        <TableCell
            sx={[{
                borderBottom: "1px solid #ccc",
                borderRight: isLastColumn ? "none" : "1px solid #ccc",
                padding: "3px"
            }, sx]}
            {...props}
        >
            {children}
        </TableCell >
    )
}

const TableTextField = ({ ...props }) => {
    return (
        <TextField
            fullWidth
            variant="filled"
            size="small"
            sx={{
                "& .MuiInputBase-input": {
                    padding: "10px",
                },
            }}
            {...props}
        />
    );
}

const Screen = () => {

    const [departments, setDepartments] = useState([
        { departmentCode: 1, departmentName: "컴퓨터과학부" },
        { departmentCode: 2, departmentName: "전기전자컴퓨터과학부" },
        { departmentCode: 3, departmentName: "인공지능학과" },
    ])

    useEffect(() => {
        fetch('/departments')
            .then(response => {
                if (!response.ok) {
                    alert("서버 연결 실패")
                }
                else {
                    return response.json();
                }
            })
            .then(data => {
                setDepartments(data);
            })
    }, []);

    const [rows, setRows] = useState([
        {
            preCourseName: "소프트웨어공학",
            preCourseDevision: "전공필수",
            preCourseTerm: "3-1",
            preCourseCredit: "3",
            postCourseName: "소프트웨어공학",
            postCourseDevision: "전공필수",
            postCourseTerm: "3-2",
            postCourseCredit: "3"
        },
    ]);

    // 셀 내용 변경 핸들러
    const handleChange = (e, child) => {
        fetch(`/CourseUpdate?departmentName=${e.target.value}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            }
        })
            .then(response => response.json())
            .then(data => setRows(data))
    };

    return (
        <ThemeProvider theme={theme}>
            <Box sx={{ minHeight: "100vh", bgcolor: "white" }}>
                <Header />
                <Container maxWidth={false} sx={{ minWidth: "600px", maxWidth: "1000px", mt: 4, mb: 4 }}>
                    <Stack spacing={4}>
                        <Typography variant="h4" sx={{ fontWeight: "bold" }}>
                            선수/후수 과목 조회
                        </Typography>

                        <Box sx={{ width: "100%" }}>
                            <Box>
                                <Select
                                    defaultValue={departments[0].departmentName}
                                    IconComponent={ArrowDropDownIcon}
                                    fullWidth
                                    sx={{
                                        borderRadius: 1,
                                        border: 1,
                                        borderColor: "divider",
                                        maxWidth: 220,
                                    }}
                                    size="small"
                                    onChange={handleChange}
                                >
                                    {departments.map((department, index) => (
                                        <MenuItem
                                            key={department.departmentCode}
                                            value={department.departmentName}
                                        >
                                            {department.departmentName}
                                        </MenuItem>
                                    ))}
                                </Select>
                            </Box>

                            <TableContainer component={Paper} sx={{ mt: 1 }}>
                                <Table>
                                    <TableHead>
                                        <TableRow sx={{ bgcolor: "background.default" }}>
                                            <TableHeadCell sx={{ flex: 1 }}>선수과목</TableHeadCell>
                                            <TableHeadCell sx={{ width: "100px" }}>교과구분</TableHeadCell>
                                            <TableHeadCell sx={{ width: "50px" }}>학기</TableHeadCell>
                                            <TableHeadCell sx={{ width: "50px" }}>학점</TableHeadCell>
                                            <TableHeadCell sx={{ flex: 1 }}>후수과목</TableHeadCell>
                                            <TableHeadCell sx={{ width: "100px" }}>교과구분</TableHeadCell>
                                            <TableHeadCell sx={{ width: "50px" }}>학기</TableHeadCell>
                                            <TableHeadCell sx={{ width: "50px" }} isLastColumn={true}>학점</TableHeadCell>
                                        </TableRow>
                                    </TableHead>
                                    <TableBody>
                                        {rows.map((row, index) => (
                                            <TableRow key={index}>
                                                <TableBodyCell>
                                                    {row.preCourseName}
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    {row.preCourseDevision}
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    {row.preCourseTerm}
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    {row.preCourseCredit}
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    {row.postCourseName}
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    {row.postCourseDevision}
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    {row.postCourseTerm}
                                                </TableBodyCell>
                                                <TableBodyCell isLastColumn={true}>
                                                    {row.postCourseCredit}
                                                </TableBodyCell>
                                            </TableRow>
                                        ))}
                                    </TableBody>
                                </Table>
                            </TableContainer>
                        </Box>

                    </Stack>
                </Container>
            </Box>
        </ThemeProvider >
    );
};

export default Screen;

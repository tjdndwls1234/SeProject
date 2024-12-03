import ArrowDropDownIcon from "@mui/icons-material/ArrowDropDown";
import {
    Box,
    Button,
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
import { React, useState } from "react";
import Header from "components/Header"
import theme from "theme"

const ScoreCell = ({ title, current, max }) => {
    return (
        <Box width="auto">
            <Typography variant="subtitle1" sx={{ color: "text.secondary" }}>
                {title}
            </Typography>
            <Box sx={{ display: "flex", alignItems: "flex-end", gap: "5px" }}>
                <Typography variant="h5" sx={{ fontWeight: "bold" }}>
                    {current}
                </Typography>
                <Typography variant="body1" sx={{ color: "text.secondary" }}>
                    / {max}
                </Typography>
            </Box>
        </Box>
    )
}

const TableHeadCell = ({ isLastColumn = false, children, sx = {}, ...props }) => {
    return (
        <TableCell
            sx={[{
                textAlign: "center",
                color: "white",
                fontWeight: "bold",
                borderRight: isLastColumn ? "none" : "1px solid #ccc",
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

            }, sx]}
            padding="none"
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
    const [rows, setRows] = useState([
        { subject: "소프트웨어공학", category: "전공필수", credits: 3, grade: 3.5 },
        { subject: "알고리즘", category: "전공선택", credits: 3, grade: 4.0 },
    ]);

    // 셀 내용 변경 핸들러
    const handleChange = (e, index, field) => {
        const updatedRows = [...rows];
        updatedRows[index][field] = e.target.value;
        setRows(updatedRows);
    };

    const handleAddRow = () => {
        setRows([
            ...rows,
            { subject: "", category: "", credits: "", grade: "" }, // 새로운 빈 행 추가
        ]);
    };
    return (
        <ThemeProvider theme={theme}>
            <Box sx={{ minHeight: "100vh", bgcolor: "white" }}>
                <Header />
                <Container maxWidth={false} sx={{ minWidth: "600px", maxWidth: "1000px", mt: 4, mb: 4 }}>
                    <Stack spacing={4}>
                        <Box>
                            <Typography variant="h4" sx={{ fontWeight: "bold" }}>
                                OOO님의 성적표
                            </Typography>
                            <Typography variant="subtitle1" sx={{ color: "text.secondary" }}>
                                컴퓨터과학부
                            </Typography>
                        </Box>

                        <Box sx={{ display: "flex", flexDirection: "column", gap: 2 }}>
                            <Box sx={{ display: "flex", gap: 6 }}>
                                <ScoreCell title="전체 평점" current={3.5} max={4.5} />
                                <ScoreCell title="취득 학점" current={90} max={130} />
                            </Box>
                            <Box sx={{ display: "flex", gap: 6 }}>
                                <ScoreCell title="전공 평점" current={3.5} max={4.5} />
                                <ScoreCell title="전공 학점" current={60} max={72} />
                                <ScoreCell title="교양 학점" current={30} max={36} />
                            </Box>
                        </Box>

                        <Box sx={{ width: "100%" }}>
                            <Box sx={{ display: "flex" }}>
                                <Box sx={{ flexGrow: 1 }}>
                                    <Select
                                        defaultValue="2024년 2학기"
                                        IconComponent={ArrowDropDownIcon}
                                        fullWidth
                                        sx={{
                                            borderRadius: 1,
                                            border: 1,
                                            borderColor: "divider",
                                            maxWidth: 200,
                                        }}
                                        size="small"
                                    >
                                        <MenuItem value="2024년 2학기">2024년 2학기</MenuItem>
                                    </Select>
                                </Box>
                                <Button variant="contained" sx={{ bgcolor: "background.default" }}>
                                    저장하기
                                </Button>
                            </Box>

                            <TableContainer component={Paper} sx={{ mt: 1 }}>
                                <Table>
                                    <TableHead>
                                        <TableRow sx={{ bgcolor: "background.default" }}>
                                            <TableHeadCell sx={{ flexGrow: 1 }}>과목명</TableHeadCell>
                                            <TableHeadCell sx={{ width: "100px" }}>교과구분</TableHeadCell>
                                            <TableHeadCell sx={{ width: "50px" }}>학점</TableHeadCell>
                                            <TableHeadCell sx={{ width: "50px" }} isLastColumn={true}>평점</TableHeadCell>
                                        </TableRow>
                                    </TableHead>
                                    <TableBody>
                                        {rows.map((row, index) => (
                                            <TableRow key={index}>
                                                <TableBodyCell>
                                                    <TableTextField
                                                        value={row.subject}
                                                        onChange={(e) => handleChange(e, index, "subject")}
                                                    />
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    <TableTextField
                                                        value={row.category}
                                                        onChange={(e) => handleChange(e, index, "category")}
                                                    />
                                                </TableBodyCell>
                                                <TableBodyCell>
                                                    <TableTextField
                                                        type="number"
                                                        value={row.credits}
                                                        onChange={(e) => handleChange(e, index, "credits")}
                                                    />
                                                </TableBodyCell>
                                                <TableBodyCell isLastColumn={true}>
                                                    <TableTextField
                                                        type="number"
                                                        value={row.grade}
                                                        onChange={(e) => handleChange(e, index, "grade")}
                                                    />
                                                </TableBodyCell>
                                            </TableRow>
                                        ))}
                                        <TableRow>
                                            <TableCell colSpan={4} padding="none">
                                                <Button
                                                    color="transparent"
                                                    onClick={handleAddRow}
                                                    fullWidth
                                                >
                                                    +
                                                </Button>
                                            </TableCell>
                                        </TableRow>
                                        <TableRow sx={{ bgcolor: "#dbdbdb" }}>
                                            <TableCell>전체</TableCell>
                                            <TableCell />
                                            <TableCell>3</TableCell>
                                            <TableCell>3.5</TableCell>
                                        </TableRow>
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

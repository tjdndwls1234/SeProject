import {
  ThemeProvider,
  Box,
  TextField,
  Autocomplete,
  FormGroup,
  FormControlLabel,
  Checkbox,
  Toolbar,
  Typography,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  Button
} from "@mui/material";
import { styled } from "@mui/material/styles";
import React from "react";
import { Link, useLocation } from "react-router-dom";
import theme from "theme";

import Header from "../components/Header"

const departments = [
  { id: 1, label: "컴퓨터과학부" },
  { id: 2, label: "전기전자컴퓨터공학부" },
  { id: 3, label: "기계공학과" },
];

const years = [
  { id: 1, label: "1" },
  { id: 2, label: "2" },
  { id: 3, label: "3" },
  { id: 4, label: "4" },
];

const days = [
  { id: 1, label: "월" },
  { id: 2, label: "화" },
  { id: 3, label: "수" },
  { id: 4, label: "목" },
  { id: 5, label: "금" },
  { id: 6, label: "토" },
];

const hours = [
  { id: 1, label: "09:00 - 10:00" },
  { id: 2, label: "10:00 - 11:00" },
  { id: 3, label: "11:00 - 12:00" },
  { id: 4, label: "12:00 - 13:00" },
  { id: 5, label: "13:00 - 14:00" },
  { id: 6, label: "14:00 - 15:00" },
  { id: 7, label: "15:00 - 16:00" },
  { id: 8, label: "16:00 - 17:00" },
  { id: 9, label: "17:00 - 18:00" },
];

const rows = [
  ['소프트웨어공학', '01', '컴퓨터과학부', '3', '3', '전공필수', '김지은', '월10:00-13:00', '50'],
  ['소프트웨어공학', '02', '컴퓨터과학부', '3', '3', '전공필수', '김지은', '화10:00-13:00', '50'],
  ['소프트웨어공학', '03', '컴퓨터과학부', '3', '3', '전공필수', '김지은', '수10:00-13:00', '50'],
  ['소프트웨어공학', '04', '컴퓨터과학부', '3', '3', '전공필수', '김지은', '목10:00-13:00', '50'],
  ['소프트웨어공학', '05', '컴퓨터과학부', '3', '3', '전공필수', '김지은', '금10:00-13:00', '60']
];

const Index = () => {
  return (
    <ThemeProvider theme={theme}>
      <Header></Header>
      <Toolbar>
        <Box
          sx={{
            flexDirection: 'column',
            minHeight: '100vh',
            mt: 4
          }}>

          <Typography
            variant="h6"
            component={Link}
            to="/"
            sx={{
              fontWeight: "bold",
              textDecoration: "none",  // 링크 스타일 제거
              color: "inherit",        // 기본 색상 유지
                '&:hover': {
              },
            }}>
            2024년 1학기 강의목록
          </Typography>

          <TextField
            variant="outlined"
            size="small"
            label="검색어 입력"
            name="id"
            sx={{
              display: 'flex',
              width: 382,
              mt: 2,
              ml: 0,
              mb: 2,
            }}
          />

          <Box
            sx={{
              display: 'flex'
            }}
          >
            <Autocomplete
              options={departments}
              sx={{
                width: 150
              }}
              name="department"
              size="small"
              renderInput={(params) => <TextField {...params} label="학부/과" />}
            />

            <Autocomplete
              options={departments}
              sx={{
                width: 100,
                ml: 2
              }}
              name="department"
              size="small"
              renderInput={(params) => <TextField {...params} label="전공" />}
            />

            <Autocomplete
              options={years}
              sx={{
                width: 100,
                ml: 2
              }}
              name="years"
              size="small"
              renderInput={(params) => <TextField {...params} label="학년" />}
            />
          </Box>

          <Box
            sx={{
              display: 'flex',
              mt: 2
            }}
          >
            <Autocomplete
              options={days}
              sx={{
                width: 100,
              }}
              name="days"
              size="small"
              renderInput={(params) => <TextField {...params} label="요일" />}
            />

            <Autocomplete
              options={hours}
              sx={{
                width: 150,
                ml: 2
              }}
              name="hours"
              size="small"
              renderInput={(params) => <TextField {...params} label="시간" />}
            />
          </Box>

          <Box
            sx={{
              display: 'flex',
              flexDirection: 'row',
              justifyContent: 'space-between',
              width: 750
            }}
          >
            <Box>
              <FormGroup
                sx={{
                  display: 'flex',
                  flexDirection: 'row',
                  mt: 2
                }}
              >
                <FormControlLabel control={<Checkbox />} label="공학 인증 과목만 보기" />
                <FormControlLabel control={<Checkbox />} label="재수강 가능 과목만 보기" />
              </FormGroup>

              <FormGroup
                sx={{
                  display: 'flex',
                  flexDirection: 'row',
                  mb: 3
                }}
              >
                <FormControlLabel control={<Checkbox />} label="수강 금지 과목 제외" />
                <FormControlLabel control={<Checkbox defaultChecked />} label="시간 겹치는 과목 제외" />
              </FormGroup>
            </Box>

            <Button variant="조회" sx={{
              bgcolor: "background.default",
              color: '#ffffff',
              height: 50,
              mt: 4
            }}>
              조회
            </Button>
          </Box>

          <Box
            sx={{
              width: '100vw',
              display: 'flex',
              flexDirection: 'row',
              mb: 3
            }}
          >
            <TableContainer component={Paper} sx={{ width: 750 }}>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow sx={{ bgcolor: "background.default" }}>
                    <TableCell sx={{ color: "#ffffff" }}>과목명</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>분반</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>학과</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>학년</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>학점</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>교과구분</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>교수명</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>강의시간</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>정원</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {rows.map((row) => (
                    <TableRow
                      key={row[0]}
                      sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                    >
                      <TableCell align="right">{row[0]}</TableCell>
                      <TableCell align="right">{row[1]}</TableCell>
                      <TableCell align="right">{row[2]}</TableCell>
                      <TableCell align="right">{row[3]}</TableCell>
                      <TableCell align="right">{row[4]}</TableCell>
                      <TableCell align="right">{row[5]}</TableCell>
                      <TableCell align="right">{row[6]}</TableCell>
                      <TableCell align="right">{row[7]}</TableCell>
                      <TableCell align="right">{row[8]}</TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>

            <TableContainer component={Paper} sx={{ width: 400, ml: 3 }}>
              <Table aria-label="simple table">
                <TableHead>
                  <TableRow sx={{ bgcolor: "background.default" }}>
                    <TableCell sx={{ color: "#ffffff" }}>시간/요일</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>월</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>화</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>수</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>목</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>금</TableCell>
                    <TableCell align="right" sx={{ color: "#ffffff" }}>토</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {rows.map((row) => (
                    <TableRow
                      key={row[0]}
                      sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                    >
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </TableContainer>
          </Box>
        </Box>
      </Toolbar>
    </ThemeProvider>
  );
}

export default Index;

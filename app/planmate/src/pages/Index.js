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
  Button,
  IconButton
} from "@mui/material";
import SystemUpdateAltIcon from "@mui/icons-material/SystemUpdateAlt";

// import "../styles.css";
// import "../reset.css";
// import useTimeTable from "react-custom-timetable";
// import exampleTaskList from "react-custom-timetable";
// import TaskListItem from "react-custom-timetable";


import React, { useState, useEffect } from "react";
import { useNavigate, Link } from "react-router-dom";
import theme from "theme";

import Header from "../components/Header";

const departments = [
  { id: 1, label: "컴퓨터과학부" },
  { id: 2, label: "전기전자컴퓨터공학부" },
  { id: 3, label: "기계공학과" },
];

const majors = [
  { id: 1, label: "전공필수" },
  { id: 2, label: "전공선택" },
  { id: 3, label: "교양필수" },
  { id: 4, label: "교양선택" },
  { id: 5, label: "일반선택" },
  { id: 6, label: "ROTC" },
  { id: 7, label: "교직" },
  { id: 8, label: "교환학점" },
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

const Index = () => {
  const navigate = useNavigate();

  const [courses, setCourses] = useState([
    // {
    //   courseCode: "CS101",
    //   courseName: "컴퓨터공학",
    //   classDevision: "1",
    //   departmentName: "컴퓨터과학부",
    //   grade: "3",
    //   credit: 3,
    //   courseDevision: "전공필수",
    //   professorName: "홍길동",
    //   courseDay: "월",
    //   courseStartTime: "09:00",
    //   courseEndTime: "10:30",
    //   totalCapacity: "50"
    // },
    // {
    //   courseCode: "CS102",
    //   courseName: "자료구조",
    //   classDevision: "2",
    //   departmentName: "컴퓨터과학부",
    //   grade: "2",
    //   credit: 3,
    //   courseDevision: "전공선택",
    //   professorName: "이몽룡",
    //   courseDay: "화",
    //   courseStartTime: "10:00",
    //   courseEndTime: "11:30",
    //   totalCapacity: "40"
    // }
  ]
  );
  useEffect(() => {
    // 세션 체크를 위한 API 호출
    fetch("/api/SessionCheck")
        .then(response => response.text()) // 서버의 응답을 JSON 형식으로 받기
        .then(data => {
          console.log(data);
          if (data.sessionStatus === "No session") {
            console.log("No session, redirecting to login...");
            // 세션이 없다면 /login으로 리디렉션
            navigate("/login");
          }
          // 세션이 있으면 아무것도 하지 않고 페이지 렌더링 유지
        })
        .catch(error => {
          console.error("Error checking session:", error);
          navigate("/login");  // 오류 발생 시 로그인 페이지로 리디렉션
        });
  }, [navigate]);

  const [formData, setFormData] = useState({
    studentDepartmentCode: null,
    courseKeyword: null,
    courseDepartmentName: null,
    courseDevision: null,
    grade: null,
    courseStartTime: null,
    courseDay: null,
    isCourseEngineeringCertified: false,
    isCourseProhibit: false,
    isRetakeableCourse: false,
    isScheduleConflict: false,
  });

  const handleSearch = async () => {
    try {
      const response = await fetch("/MainPage/CourseSearch", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });
      if (!response.ok) {
        throw new Error("Failed to fetch data");
      }
      const data = await response.json();
      setCourses(data);
    } catch (error) {
      console.error("Error fetching courses:", error);
    }
  };

  const handleChange = (field, value) => {
    setFormData({ ...formData, [field]: value });
  };

  const handleAddCourse = (course) => {
    fetch("/CourseAdd", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        courseCode: course.courseCode
      }),
    }).then((response => {
      if (!response.ok) {
        alert("시간표 저장에 실패했습니다.")
      }
      else {
        alert("시간표에 저장되었습니다.")
      }
    }))
  };

  return (
    <ThemeProvider theme={theme}>
      <Header />
      <Toolbar>
        <Box
          sx={{
            flexDirection: "column",
            minHeight: "100vh",
            mt: 4,
          }}
        >
          <Typography
            variant="h6"
            component={Link}
            to="/"
            sx={{
              fontWeight: "bold",
              textDecoration: "none",
              color: "inherit",
            }}
          >
            2024년 1학기 강의목록
          </Typography>

          <TextField
            variant="outlined"
            size="small"
            label="검색어 입력"
            value={formData.courseKeyword}
            onChange={(e) => handleChange("courseKeyword", e.target.value)}
            sx={{
              display: "flex",
              width: 382,
              mt: 2,
              ml: 0,
              mb: 2,
            }}
          />

          <Box sx={{ display: "flex" }}>
            <Autocomplete
              options={departments}
              sx={{ width: 150 }}
              onChange={(e, value) =>
                handleChange("courseDepartmentName", value?.label || "")
              }
              size="small"
              renderInput={(params) => <TextField {...params} label="학부/과" />}
            />
            <Autocomplete
              options={majors}
              sx={{ width: 100, ml: 2 }}
              onChange={(e, value) =>
                handleChange("courseDevision", value?.label || "")
              }
              size="small"
              renderInput={(params) => <TextField {...params} label="교과구분" />}
            />
            <Autocomplete
              options={years}
              sx={{ width: 100, ml: 2 }}
              onChange={(e, value) => handleChange("grade", value?.label || "")}
              size="small"
              renderInput={(params) => <TextField {...params} label="학년" />}
            />
          </Box>

          <Box sx={{ display: "flex", mt: 2 }}>
            <Autocomplete
              options={days}
              sx={{ width: 100 }}
              onChange={(e, value) => handleChange("courseDay", value?.label || "")}
              size="small"
              renderInput={(params) => <TextField {...params} label="요일" />}
            />
            <Autocomplete
              options={hours}
              sx={{ width: 150, ml: 2 }}
              onChange={(e, value) =>
                handleChange("courseStartTime", value?.label || "")
              }
              size="small"
              renderInput={(params) => <TextField {...params} label="시간" />}
            />
          </Box>

          <Box sx={{ width: 900, display: "flex", flexDirection: "row", justifyContent: "space-between" }}>
            <Box>
              <FormGroup sx={{ display: "flex", flexDirection: "row", mt: 2 }}>
                <FormControlLabel
                  control={
                    <Checkbox
                      checked={formData.isCourseEngineeringCertified}
                      onChange={(e) =>
                        handleChange("isCourseEngineeringCertified", e.target.checked)
                      }
                    />
                  }
                  label="공학 인증 과목만 보기"
                />
                <FormControlLabel
                  control={
                    <Checkbox
                      checked={formData.isRetakeableCourse}
                      onChange={(e) =>
                        handleChange("isRetakeableCourse", e.target.checked)
                      }
                    />
                  }
                  label="재수강 가능 과목만 보기"
                />
              </FormGroup>

              <FormGroup sx={{ display: "flex", flexDirection: "row" }}>
                <FormControlLabel
                  control={
                    <Checkbox
                      checked={formData.isCourseProhibit}
                      onChange={(e) =>
                        handleChange("isCourseProhibit", e.target.checked)
                      }
                    />
                  }
                  label="수강 금지 과목 제외"
                />
                <FormControlLabel
                  control={
                    <Checkbox
                      checked={formData.isScheduleConflict}
                      onChange={(e) =>
                        handleChange("isScheduleConflict", e.target.checked)
                      }
                    />
                  }
                  label="시간이 겹치는 과목 제외"
                />
              </FormGroup>
            </Box>
            <Button
              variant="contained"
              onClick={handleSearch}
              sx={{
                bgcolor: "background.default",
                color: "#ffffff",
                height: 50,
                mt: 5,
                borderRadius: 3,
              }}
            >
              조회하기
            </Button>
          </Box>

          <TableContainer component={Paper} sx={{ width: 900, mt: 4 }}>
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
                  <TableCell align="right" sx={{ color: "#ffffff" }}>요일</TableCell>
                  <TableCell align="right" sx={{ color: "#ffffff" }}>강의시간</TableCell>
                  <TableCell align="right" sx={{ color: "#ffffff" }}>정원</TableCell>
                  <TableCell align="right" sx={{ color: "#ffffff" }}>담기</TableCell>
                </TableRow>
              </TableHead>

              <TableBody>
                {courses.length === 0 ? (
                  <TableRow>
                    <TableCell colSpan={11} align="center">
                      조건에 맞는 강의가 없습니다.
                    </TableCell>
                  </TableRow>
                ) : (
                  courses.map((course, index) => (
                    <TableRow key={index}>
                      <TableCell>{course.courseName}</TableCell>
                      <TableCell align="right">{course.classDevision}</TableCell>
                      <TableCell align="right">{course.departmentName}</TableCell>
                      <TableCell align="right">{course.grade}</TableCell>
                      <TableCell align="right">{course.credit}</TableCell>
                      <TableCell align="right">{course.courseDevision}</TableCell>
                      <TableCell align="right">{course.professorName}</TableCell>
                      <TableCell align="right">{course.courseDay}</TableCell>
                      <TableCell align="right">{`${course.courseStartTime} - ${course.courseEndTime}`}</TableCell>
                      <TableCell align="right">{course.totalCapacity}</TableCell>
                      <TableCell align="right">
                        <IconButton
                          color="primary"
                          onClick={() => handleAddCourse(course)}
                          aria-label="add"
                          sx={{ color: "background.default" }}
                        >
                          <SystemUpdateAltIcon />
                        </IconButton>
                      </TableCell>
                    </TableRow>
                  ))
                )}
              </TableBody>

              {/* <TableBody>
                {courses.map((course, index) => (
                  <TableRow
                    key={index}
                    sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                  >
                    <TableCell>{course.courseName}</TableCell>
                    <TableCell align="right">{course.classDevision}</TableCell>
                    <TableCell align="right">{course.departmentName}</TableCell>
                    <TableCell align="right">{course.grade}</TableCell>
                    <TableCell align="right">{course.credit}</TableCell>
                    <TableCell align="right">{course.courseDevision}</TableCell>
                    <TableCell align="right">{course.professorName}</TableCell>
                    <TableCell align="right">{course.courseDay}</TableCell>
                    <TableCell align="right">{course.courseStartTime}</TableCell>
                    <TableCell align="right">{course.totalCapacity}</TableCell> */}
              {/* <TableCell>{course.courseName}</TableCell>
                    <TableCell align="right">{course.section}</TableCell>
                    <TableCell align="right">{course.department}</TableCell>
                    <TableCell align="right">{course.grade}</TableCell>
                    <TableCell align="right">{course.credits}</TableCell>
                    <TableCell align="right">{course.courseType}</TableCell>
                    <TableCell align="right">{course.professor}</TableCell>
                    <TableCell align="right">{course.schedule}</TableCell>
                    <TableCell align="right">{course.capacity}</TableCell> */}
              {/* </TableRow>
                ))}
              </TableBody> */}
            </Table>
          </TableContainer>

          {/* <div
          style={{
            height: "500px",
            border: "1px solid black",
            boxSizing: "border-box",
            position: "relative",
            overflow: "hidden",
          }}
          ref={timeTableCallbackRef}
        >
          {taskListWithAutoPosition.map((task, index) => (
            <TaskListItem task={task} style={task.style} key={index} />
          ))}
        </div> */}

        </Box>
      </Toolbar>
    </ThemeProvider>
  );
};

export default Index;

import {
    AppBar,
    Box,
    Tabs,
    Tab,
    ThemeProvider,
    Toolbar,
    Typography,
} from "@mui/material";
import { styled } from "@mui/material/styles";
import React from "react";
import { Link, useLocation } from "react-router-dom";
import theme from "theme"

const MenuTabs = styled(Tabs)({
    '& .MuiTabs-indicator': {
        backgroundColor: '#1890ff',
    },
    '& .MuiTab-root': {
        color: "#fff",
        fontSize: "1rem",
        '&:hover': {
            color: '#40a9ff',
            opacity: 1,
        },
        '&.Mui-selected': {
            color: "#ffeb3b",
        },
        '&.Mui-selected': {
            color: '#1890ff',
            fontWeight: theme.typography.fontWeightMedium,
        },
        '&.Mui-focusVisible': {
            backgroundColor: '#d1eaff',
        },
    },
});

const Header = () => {
    const location = useLocation();

    // 현재 경로에 맞게 탭 인덱스 설정
    const currentTab = (() => {
        switch (location.pathname) {
            case "/":
                return 0;
            case "/prerequisite":
                return 1;
            case "/transcript":
                return 2;
            case "/logout":
                return 3;
            default:
                return false;
        }
    })();

    return (
        <ThemeProvider theme={theme}>
            <AppBar position="static" sx={{ bgcolor: "background.default" }}>
                <Toolbar>
                    <Box
                        sx={{
                            flexGrow: 1,
                        }} >
                        <Typography
                            variant="h4"
                            component={Link}
                            to="/"
                            sx={{
                                fontWeight: "bold",
                                textDecoration: "none",  // 링크 스타일 제거
                                color: "inherit",        // 기본 색상 유지
                                '&:hover': {
                                },
                            }}>
                            Planmate
                        </Typography>
                    </Box>
                    <MenuTabs value={currentTab}>
                        <Tab label="강의 조회" component={Link} to="/" />
                        <Tab label="선수/후수 과목 조회" component={Link} to="/prerequisite" />
                        <Tab label="나의 성적표" component={Link} to="/transcript" />
                        <Tab label="로그아웃" component={Link} to="/transcript" />
                    </MenuTabs>
                </Toolbar>
            </AppBar>
        </ThemeProvider >
    );
};

export default Header;
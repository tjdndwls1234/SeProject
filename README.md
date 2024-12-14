# Planmate

## Proejct Scope

## Project Duration

2024년 2학기

## Highlighted features

## Project Constraints

## High Level Architecture

## Technology stacks

- Front-end: react(18.3.1), mui(6.1.9)
- Back-end: Java Spring
- DB: Oracle

## Project Deliverables

- 요구사항 분석 명세서: [링크](/artifacts/srs-수강신청도우미-v02-최종.docx)
- Software Architecture: [링크](/artifacts/srs-수강신청도우미-UML_Diagrams_Documents.docx)
- UI Design: [링크](/artifacts/srs-수강신청도우미-UI_Design_Document.docx)
- UI Design Diagram(Figma): [링크](/artifacts/수강신청%20도우미%20UI%20Design%20Diagram.fig)
- Coding Standard: [링크](/artifacts/srs-수강신청도우미-Coding%20standard.docx)

### Branch Description

- `main`: 최종 코드와 산출물이 모두 포함된 브랜치
- `develop`: 개발 중 통합과 테스트 및 버그 수정을 위한 브랜치
- `feature-register`: 회원가입, 로그인 기능 개발을 위한 브랜치
- `feature-frontend`: 프론트엔드 개발을 위한 브랜치
- `back-end`: 백엔드와 db 연결 및 강의 조회, 시간표 등의 기능 개발을 위한 브랜치
- `real_final`: 최종 시연을 위한 테스트 및 버그 수정을 위한 브랜치

### Code Documentation

#### Front-end

프론트엔드의 코드는 /app/planmate/src/ 폴더에 위치해 있다. react를 사용해 Single Page Application으로 구현했고, 페이지 이동을 위해 react-router-dom을 사용했다. 디자인은 mui를 기반으로 커스터마이즈 해서 사용했다. 주요 페이지들은 /pages 폴더에 구현되어 있고, 페이지가 공통으로 사용하는 요소는 /components 폴더에 구현했다.

- `App.js`: 웹 애플리케이션의 메인 진입점 역할을 하며, react-router-dom을 사용해 페이지 이동을 관리한다.
- `/pages/Login.js`: 로그인 페이지를 구현한 코드이다. 입력 필드와 각 입력에 대한 검증 로직이 구현되어 있고, 올바른 입력이 들어오면 서버에 로그인을 요청한다.
- `/pages/Register.js`: 회원가입 페이지를 구현한 코드이다. 페이지 로드 시 서버로부터 학과 리스트를 받아와 유저에게 보여준다. 입력 필드와 각 입력에 대한 검증 로직이 구현되어 있고, 올바른 입력이 들어오면 서버에 회원가입을 요청한다.
- `/pages/Transcript.js`: 성적표 페이지를 구현한 코드이다. 유저는 로그인 된 상태일때 해당 페이지에 접근할 수 있다. 페이지 로드 시 서버로부터 유저의 성적표 정보를 받아와 유저에게 보여준다. 유저는 자신의 성적표를 테이블 형태로 확인할 수 있고, 직접 수정해 서버에 저장할 수 있다.
- `/pages/Prerequisite.js`: 선수/후수 과목 조회 페이지를 구현한 코드이다. 페이지 로드 시 서버로부터 학과 리스트를 받아와 유저에게 보여준다. 유저가 학과를 선택 시 서버에 해당 학과의 선수/후수 과목 리스트를 요청해 테이블 형태로 보여준다.
- `/pages/Index.js`: 강의 조회 페이지를 구현한 코드이다. 유저가 조회 버튼을 누르면 필터에 설정된 값으로 서버에게 강의 리스트를 요청해 테이블 형태로 보여준다. 유저가 특정 강의에 대해 시간표에 담기 버튼을 누르면 서버에 요청을 보내 유저의 시간표에 추가한다.
- `/components/Header.js`: 강의 조회, 선수/후수 과목 조회, 성적표 페이지에서 사용되는 헤더를 구현한 코드이다. 각 메뉴를 누르면 페이지를 이동할 수 있고, 현재 페이지는 메뉴에 파란색으로 강조 표시되도록 구현했다. 각 페이지에서는 `<Header />`를 추가하는 것으로 사용할 수 있다.

#### Back-end

### Test Case and Result

## Repository Structure

## Project Team Members (w/roles)

2019920026 서웅진 (DB 구현 및 관리)

2019920011 김민서 (백엔드)

2020920018 류재욱 (프론트엔드)

2021910033 정명훈 (프론트엔드)

2021920017 김영신 (백엔드)

# 출석

## 파일 읽기
- [x] attendances.csv 파일을 읽는다
- [x] 파일을 읽은 후 닉네임과 등교 정보를 저장한다.

## 입력
- [x] 기능 선택을 입력받는다.
  - Exception
    - [x] 잘못된 입력을 받을 경우, 예외를 발생시킨다.
    - [x] 주말 및 공휴일에 출석을 누를 경우, 예외를 발생시킨다.
- [x] 닉네임을 입력받는다.
  - Exception
    - [x] 닉네임이 존재하지 않을 경우, 예외를 발생시킨다.
- [x] 등교 시간을 입력받는다.
  - Exception
    - [x] 00:00 형태가 아닐 경우, 예외를 발생시킨다.

## 출석
- [x] 닉네임과 등교 시간을 입력해 출석을 진행한다.

## 출석 수정
- [ ] 닉네임, 날짜, 시간을 입력해 출석 기록을 변경할 수 있다.

## 출석 기록 확인
- [ ] 닉네임을 입력하면 전날까지의 크루 출석 기록을 확인한다.
  - [ ] 지각, 출석 정보를 표기한다.

## 결과 계산
- [ ] 출석 횟수, 지각 횟수, 결석 횟수를 저장한다.

## 제적 위험자 확인
- [ ] 출석 기록을 바탕으로, 제적 위험자를 파악한다.
  - [ ] 제적 대상자, 면담 대상자, 경고 대상자순으로 출력한다.

## 출력
- [ ] 현재 날짜를 담은 기능 선택 메세지를 출력한다.
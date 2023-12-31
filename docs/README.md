# 기능목록

### 입력
- [x] 비상 근무 스케쥴 생성할 월과 시작 요일 입력
  - [x] 오류 발생시 다시 입력
- [x] 평일, 휴일 비상 근무 순번대로 사원 닉네임 입력
  - [x] 오류 발생시 평일 순번 입력부터 다시 입력

### 출력
- [x] 비상 근무표 출력
  - [x] 평일이면서 공휴일인 경우에만 (휴일) 을 붙여 출력

### 비즈니스
- [x] 법정 공휴일 정보 저장하기
- [x] 월, 일, 요일 정보 저장하며 평일, 휴일, 평일+공휴일 인지 판단하기
- [x] 한달 스케쥴을 만들기 위한 날짜 생성 기능 구현
- [x] 날짜 정보와 근무 인원 정보 저장하기
- [x] 한달 스케쥴을 가지는 객체 생성하기
- [x] 근무 인원 생성해 제공하기 (Week / Weekend 에 따라)
- [x] 각 날짜에 근무 인원 배정하기 (연속근무 상관 없이)
- [x] 근무 스케쥴에서 연속 근무 확인하기
- [x] 연속 근무 발생자 대체하기

# 미션 요구사항
### 비즈니스 로직 구현 방법
1. 먼저 이틀 연속 근무 상관 없이 작성한 평일, 휴일 근무 스케쥴대로 월간 스케쥴을 작성한다.
2. 그 후 월간 스케쥴에서 연속으로 근무하는 인원을 찾는다.
3. 연속 근무가 평일인지 휴일인지 파악 후 해당 근무자의 다음 근무자를 찾는다.
4. 이후 두 근무자를 바꿔 월간 스케쥴을 다시 생성한다.
5. 만약 변경 후에도 연속 근무가 발생한다면 2~4를 반복한다.

### 근로자 관련 요구사항
닉네임은 최대 5자
근무자 최소 수: 5
근무자 최대 수 : 35

### 비즈니스 요구사항
- 비상 근무 스케쥴에서 이틀 연속 근무는 불가능.
- 만약 이틀 연속 근무 스케쥴이 발생한 경우 다음 근무자와 순서를 바꿔 편성 -> 일회성? 아니면 계속?
- 비상 근무자 배정 시 다음 근무자와 순서를 바꿔야 하는 경우에는, 앞의 날짜부터 순서를 변경해야 한다???

### 법정 공휴일
- 1/1
- 3/1
- 5/5
- 6/6
- 8/15
- 10/3
- 10/9
- 12/25

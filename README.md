## Billage(강의실 대여 서비스) Android
( 구름톤 유니브 3기 )

---

## ✅ Commit Convention
**Message Structure**
```
[type] #이슈번호 Subject
```
**The Type**
|    Type    | Description                 |
|:----------:|-----------------------------|
|   `feat`   | 신규 기능 구현 작업 (새로운 기능, 특징 추가)     |
|   `fix`    | 버그 수정                       |
|  `style`   | 코드 스타일 관련 작업 (코드 의미 변경 X) |
| `refactor` | 리팩토링 작업                     |
| `test` | 테스트 코드 수정, 추가              |
|   `docs`   | 문서 관련 작업                   |
|  `chore`   | configs 변화 등 그 외 작업 (코드 변경 X) |

**예시**
```
[Feat] #1 소셜 로그인 기능 구현
[Fix] #1 홈화면 지도 기능 오류 수정
```

## 🧱 Branch Strategy
- Git flow
  - main
    - 배포 target
  - develop
    - 개발 target
  - Feat/#이슈번호
    - 예시: Feat/#3
  - Fix/#이슈번호
    - 예시: Fix/#2

## 👨‍💻 Code review
- PR 시 모두의 approve 를 받은 경우에 develop에 merge
- ...


## TodoApp

CRUD기능 구현

## Table
| todos     | type    |
|-----------|---------|
| id        | long    |
| title     | varchar |
| todoOrder | int     |
| completed | boolean |
ex)

| id | title | todoOrder | completed |
|----|-------|-----------|-----------|
| 1  | 운동하기  | 1         | false     |




## Error

#### 1. H2 DB error
```java
@Entity(name = "order") //사용시에 에러가 발생 > h2는 order가 예약어

@Entity(name = "`order`") // 백틱 사용하면 정상동작
``` 

#### 2. Test error
Test site : https://todobackend.com/client/index.html 이용

Site상에서 테스트를 정상통과하기 위해서는 `response` 로 `url`변수가 필요하다.
```text
✔ each new todo has a url
```
url을 ResponseDto값으로 전달
```java
this.url = "http://localhost:8080/" + this.id;
```


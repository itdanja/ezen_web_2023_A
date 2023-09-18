<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비회원제 게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .post {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            background-color: #fff;
        }

        .post h2 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        .post p {
            font-size: 16px;
        }

        .post .date {
            font-size: 12px;
            color: #777;
        }

        .post .author {
            font-size: 14px;
            font-weight: bold;
        }

        .post .content {
            margin-top: 10px;
        }

        .post .actions {
            margin-top: 10px;
        }

        .post .actions a {
            text-decoration: none;
            color: #007bff;
            margin-right: 10px;
        }

        .post .actions a:hover {
            text-decoration: underline;
        }
        .add-post-button {
            text-align: center;
            margin-top: 20px;
        }

        .add-post-button a {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }

        .add-post-button a:hover {
            background-color: #0056b3;
        }
        
          header {
            background-color: #333;
            color: #fff;
            text-align: right; /* 오른쪽 정렬로 수정 */
            padding: 20px;
        }

        .add-post-button {
            float: right; /* 오른쪽으로 이동 */
            margin-top: 20px;
        }

        .add-post-button a {
            display: inline-block;
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
        }

        .add-post-button a:hover {
            background-color: #0056b3;
        }
        
    </style>
</head>
<body>
    <header>
        <h1>비회원제 게시판</h1>
    </header>
    <div class="container">

        
        <div class="post">
            <h2>게시물 제목 1</h2>
            <p class="date">게시일: 2023-09-15</p>
            <p class="author">작성자: 홍길동</p>
            <div class="content">
                게시물 내용이 여기에 들어갑니다.
            </div>
            <div class="actions">
                <a href="#">수정</a>
                <a href="#">삭제</a>
            </div>
        </div>
        
        <div class="post">
            <h2>게시물 제목 2</h2>
            <p class="date">게시일: 2023-09-16</p>
            <p class="author">작성자: 이몽룡</p>
            <div class="content">
                게시물 내용이 여기에 들어갑니다.
            </div>
            <div class="actions">
                <a href="#">수정</a>
                <a href="#">삭제</a>
            </div>
        </div>
    </div>
    
    <script>
        // 글쓰기 버튼 클릭 이벤트 처리
        document.getElementById("add-post").addEventListener("click", function(event) {
            event.preventDefault(); // 기본 동작 방지 (링크 이동)
            // 여기에 글쓰기 버튼을 클릭했을 때의 동작을 추가
            // 예를 들어, 새 게시물 작성 페이지로 이동하거나 모달 창을 열 수 있습니다.
        });

        // 수정 버튼 클릭 이벤트 처리 (예시: 수정 버튼의 id를 "edit-post"로 가정)
        document.getElementById("edit-post").addEventListener("click", function(event) {
            event.preventDefault();
            // 여기에 수정 버튼을 클릭했을 때의 동작을 추가
        });

        // 삭제 버튼 클릭 이벤트 처리 (예시: 삭제 버튼의 id를 "delete-post"로 가정)
        document.getElementById("delete-post").addEventListener("click", function(event) {
            event.preventDefault();
            // 여기에 삭제 버튼을 클릭했을 때의 동작을 추가
        });
    </script>
    
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="StringUtils"
	class="com.amolrang.modume.utils.StringUtils" />

<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="/css/join.css">
  </head>
  <body>
    <div id="sectionContainerCenter">
		<div>
      <div id="header">
        <h1>create account</h1>
      </div>
			<div class="msg">${err}</div>
			<form id="frm" class="frm" action="/join" method="post">
				<div id="idChkResult" class="msg"></div>
        <div class="input-container">
					<input type="text" name="userName" placeholder="이름">
				</div>
				<div class="input-container">
					<input type="text" name="id" placeholder="아이디">
					<button type="button" onclick="chkId()">중복체크</button>
				</div>
				<div class="input-container">
					<input type="password" name="password" placeholder="비밀번호">
				</div>
				<div class="input-container">
					<input type="password" name="password_re" placeholder="비밀번호 확인">
				</div>
				<div class="sbm-join">
					<input type="submit" value="회원가입">
				</div>
			</form>
			<div class="move">
				<a href="${login}">로그인</a>
				<a href="/">메인화면</a>
			</div>
		</div>
		</body>
		<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
		<script>
			function chkId() {
				const id = frm.id.value
				axios.post('/IdChk', {id}).then(function(res) {
					if(res.data == '2') { //아이디 없음
						idChkResult.innerText = '사용할 수 있는 아이디입니다.'
					} else if(res.data == '3') { //아이디 중복됨
						idChkResult.innerText = '이미 사용중입니다.'
					}
				})
				
			}
		</script>
</html>
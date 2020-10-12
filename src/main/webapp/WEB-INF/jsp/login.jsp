<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="StringUtils" class="com.amolrang.modume.utils.StringUtils"/>

<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
    <div id="container">
      <form id="frm" action="/loginAction" method="post">
      <fieldset class="fld-login">
        <legend class="legend">login</legend>
          <div class="input-container focus">
              <label class="move active" for="id"></label><input type="text" class="no-border active " id="id" name="id" placeholder="ID"   options="{ updateOn: 'keyup blur' }" required >
          </div>
          <div class="input-container focus">
            <label class="move active" for="password"></label><input type="password" class="no-border active" id="password" name="password" placeholder="PASSWORD" autocomplete="off"  options="{ updateOn: 'keyup blur' }"  required>
          </div>
      </fieldset>
      <input class="sbm-login" type="submit" value="sign in">
      <input name="${_csrf.parameterName}" type="hidden" value="${_crsf.token}">
      </form>
      <div class="sbm-join">
        <a href="/join">sign up</a>
      </div>
    </div>
  </body>

  </html>
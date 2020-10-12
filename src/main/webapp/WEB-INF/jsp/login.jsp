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
        <a href="">sign up</a>
      </div>
    </div>
  </body>
  <script>

  window.onload = function(){

    inputEvent();
    if(('form').find(':input')[0]!==undefined){
      (':focus').blur();
      ('form').find(':input')[0].focus();
    }
  };

  var inputEvent = function() {
    var inputs = ('form').find(':input');
    inputs.each(function() {
      var input = (this),
          label = input.parent('div.input-container');
      if (input.val())
        label.addClass('active');

      input.focusin(function() {
        label.addClass('focus');
        label.siblings('div.flexbdy').addClass('off');
      });
      input.change(function() {
        label.addClass('active');
      });
      input.focusout(function() {
        label.removeClass('focus');

        if (!input.val()) label.removeClass('active').siblings('div.flexbdy').removeClass('off');
      });
    }
    );
  }
  </script>
  </html>
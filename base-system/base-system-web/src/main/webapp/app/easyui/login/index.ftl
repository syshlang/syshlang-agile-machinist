<!DOCTYPE html>
<html>
<head>
	<title>文档管理系统</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" type="text/css" href="${uiPath}/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="${uiPath}/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${uiPath}/easyui/themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="${uiPath}/css/common.css">
    <link rel="stylesheet" type="text/css" href="${uiPath}/css/jquery-ui-1.9.2.custom.min.css"   />
    <link rel="stylesheet" type="text/css" href="${uiPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${uiPath}/easyui/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${uiPath}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${uiPath}/js/lib/jquery.format.js"></script>
    <script type="text/javascript" src="${uiPath}/js/common/pascloudfunctions.js"></script>
    <link rel="stylesheet" type="text/css" href="/app/easyui/login/css/login.css">
    <script type="text/javascript" src="/app/easyui/login/js/login.js"></script>

    <script type="text/javascript">
        if (window != top){
            top.location.href = location.href;  
        }
     
    </script>
</head>
<body>
    <canvas id="canvas"></canvas>
    <div class="wrapper">
        <form class="form-signin">
          <h2 class="form-signin-heading">登录</h2>
          <input type="text" class="form-control" name="username" id="username" placeholder="Email Address" required="" autofocus="" value="admin"/>
          <input type="password" class="form-control" name="password" id="password" placeholder="Password" required="" value="123456"/>
          <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> 是否记住
          </label>
          <button id="login" class="btn btn-lg btn-primary btn-block" type="button" onClick="loginAction()">登录</button>
          <div id="msg" style="margin-top:5px;color:red;display:none;"></div>
        </form>
    </div>
</body>
<script type="text/javascript" src="/app/easyui/login/js/canvas_star.js"></script>
</html>

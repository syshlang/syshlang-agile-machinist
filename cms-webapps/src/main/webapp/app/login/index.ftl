<!DOCTYPE html>
<html>
<head>
	<title>文档管理系统</title>
    <script src="/app/include/head.js"></script>
    <link rel="stylesheet" type="text/css" href="/app/login/css/login.css">
    <script type="text/javascript" src="/app/login/js/login.js"></script>
    
    <script type="text/javascript">
        if (window != top){
            top.location.href = location.href;  
        }
     
    </script>
</head>
<body>
    <div class="wrapper">
    <form class="form-signin">       
      <h2 class="form-signin-heading">登录</h2>
      <input type="text" class="form-control" name="username" id="username" placeholder="Email Address" required="" autofocus="" />
      <input type="password" class="form-control" name="password" id="password" placeholder="Password" required=""/>      
      <label class="checkbox">
        <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> 是否记住
      </label>
      <button id="login" class="btn btn-lg btn-primary btn-block" type="button" onClick="loginAction()">登录</button>  
      <div id="msg" style="margin-top:5px;color:red;display:none;"></div>
    </form>
    
    </div>
</body>
</html>

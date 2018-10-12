<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>${system_name}${system_env}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="author" content="sunys"/>
    <link rel="stylesheet" href="${uiPath}/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/app/layui/login/css/login.css">
    <script>
        if (window != window.top) top.location.href = self.location.href;
        var basePath = '${basePath}';
    </script>
</head>
<body>
    <canvas id="canvas"></canvas>
    <div class="container">
        <div class="admin-login-background">
            <form class="layui-form">
                <div class="layui-input admin-input admin-header">
                    <h2>登录</h2>
                </div>
                <div>
                    <i class="layui-icon layui-icon-username admin-icon admin-icon-username"></i>
                    <input type="text" id="username" name="username" placeholder="请输入用户名"
                           autocomplete="off" lay-verify="required|username"
                           class="layui-input admin-input ">
                </div>
                <div>
                    <i class="layui-icon layui-icon-password admin-icon admin-icon-password"></i>
                    <input type="password" id="password" name="password" placeholder="请输入密码"
                           autocomplete="off"  lay-verify="required|password"
                           class="layui-input admin-input">
                </div>
                <div >
                    <input type="text" id="verify" name="verify" placeholder="请输入验证码"
                           autocomplete="off" lay-verify=""
                           class="layui-input admin-input admin-input-verify">
                    <img class="admin-captcha" src="" onclick="updateVerify()">
                </div>
                <div>
                    <i class="layui-icon layui-icon-rememberMe admin-icon admin-icon-rememberMe"></i>
                    <input type="checkbox" checked="" id="rememberMe" name="rememberMe" lay-skin="switch" lay-text="是|否">
                    <label class="layui-form-label admin-rememberMe">记住密码</label>
                </div>
                <button type="button" class="layui-btn admin-button" lay-submit lay-filter="login" id="loginBtn">登录</button>
            </form>
        </div>
    </div>
    <div class="admin-login-footer">
        <span>Copyright&nbsp;&nbsp;© 2017-2018&nbsp;&nbsp;<a href="https://syshlang.github.io/">syshlang.</a> &nbsp;All Rights Reserved </span>
    </div>
</body>
<script type="text/javascript"  src="${uiPath}/layui.js"></script>
<script type="text/javascript"  src="${basePath}/app/layui/common/base-common.js"></script>
<script type="text/javascript" src="${basePath}/app/layui/login/js/login.js"></script>
<script type="text/javascript" src="${basePath}/app/layui/login/js/canvas_star.js"></script>
</html>

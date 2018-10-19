<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${system_name}${system_env}</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta name="author" content="sunys"/>
    <meta name="renderer" content="webkit">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="${uiPath}/css/layui.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/app/layui/common/base-common.css">
    <link rel="stylesheet" type="text/css" href="${basePath}/app/layui/home/css/home.css">
    <script>
        if (window != window.top) top.location.href = self.location.href;
        var basePath = '${basePath}';
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#--https://gitee.com/lylyly123/based_on_the_layui_community/tree/master/src/main/webapp/js-->
    <!-- 顶部 -->
    <div class="layui-header header">
        <div class="layui-main">
            <a href="#" class="logo">${system_name}${system_env}</a>
            <!-- 显示/隐藏菜单 -->
            <a href="javascript:;" class="iconfont hideMenu icon-menu1"></a>
            <!-- 顶部右侧菜单 -->
            <ul class="layui-nav top_menu">
                <li class="layui-nav-item showNotice" id="showNotice" pc>
                    <a href="javascript:;">
                        <i class="iconfont icon-gonggao"></i>
                        <cite>系统公告<span class="layui-badge">9</span></cite>
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="">个人中心<span class="layui-badge-dot"></span></a>
                </li>
                <li class="layui-nav-item" lay-unselect="">
                    <a href="javascript:;"><img src="//t.cn/RCzsdCq" class="layui-nav-img">admin</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">修改信息</a></dd>
                        <dd><a href="javascript:;">安全管理</a></dd>
                        <dd><a href="${basePath}/logout">退了</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <!-- 左侧导航 -->
    <div class="layui-side layui-bg-black">
        <div class="navBar layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">默认展开</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${basePath}/swagger-ui.html">选项1</a></dd>
                        <dd><a href="${basePath}/swagger-ui.html">选项2</a></dd>
                        <dd><a href="${basePath}/swagger-ui.html">跳转</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">解决方案</a>
                    <dl class="layui-nav-child">
                        <dd><a href="${basePath}/swagger-ui.html">移动模块</a></dd>
                        <dd><a href="${basePath}/swagger-ui.html">后台模版</a></dd>
                        <dd><a href="${basePath}/swagger-ui.html">电商平台</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="${basePath}/swagger-ui.html">产品</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${basePath}/swagger-ui.html">大数据</a>
                </li>
            </ul>
        </div>
        <div class="navBar"></div>
    </div>
    <!-- 右侧内容 -->
    <div class="layui-body layui-form">
        <div class="layui-tab marg0" lay-filter="bodyTab" id="top_tabs_box">
            <ul class="layui-tab-title top_tab" id="top_tabs">
                <li class="layui-this" lay-id=""><i class="iconfont icon-computer"></i> <cite>首页</cite></li>
            </ul>
            <!-- 当前页面操作 -->
            <ul class="layui-nav closeBox">
                <li class="layui-nav-item" pc>
                    <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#x1002;</i> 刷新当前</a></dd>
                        <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i> 关闭其他</a></dd>
                        <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i> 关闭全部</a></dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div class="layui-tab-item layui-show">
                    <iframe src="${basePath}/swagger-ui.html"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 移动导航 -->
<div class="site-tree-mobile layui-hide"><i class="layui-icon">&#xe602;</i></div>
<div class="site-mobile-shade"></div>
<div class="admin-login-footer">
    <span>Copyright&nbsp;&nbsp;© 2017-2018&nbsp;&nbsp;<a href="https://syshlang.github.io/">syshlang.</a> &nbsp;All Rights Reserved </span>
</div>
</body>
<script type="text/javascript"  src="${uiPath}/layui.js"></script>
<script type="text/javascript"  src="${basePath}/app/layui/common/base-common.js"></script>
<script type="text/javascript" src="${basePath}/app/layui/home/js/home.js"></script>
</html>
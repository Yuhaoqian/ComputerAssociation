<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link rel="stylesheet" href="res/layui/css/layui.css">
    <link rel="stylesheet" href="res/css/global.css">
    <script src="res/layui/layui.js"></script>
</head>
<body>
<div class="header">
    <div class="main">
        <h1 href="indexManage.jsp" style="margin-left: 30px;line-height: 65px; color: white;font-size: 18px;">计算机协会系统后台</h1>
        <div class="nav">

        </div>


    </div>
</div>


<div class="main fly-user-main layui-clear">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item reload"><a href="index.html" id = "home"> <i
                class="layui-icon">&#xe609;</i> 首页 </a></li>
        <li class="layui-nav-item reload layui-this"><a href="notices.jsp" target="right"> <i
                class="layui-icon">&#xe612;</i> 新闻&通知</a></li>
        <li class="layui-nav-item reload"><a href="role.jsp" target="right"> <i
                class="layui-icon">&#xe611;</i> 社员管理</a></li>
        <li class="layui-nav-item reload"><a href="articles.jsp" target="right"> <i
                class="layui-icon">&#xe611;</i> 文章管理</a></li>
        <li class="layui-nav-item  "><a href="javascript:void(0)" onclick="updatePwd('修改密码',2)"> <i
                class="layui-icon">&#xe620;</i> 修改密码 </a></li>
        <li class="layui-nav-item reload"><a href="charts-1.jsp" target="right"> <i
                class="layui-icon">&#xe61a;</i> 社团财务管理 </a></li>
        <li class="layui-nav-item reload"><a href="fundDetail.jsp" target="right"> <i
                class="layui-icon">&#xe61a;</i> 社团财务明细 </a></li>
    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="fly-panel fly-panel-user">
    <div class="layui-tab layui-tab-brief" lay-filter="user">

        <div class="layui-tab-content" style="padding: 20px;padding-top: 0px;">

            <iframe src="notices.jsp" width="88%" style="border: none;" height="800" border="none"
                    name="right"></iframe>
        </div>
    </div>
</div>
</div>

<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="myplugs/js/plugs.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script>
    layui.use('element', function () {
        var element = layui.element();
    });
</script>
<script>

    layui.cache.page = '';
    layui.cache.user = {
        username: '游客'
        , uid: -1
        , avatar: '../res/images/avatar/00.jpg'
        , experience: 83
        , sex: '男'
    };
    
    //添加编辑弹出层
    function updatePwd(title, id) {
        $.jq_Panel({
            title: title,
            iframeWidth: 500,
            iframeHeight: 300,
            url: "updatePwd.jsp"
        });
    }
    $(function(){
    	$('.reload').on('click',function(){
    		$.jq_Panel_close();
    	});
    });
</script>
</body>
</html>
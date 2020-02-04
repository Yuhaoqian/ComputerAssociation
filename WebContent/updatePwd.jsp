<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="res/css/amazeui.min.css">
    <link rel="stylesheet" href="res/css/admin.css">
<!--    <link rel="stylesheet" href="res/css/app.css">-->
    <style>
        .admin-main {
            padding-top: 0px;
        }

        .am-form {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-g">
                <form class="am-form am-form-horizontal"
                      method="post"
                      style="padding-top:30px;" data-am-validator>
                    <div class="am-form-group">
                        <label for="doc-vld-pwd-1" class="am-u-sm-3 am-form-label">
                            新密码 </label>
                        <div class="am-u-sm-9">
                            <input type="password" id="doc-vld-pwd-1" required placeholder="请输入新密码"
                                   name="password">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="doc-vld-pwd-2" class="am-u-sm-3 am-form-label">
                            重复密码</label>
                        <div class="am-u-sm-9">
                            <input type="password" id="doc-vld-pwd-2" required placeholder="请输入重复密码"
                                   name="pwd" data-equal-to="#doc-vld-pwd-1" required>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <input type="submit" class="am-btn am-btn-success" value="修改密码"/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript"
        src="js/jquery-1.11.3.min.js">
</script>
<script type="text/javascript" src="myplugs/js/plugs.js">
</script>
</body>
</html>

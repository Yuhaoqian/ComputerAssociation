<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

    <link rel="stylesheet" href="res/css/amazeui.min.css">
    <link rel="stylesheet" href="res/css/admin.css">
	<script src="js/jquery-1.12.4.js"></script>
    <style>
        .admin-main{
            padding-top: 0px;
        }
        .temp{
            height: 35px;
            line-height: 35px;
            padding-left: 20px;
            font-size: 18px;
        }
        .temp input:last-child{
            margin-left: 20px;
        }
    </style>
</head>
<body>

<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-g">
                <form class="am-form am-form-horizontal" action="addRoleServlet" method="post" style="padding-top: 30px;">
                    <input value="504" name="roleId" type="hidden">
                    <div class="am-form-group">
                        <label for="roleName" class="am-u-sm-3 am-form-label">
                            姓名：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="roleName" placeholder="请输入姓名" type="text" name="roleName">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="roleID" class="am-u-sm-3 am-form-label">
                            学号：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="roleID" placeholder="请输入学号" type="text" name="roleID">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="rolePWD" class="am-u-sm-3 am-form-label">
                            密码：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="rolePWD" placeholder="请输入密码" type="password" name="rolePWD">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="rolePWDCheck" class="am-u-sm-3 am-form-label">
                            确认密码：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="rolePWDCheck" placeholder="请再次输入密码" type="password" name="rolePWDCheck">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label class="am-u-sm-3 am-form-label">
                            性别：
                        </label>
                        <div class="am-u-sm-9 temp">
                            <input type="radio" value="male" name="sex">Male<input type="radio" value="female" name="sex">Female
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="roleMajor" class="am-u-sm-3 am-form-label">
                            专业：
                        </label>
                        <div class="am-u-sm-9">
                            <input type="text" id="roleMajor" placeholder="请输入专业" name="roleMajor">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="roleMail" class="am-u-sm-3 am-form-label">
                            邮箱：
                        </label>
                        <div class="am-u-sm-9">
                            <input type="email" id="roleMail" placeholder="请输入邮箱" name="roleMail">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="roleQQ" class="am-u-sm-3 am-form-label">
                QQ：
                        </label>
                        <div class="am-u-sm-9">
                            <input type="txt" id="roleQQ" placeholder="请输入QQ" name="roleQQ">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="roleTel" class="am-u-sm-3 am-form-label">
                            电话：
                        </label>
                        <div class="am-u-sm-9">
                            <input type="text" id="roleTel" placeholder="请输入电话号码" name="roleTel">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="roleDep" class="am-u-sm-3 am-form-label">
                            部门：
                        </label>
                        <div class="am-u-sm-9">
                            <input type="text" id="roleDep" placeholder="请输入所属部门" name="roleDep">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="rolePos" class="am-u-sm-3 am-form-label">
                            权限：
                        </label>
                        <div class="am-u-sm-9 temp">
                            <input type="radio" value="普通用户" name="rolePos">普通用户<input type="radio" value="管理员" name="rolePos">管理员
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <input id="addRole" class="am-btn am-btn-success" value="添加用户" type="submit">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
	$(function(){
		$('#addRole').on('click',function () {
			$("form").submit(function(e){
				  alert("提交成功！");
				  parent.window.location.reload();
			}); 
	    });
	});
</script>
 
</body>
</html>

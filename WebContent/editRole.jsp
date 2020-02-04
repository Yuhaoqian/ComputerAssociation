<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		
			<link rel="stylesheet" href="res/css/amazeui.min.css">
		<link rel="stylesheet" href="res/css/admin.css">
<!--		<link rel="stylesheet" href="res/css/app.css">-->
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
		<script src="js/jquery-1.12.4.js"></script>
	</head>
	<body>
		
		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" action="editRoleServlet" method="post" style="padding-top: 30px;">
							<div class="am-form-group">
                        <label for="roleId" class="am-u-sm-3 am-form-label">
                         		   学号：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="roleId" type="text" readonly name="roleId">
                        </div>
                    </div>
							<div class="am-form-group">
								<label for="roleName" class="am-u-sm-3 am-form-label">
									姓名：
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" placeholder="请输入姓名" type="text" name="roleName">
								</div>
							</div>
							<div class="am-form-group">
								<label class="am-u-sm-3 am-form-label">
									性别：
								</label>
								<div class="am-u-sm-9 temp">
									<input type="radio" value="male" name="sex" class="sex">Male<input type="radio" value="female" name="sex" class="sex">Female
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
									<input type="radio" value="普通用户" name="rolePos" class="rolePos">普通用户<input type="radio" value="管理员" name="rolePos" class="rolePos">管理员
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="editRole" class="am-btn am-btn-success" value="编辑用户" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
<script>
	$(function(){
		$.getJSON('memberServlet',{'id':parent.getID()},function(result){
			let json = eval(result);
			$('#roleName').val(json.name);
			$('#roleMajor').val(json.major);
			$('#roleId').val(json.id);
			$('#roleMail').val(json.email);
			$('#roleTel').val(json.phone);
			$('#roleDep').val(json.department);
			$('#roleQQ').val(json.qq);
			$('.rolePos').each(function(indexm,element){
				if($(this).val()==json.position){
					$(this).prop('checked',true);
				}
			});
			$('.sex').each(function(indexm,element){
				if($(this).val()==json.sex){
					$(this).prop('checked',true);
				}
			});
		});
		$('#editRole').on('click',function () {
			parent.close();  
			parent.window.location.reload();
    	});
}); 
</script>
	</body>
</html>

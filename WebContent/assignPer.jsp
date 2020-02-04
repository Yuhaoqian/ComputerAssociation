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
        .admin-main{
            padding-top: 0px;
        }
        .per{
            height: 35px;
            line-height: 35px;
            padding-left: 20px;
            margin-top: 5px;
            font-size: 18px;
        }
        .per input:last-child{
            margin-left: 20px;
        }
        .perbox{
            margin: 10px 105px;
        }
        .setper{
        	margin-top: 20px;
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
                <form class="am-form am-form-horizontal" action="setPositionServlet" method="post" style="padding-top: 30px;">
                    <div class="am-form-group">
                        <label for="roleId" class="am-u-sm-3 am-form-label">
                            学号：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="roleId" type="text" readonly name="roleId">
                        </div>
                    </div>
                    <div class="am-form-group perbox">
                        <label class="am-u-sm-3 am-form-label">
                            权限：
                        </label>
                        <div class="am-u-sm-9 per">
                            <input type="radio" class="rolePer" value="普通用户" name="rolePos">普通用户<input type="radio" class="rolePer" value="管理员" name="rolePos">管理员
                        </div>
                        
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <input id="assignPer" class="am-btn am-btn-success setper" value="设置权限" type="submit">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
	$(function(){
		$.getJSON('assignServlet',{'id':parent.getPerID()},function(result){
			let json = eval(result);
			$('.rolePer').each(function(indexm,element){
				if($(this).val()==json.per){
					$(this).prop('checked',true);
				}
			});
			$('#roleId').val(json.id);
		});
		$('#assignPer').on('click',function () {
			parent.close();  
			parent.window.location.reload();
    	});
}); 
</script>
</body>
</html>

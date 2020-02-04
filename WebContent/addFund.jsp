<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>

    <link rel="stylesheet" href="res/css/amazeui.min.css">
    <link rel="stylesheet" href="res/css/admin.css">
    <style>
        .admin-main{
            padding-top: 0px;
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
                <form class="am-form am-form-horizontal" action="addFundServlet" method="post" style="padding-top: 30px;">
                    <input value="504" name="roleId" type="hidden">
                    <div class="am-form-group">
                        <label for="fundID" class="am-u-sm-3 am-form-label">
                            日志编号：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="fundID" placeholder="请输入编号" value="" type="text" name="fundID">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="fundPurpose" class="am-u-sm-3 am-form-label">
                            资金用途：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="fundPurpose" placeholder="请输入用途" value="" type="text" name="fundPurpose">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="fundAmount" class="am-u-sm-3 am-form-label">
                           资金：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="fundAmount" placeholder="请输入资金" value="" type="text" name="fundAmount">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="fundTime" class="am-u-sm-3 am-form-label">
                           调度时间：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="fundTime" placeholder="请输入时间"  type="datetime-local" name="fundTime">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="userId" class="am-u-sm-3 am-form-label">
                           调度人：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="userId" placeholder="请输入调度人" value="" type="text" name="userId">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="totalAmount" class="am-u-sm-3 am-form-label">
                            剩余资金：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="totalAmount" placeholder="请输入剩余资金" type="text" name="totalAmount"></textarea>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <input id="addFund" class="am-btn am-btn-success close" value="提交通知" type="submit">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
	$(function(){
		$('#addFund').on('click',function () {
			    $("form").submit(function(e){
					  alert("提交成功！");
					  parent.close();  
					  parent.window.location.reload();
				});
        });
	}); 
</script>
</body>
</html>

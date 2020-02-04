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
        #noticeId{
			width: 400px;
			margin: 0 auto;  
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
                <form class="am-form am-form-horizontal" action="editNoticeServlet" method="post" style="padding-top: 30px;">
                <div class="am-form-group">
                        <label for="noticeId" class="am-u-sm-3 am-form-label">
                            通知编号：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticeId" type="text" readonly name="noticeId">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="noticeName" class="am-u-sm-3 am-form-label">
                            通知标题：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticeName" placeholder="请输入标题" value="" type="text" name="noticeTheme">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="noticeFund" class="am-u-sm-3 am-form-label">
                           活动预算：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticeFund" placeholder="请输入资金" value="" type="text" name="noticeFund">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="noticePlace" class="am-u-sm-3 am-form-label">
                           活动地点：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticePlace" placeholder="请输入地点" value="" type="text" name="noticePlace">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="noticeTime" class="am-u-sm-3 am-form-label">
                           活动时间：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticeTime" placeholder="请输入时间" value="" type="datetime-local" name="noticeTime">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="noticeSponsor" class="am-u-sm-3 am-form-label">
                           活动主办人：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticeSponsor" placeholder="请输入主办人" value="" type="text" name="noticeSponsor">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="notice" class="am-u-sm-3 am-form-label">
                            通知详情：
                        </label>
                        <div class="am-u-sm-9">
                            <textarea id="notice" rows="7" cols="50" placeholder="请输入通知详情"  name="notice"></textarea>
                        </div>
                    </div>
                    <div class="am-form-group">
                        <label for="noticeImg" class="am-u-sm-3 am-form-label">
                           活动图片：
                        </label>
                        <div class="am-u-sm-9">
                            <input id="noticeImg" placeholder="请输图片名称" value="" type="text" name="noticeImg">
                        </div>
                    </div>
                    <div class="am-form-group">
                        <div class="am-u-sm-9 am-u-sm-push-3">
                            <input id="editNotice" class="am-btn am-btn-success" value="修改通知" type="submit">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
	$(function(){
		$.getJSON('activityServlet',{'id':parent.getID()},function(result){
			let json = eval(result);
			$('#noticeName').val(json.theme);
			$('#noticeFund').val(json.amount);
			$('#noticePlace').val(json.position);
			$('#noticeTime').val(json.actTime);
			$('#noticeSponsor').val(json.sponsor);
			$('#notice').val(json.content);
			$('#noticeId').val(json.id);
			$('#noticeImg').val(json.img);
		});
		$('#editNotice').on('click',function () {
			parent.close();  
			parent.window.location.reload();
    	});
}); 
</script>

</body>
</html>

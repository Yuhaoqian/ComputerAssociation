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
    <link rel="stylesheet" href="myplugs/css/pageRecord.css">
</head>

<body>

<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">社员管理</strong><small></small></div>
    </div>

    <hr>

    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">

                    <button type="button" class="am-btn am-btn-default btnAdd">
                        <span class="icon-plus"></span> 新增
                    </button>
                    <button type="button" class="am-btn am-btn-default btnDel btnDelAll" style="margin-left: 10px">
                        <span class="icon-plus"></span> 删除所选
                    </button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input id="roleName" class="am-form-field" placeholder="请输入角色名称" type="text">
                <span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button" id="btnsearch">
										搜索
									</button> </span>
            </div>
        </div>
    </div>

    <div class="am-g" style="margin-top: 5px;">
        <div class="am-u-sm-12">
            <form class="am-form" action="#">
			</form>
		</div>
	</div>
<!-- content end -->
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery-1.11.3.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="myplugs/js/plugs.js"></script>
<script>
	var modifyID,delID,assignID;
    $(function () {
    	$('.am-form').jq_pageRecord({
			dataUrl:'memberServlet',
			theadContent:'<th class="table-id"><input id="chkAll" type="checkbox"></th>'+
			'<th>姓名</th><th class="table-title">学号</th><th class="table-title">权限</th>'+
			'<th class="table-set">操作</th>',
            tbodyContent:function(data){
            	let s='';
            	$.each(data,function(i,element){
    				s+='<tr><td><input class="chks" type="checkbox"></td><td>'+this.m_name+'</td><td><a href="#">'+
                    this.m_id+'</a></td><td>'+this.position+'</td><td><div class="am-btn-toolbar"><div class="am-btn-group am-btn-group-xs">'+
    				'<button type="button" id="role_701" class="am-btn am-btn-default am-btn-xs am-text-secondary btnEdit">'+
    				'<span class="am-icon-pencil-square-o"></span> 编辑'+
    				'</button><button type="button" class="am-btn am-btn-default am-btn-xs am-hide-sm-only btnAssign"><span'+
    				' class="am-icon-copy"></span> 分配权限</button><button type="button"'+
    				' class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only btnDel"'+
    				'><span class="am-icon-trash-o"></span> 删除</button></div></div></td></tr>';
    			});
            	return s;
            },
            footcolspan:5,
            pageSize:10
		});
		$(".am-form").on('click','.btnEdit',function () {
            $.jq_Panel({
                title: "修改用户",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "editRole.jsp"
            });
            modifyID=$(this).parent().parent().parent().siblings().eq(2).children().eq(0).html();
        });

        $(".btnAdd").on('click',function () {
            $.jq_Panel({
                title: "添加用户",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "addRole.jsp"
            });

        });
        $(".am-form").on('click','.btnDel',function () {
        	delID=$(this).parent().parent().parent().siblings().eq(2).children().eq(0).html();
            $.jq_Confirm({
            	message:"您正在删除该社员，是否继续？",
        		btnOkClick:function (){
        	    	let ids=[];
        	    	ids[0]=delID;
        			 $.ajax({  
        			    type : 'POST',  
        			    url:  'delRoleServlet',
        			    contentType: "application/x-www-form-urlencoded",
        			    data: {"ids": ids},
        			    success : function(data) {  
        			    }  
        			}); 
        			window.location.reload();
        	    }
            });

        });
        $(".btnDelAll").on('click',function () {
        	$.jq_Confirm({
        		message:"您正在删除所选社员，是否继续？",
        		btnOkClick:function(){
        	    	let ids=[];
        	    	$('.chks').each(function(index,element){
        	    		let ckb=$(this);
        	    		if(ckb.is(":checked")){
        	    			ids[index]=ckb.parent().siblings().eq(1).children().eq(0).html();
        	    		}
        	    	});
        			$.ajax({  
        			    type : 'POST',  
        			    url:  'delRoleServlet',
        			    contentType: "application/x-www-form-urlencoded",
        			    data: {"ids": ids},
        			    success : function(data) {  
        			    	console.log(1);
        			    }  
        			});
        			window.location.reload();
        	    }
        	});
        });
        $.chkAll();
		$(".am-form").on('click','.btnAssign',function () {
			$.jq_Panel({
				title: "分配权限",
				iframeWidth: 500,
				iframeHeight: 200,
				url: "assignPer.jsp"
			});
			modifyID=$(this).parent().parent().parent().siblings().eq(2).children().eq(0).html();
		});
    });
    function getID(){
		return modifyID;
	}
    function getPerID(){
		return modifyID;
	}
    function close(){
		$.jq_Panel_close();
	}

</script>
</body>

</html>
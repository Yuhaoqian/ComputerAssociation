<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="res/css/amazeui.min.css"/>
    <link rel="stylesheet" href="res/css/admin.css"/>
    <script src="js/jquery-1.12.4.js"></script>
    <link rel="stylesheet" href="myplugs/css/pageRecord.css">
	<style>
		.btnDelAll {
			left: 10px;
		}
	</style>
</head>

<body>
<div class="admin-content-body">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">文章管理</strong><small></small></div>
    </div>

    <hr>

    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button type="button" class="am-btn am-btn-default btnPassAll"> 全部通过</button>
					<button type="button" class="am-btn am-btn-default btnDelAll"> 删除所选</button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field">
                <span class="am-input-group-btn">
            <button class="am-btn am-btn-default" type="button">搜索</button>
          </span>
            </div>
        </div>
    </div>
    <div class="am-g">
        <div class="am-u-sm-12">
            <form class="am-form">
                <hr>
            </form>
        </div>
    </div>
</div>
<script src="js/jquery-1.11.3.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="myplugs/js/plugs.js"></script>
<script>	
	var delID,passID;
	$(function () {
	    	$('.am-form').jq_pageRecord({
				dataUrl:'GetArticleServlet',
				theadContent:'<th class="table-check"><input id="chkAll" type="checkbox"></th>'+
				'<th class="table-id" style="display:none">ID</th><th class="table-title">标题</th><th class="table-type">类别</th>'+
				'<th class="table-author am-hide-sm-only">作者</th><th class="table-date am-hide-sm-only">修改日期</th>'+
				'<th class="table-date am-hide-sm-only">是否通过</th><th class="table-set">操作</th>',
	            tbodyContent:function(data){
	            	console.log(data);
	            	let s='';
	            	$.each(data,function(i,element){
	    				s+='<tr><td><input class="chks" type="checkbox"></td><td style="display:none">'+this.id+'</td><td><a href="#">'+this.title+'</a>'+
	                    '</td><td>'+this.type+'</td><td class="am-hide-sm-only">'+this.poster+'</td><td class="am-hide-sm-only">'+
	                    this.postTime+'</td><td class="am-hide-sm-only">'+this.status+'</td><td><div class="am-btn-toolbar">'+
	                    '<div class="am-btn-group am-btn-group-xs">'+
	    				'<button type="button" id="role_701" class="am-btn am-btn-default am-btn-xs am-text-secondary btnPass">'+
	    				'<span class="am-icon-pencil-square-o"></span> 通过</button><button type="button" '+
	    				'class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only btnDel">'+
	    				'<span class="am-icon-trash-o"></span> 删除</button></div></div></td></tr>';
	    			});
	            	return s;
	            },
	            footcolspan:8,
	            pageSize:5
			});
			$(".am-form").on('click','.btnPass',function () {
				passID=$(this).parent().parent().parent().siblings().eq(1).html();
				$.jq_Confirm({
	        		message:"您正在检阅该篇文章，是否通过？",
	        		btnOkClick:function(){
	        	    	let ids=[];
	        	    	ids[0]=passID;
	        			$.ajax({  
	        			    type : 'POST',  
	        			    url:  'passArticleServlet',
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
	        		message:"您正在删除多篇文章，是否继续？",
	        		btnOkClick:function(){
	        	    	let ids=[];
	        	    	$('.chks').each(function(index,element){
	        	    		let ckb=$(this);
	        	    		if(ckb.is(":checked")){
	        	    			ids[index]=ckb.parent().siblings().eq(0).html();
	        	    		}
	        	    	});
	        			$.ajax({  
	        			    type : 'POST',  
	        			    url:  'delArticleServlet',
	        			    contentType: "application/x-www-form-urlencoded",
	        			    data: {"ids": ids},
	        			    success : function(data) {  
	        			    }  
	        			}); 
	        			window.location.reload();
	        	    }
	        	});
	        });
	        $(".am-form").on('click','.btnDel',function () {
	        	delID=$(this).parent().parent().parent().siblings().eq(1).html();
	            $.jq_Confirm({
	            	message:"您正在删除该篇文章，是否继续？",
	        		btnOkClick:function (){
	        	    	let ids=[];
	        	    	ids[0]=delID;
	        			 $.ajax({  
	        			    type : 'POST',  
	        			    url:  'delArticleServlet',
	        			    contentType: "application/x-www-form-urlencoded",
	        			    data: {"ids": ids},
	        			    success : function(data) {  
	        			    }  
	        			}); 
	        			window.location.reload();
	        	    }
	            });
	        });
	        $(".btnPassAll").on('click',function () {
	        	$.jq_Confirm({
	        		message:"您正在检阅多篇文章，是否通过？",
	        		btnOkClick:function(){
	        	    	let ids=[];
	        	    	$('.chks').each(function(index,element){
	        	    		let ckb=$(this);
	        	    		if(ckb.is(":checked")){
	        	    			ids[index]=ckb.parent().siblings().eq(0).html();
	        	    		}
	        	    	});
	        			$.ajax({  
	        			    type : 'POST',  
	        			    url:  'passArticleServlet',
	        			    contentType: "application/x-www-form-urlencoded",
	        			    data: {"ids": ids},
	        			    success : function(data) {  
	        			    }  
	        			}); 
	        			window.location.reload();
	        	    }
	        	});
	        });
	        $.chkAll();
	    });
</script>
</body>
</html>
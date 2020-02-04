      $(function() {
    	console.log("这是首页的js！！！！");
    	var $vars = $("#services .box h4 a");
    	$vars.hover(function(){
    		console.log("悬浮了！！！");
    	})
    	$vars.click(function(){
    		console.log("点击了！！！");
    	})
    	console.log($vars);
        function getUrlParam(name) {
          //构造一个含有目标参数的正则表达式对象  
          var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
          //匹配目标参数  
          var r = window.location.search.substr(1).match(reg);
          //返回参数值  
          if (r != null)
            return unescape(r[2]);
          return null;
        }
        function getQueryStringChinese(name) {
          var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
          var r = window.location.search.substr(1).match(reg);
          if (r != null)
            return decodeURI(r[2]);
          return null;
        }
        // 获取url参数name
        var id = getUrlParam("login-id");
  
        var name = getQueryStringChinese("login-name");
        console.log(name);

        // 如果name不为空，进行一系列操作
        if (name != null) {
            var position = getQueryStringChinese("position");

          $("#login1").remove();
          $("#login2").remove();
          $("#homepage").attr('href', ("index.html?login-name=" + name + "&login-id=" + id + "&position=" + position));
          $("#LAN").attr('href', ("LAN.html?login-name=" + name + "&login-id=" + id + "&position=" + position));
          $("#TI").attr('href', ("TI.html?login-name=" + name + "&login-id=" + id + "&position=" + position));
          $("#SJ").attr('href', ("SJ.html?login-name=" + name + "&login-id=" + id + "&position=" + position));
          $("#aboutus").attr('href', ("about.html?login-name=" + name + "&login-id=" + id +  "&position=" + position));
          $("#data_area").attr('href', ("dataArea.jsp?login-name=" + name + "&login-id=" + id + "&position=" + position ));
          $("#download_area").attr('href', ("download.html?login-name=" + name + "&login-id=" + id + "&position=" + position ));
          $("#write").attr('href', ("write-article.html?login-name=" + name + "&login-id=" + id+ "&position=" + position));
     		$('.nav-menu').append('<li class="menu-has-children" id="personal_center"><a href="#">个人中心</a>'
					+'<ul>'
					+'<li><a href="#" id="info">修改个人信息</a></li>'
					+'<li><a href="Login.html">切换账号</a></li>'
					+'<li><a href="index.html">退出</a></li>'
				+'</ul></li>');

        } else {
           $("#personal_center").css({
				"display" : "none"
			});
        }
        // 如果position为管理员，出现后台管理选项
        var position = getQueryStringChinese("position");
        if (position == "管理员") {
        	console.log("管理员登录");
			$('.nav-menu').append('<li><a href="indexManage.jsp?login-name=' +
					name + '&login-id=' +
					id + '&position=' +
					position +
					'">后台管理</a></li>');
			
			$('#home').attr('href', 'index.html?login-name=' +
				name + '&login-id=' +
				id + '&position=' +
				position)
        }
        var article_id = getUrlParam("article_id");
        if (article_id != null && name != null) {
        	$("#cancel").attr('href', ("readmore.html?login-name=" + name + "&login-id=" + id + "&article_id=" + article_id));
        } else if (article_id != null && name == null) {
        	$("#cancel").attr('href', ("readmore.html?article_id=" + article_id));
        } else if (article_id == null && name != null) {
        	$("#cancel").attr('href', ("dataArea.jsp?login-name=" + name + "&login-id=" + id));
        } else if (article_id == null && name == null) {
        	$("#cancel").attr('href', ("dataArea.jsp"));
        }
        $.ajax({
          type : "post",
          url : "GetInfo",
          dataType : "json",
          data : 'id=' + id,
          success : function(json) {
              console.log("test");

            var url = "info.html?name=" + name 
            + "&id=" + id
            + "&sex=" + json.sex
            + "&major=" + json.major
            + "&email=" + json.email
            + "&qq=" + json.qq
            + "&phone=" + json.phone
            + "&position=" + position;
            $("#info").attr('href', url);
          }
        });
  
      });
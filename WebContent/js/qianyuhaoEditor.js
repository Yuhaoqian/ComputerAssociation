const changeStyle = data => {
    data.value ? document.execCommand(data.command, false, data.value) : document.execCommand(data.command, false, null)
}
$('#link').click(function() {
	var str = $("#addlink").val();
	var sub = str.substring(0, 7);
	
	if ($("#addlink").val() != "") {
		if (sub != "http://") {
			$("#link").attr("data-value", "http://" + $("#addlink").val() + " ");
		} else {
			$("#link").attr("data-value", $("#addlink").val() + " ");
		}
		$("#addlink").val("");
		$("#text-area").focus();
		
		changeStyle(this.dataset);
	}

})
$('#submit').click(function(e) {
	
    var name = getQueryStringChinese("login-name");
    var un = getQueryStringChinese("login-id");
    var position = getQueryStringChinese("position");
	var title = $('#title').val();
	var type = $('#type').val();
	var content = $('#text-area').html();
	
	if (title.trim().length == 0) {
		alert('标题不能为空！');
	} else if(content.trim().length == 0) {
		alert('文章内容不能为空！');
	} else {
//		title = encodeURIComponent(title);
//		type = encodeURIComponent(type);
//		content = encodeURIComponent(content);

		$.ajax({
			type : "post",
			url : "WriteArticleServlet",
			dataType : "json",
			data :'title=' + title + '&type=' + type + '&content=' + content + '&poster=' + name,
			success : function(json) {
				alert(json.message);
				window.location.href = "./dataArea.jsp?login-name=" + name + "&login-id=" + un + "&position=" + position;
			}
		});
	}
	e.preventDefault();
});

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
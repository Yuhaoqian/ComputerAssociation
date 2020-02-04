$(function() {
	function delHtmlTag(str) {
		return str.replace(/<[^>]+>/g, "");
	}
	function getUrlParam(name) {
		// 构造一个含有目标参数的正则表达式对象  
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		// 匹配目标参数  
		var r = window.location.search.substr(1).match(reg);
		// 返回参数值  
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

	$('#write').click(function() {
		if (name != null) {
			window.location.href = $('#write').attr('href');
		} else {
			alert("您还没有注册/登录！");
		}

	});
	$('#comment').click(
			function() {
				if (name != null) {
					var art_id = getUrlParam("article-id");
					var id = getUrlParam("login-id");
					
					var comment_content = $('#comment-content').val();
					comment_content = encodeURIComponent(comment_content);
					console.log(comment_content);
					if (comment_content.trim().length == 0) {
						alert('评论内容不能为空！');
					} else {
						$.ajax({
							type : "post",
							url : "WriteCommentServlet",
							dataType : "json",
							data : 'content=' + comment_content + '&m_id=' + id
									+ '&art_id=' + art_id,
							success : function(json) {
								location.reload();
							}
						});
					}

				} else {
					alert("您还没有注册/登录！");
				}

			});
	console.log(window.location.pathname);
	console.log(window.location.search);
	// 进入资料页面，先得到总页数，把所有记录存放在json里，然后加载第1到5个记录
	var aJson;
	if (window.location.pathname == "/ComputerAssociation/dataArea.jsp") {
		$
				.ajax({
					type : "post",
					url : "ArticleServlet",
					dataType : "json",
					success : function(json) {
						aJson = json;
						console.log(json);
						console.log(json[0].totalPage);
						for (i = 1; i <= json[0].totalPage; i++) {

							$('.navi_links')
									.append(
											'<button class="links" >' + i
													+ '</button>')
						}
						$('.navi_links').children().eq(0).addClass("current");

						for ( var i in json) {
							if (i != 0 && i <= json[0].count) {
								var search = window.location.search; // url参数
								var content = json[i].content;
								content = delHtmlTag(content);// 去除html标签
								content = content.replace(/&nbsp;/ig, "");
								var str = '<li><div class="article"><div class="title"><h1>'
										+ json[i].title
										+ '</h1></div><div class="article_info">类别：<span style="color:black" id="category">'
										+ json[i].type
										+ '</span>&nbsp;&nbsp;作者：<span style="color:black" id="author">'
										+ json[i].poster
										+ '</span>&nbsp;&nbsp;'
										+ json[i].postTimeStr
										+ '</div><p>'
										+ content
										+ '</p><div><a href="readmore.html'
										+ search;
								if (name != null) {
									str += '&article-id=' + json[i].id
											+ '" class="readmore">'
											+ 'Read More</a></div></div></li>'
								} else {
									str += '?article-id=' + json[i].id
											+ '" class="readmore">'
											+ 'Read More</a></div></div></li>'
								}
								$('#article-ul').append(str);
							}

						}
					}
				});

	} else if (window.location.pathname == "/ComputerAssociation/readmore.html") {

		$.ajax({
			type : "post",
			url : "ArticleServlet",
			dataType : "json",
			success : function(json) {

				var id = getUrlParam("article-id");
				for ( var i in json) {
					if (json[i].id == id) {
						$('#title').html(json[i].title);
						$('#postTime').html(json[i].postTimeStr);
						$('#poster').html(json[i].poster);
						$('#content').html(json[i].content);
					}
				}
			}
		});
		var art_id = getUrlParam("article-id");
		console.log(art_id);
		$.ajax({
			type : "post",
			url : "CommentServlet",
			dataType : "json",
			data : 'article-id=' + art_id,
			success : function(data) {
				for ( var i in data) {
					$('#comment-ul').append(
							'<li><div class="cm-info">Name: <span>'
									+ data[i].m_name
									+ '</span><br> Date: <span>'
									+ data[i].createTime
									+ '</span></div><div class="cm-content">'
									+ data[i].content + '</div></li>');
				}
				console.log(data);
			}
		});
	}
	var bJson = new Array();
	var index=1;
	$("#category-ul").on("click", ".category", function() {
		$(this).addClass("catCurrent");
		$("#category-ul").addClass("clicked");
		$(this).parent().prevAll().children().removeClass("catCurrent");
		$(this).parent().nextAll().children().removeClass("catCurrent");
		console.log('hi');
		$('#article-ul').empty();
		var current_type = $(this).html();
		console.log(current_type);
		var total = 0; // 记录共有多少篇文章
		for(var i in aJson) {
			if(aJson[i].type == current_type) {
				total++;
				bJson[index++] = aJson[i];
				// 只画前count个
				if (total <=5) {
					var search = window.location.search;
					var content = aJson[i].content;
					content = delHtmlTag(content);// 去除html标签
					content = content.replace(/&nbsp;/ig, "");
					var str = '<li><div class="article"><div class="title"><h1>'
							+ aJson[i].title
							+ '</h1></div><div class="article_info">类别：<span style="color:black" id="category">'
							+ aJson[i].type
							+ '</span>&nbsp;&nbsp;作者：<span style="color:black" id="author">'
							+ aJson[i].poster
							+ '</span>&nbsp;&nbsp;'
							+ aJson[i].postTimeStr
							+ '</div><p>'
							+ content
							+ '</p><div><a href="readmore.html'
							+ search;
					if (name != null) {
						str += '&article-id=' + aJson[i].id
								+ '" class="readmore">'
								+ 'Read More</a></div></div></li>'
					} else {
						str += '?article-id=' + aJson[i].id
								+ '" class="readmore">'
								+ 'Read More</a></div></div></li>'
					}
					$('#article-ul').append(str);
				}

			}
		}
		// 然后更新分页导航栏
		// 获取参数
		var count = aJson[0].count;
		var totalPage;
		// 假设总数是50，是能够被5整除的，那么就有10页
		if (0 == total % count)
			totalPage = total / count;
			// 假设总数是51，不能被5整除的，那么就有11页
		else
			totalPage = parseInt(total / count) + 1;
		if (0 == totalPage)
			totalPage = 1;
		var json = {"count":count, "totalPage":totalPage};
		bJson[0] = json;
		// 正式开始更新
		$('.navi_links').empty();
		for (i = 1; i <= totalPage; i++) {

			$('.navi_links')
					.append(
							'<button class="links" >' + i
									+ '</button>')
		}
		
		$('.navi_links').children().eq(0).addClass("current");
		
		console.log(bJson);
		
	})
	$(".navi_links")
			.on(
					"click",
					".links",
					function() {

						if($("#category-ul").attr("class") != "clicked") {
							console.log(aJson);
							var totalPage = aJson[0].totalPage;
							var currentPage = $(this).html();
							var count = aJson[0].count;
							var start = (currentPage - 1) * count + 1;
							var end = start + count - 1;
							console.log(currentPage);
							$('#article-ul').empty();
							for (var i = start; aJson[i] != null && i <= end; i++) {

								var search = window.location.search;
								var content = aJson[i].content;
								content = delHtmlTag(content);// 去除html标签
								content = content.replace(/&nbsp;/ig, "");
								var str = '<li><div class="article"><div class="title"><h1>'
										+ aJson[i].title
										+ '</h1></div><div class="article_info">类别：<span style="color:black" id="category">'
										+ aJson[i].type
										+ '</span>&nbsp;&nbsp;作者：<span style="color:black" id="author">'
										+ aJson[i].poster
										+ '</span>&nbsp;&nbsp;'
										+ aJson[i].postTimeStr
										+ '</div><p>'
										+ content
										+ '</p><div><a href="readmore.html'
										+ search;
								if (name != null) {
									str += '&article-id=' + aJson[i].id
											+ '" class="readmore">'
											+ 'Read More</a></div></div></li>'
								} else {
									str += '?article-id=' + aJson[i].id
											+ '" class="readmore">'
											+ 'Read More</a></div></div></li>'
								}
								$('#article-ul').append(str);
							}
							$(this).prevAll().removeClass("current");
							$(this).nextAll().removeClass("current");
							$(this).addClass("current");
						} else {
							var totalPage = bJson[0].totalPage;
							var currentPage = $(this).html();
							var count = bJson[0].count;
							var start = (currentPage - 1) * count + 1;
							var end = start + count - 1;
							console.log(currentPage);
							$('#article-ul').empty();
							for (var i = start; bJson[i] != null && i <= end; i++) {

								var search = window.location.search;
								var content = bJson[i].content;
								content = delHtmlTag(content);// 去除html标签
								content = content.replace(/&nbsp;/ig, "");
								var str = '<li><div class="article"><div class="title"><h1>'
										+ bJson[i].title
										+ '</h1></div><div class="article_info">类别：<span style="color:black" id="category">'
										+ bJson[i].type
										+ '</span>&nbsp;&nbsp;作者：<span style="color:black" id="author">'
										+ bJson[i].poster
										+ '</span>&nbsp;&nbsp;'
										+ bJson[i].postTimeStr
										+ '</div><p>'
										+ content
										+ '</p><div><a href="readmore.html'
										+ search;
								if (name != null) {
									str += '&article-id=' + bJson[i].id
											+ '" class="readmore">'
											+ 'Read More</a></div></div></li>'
								} else {
									str += '?article-id=' + bJson[i].id
											+ '" class="readmore">'
											+ 'Read More</a></div></div></li>'
								}
								$('#article-ul').append(str);
							}
							$(this).prevAll().removeClass("current");
							$(this).nextAll().removeClass("current");
							$(this).addClass("current");
						}


					});
});
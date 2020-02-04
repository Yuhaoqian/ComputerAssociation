$(function() {
	/**
	 * 获取url参数
	 */
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
	var id = getUrlParam("id");
	var sex = getQueryStringChinese("sex");
	var major = getQueryStringChinese("major");
	var email = getQueryStringChinese("email");
	var phone = getQueryStringChinese("phone");
	var name = getQueryStringChinese("name");
	var qq = getUrlParam("qq");

	$("#name").val(name);
	$("#id").val(id);
	$("#email").val(email);
	$("#major").val(major);
	$("#qq").val(qq);

	$("#tel").val(phone);
	if (sex == "男")
		$("#gender").val("male");
	else
		$("#gender").val("female");


	
	/*************************************************/
	$('.profile-card-social__item').prop('disabled', 'true');
	$('.profile-card__overlay').css('height', $('body').outerHeight());

	function checkID(id) {
		let reg = /^[1-9][0-9]{11}$/;
		if (reg.test(id)) {
			return true;
		} else {
			return false;
		}
	}

	function checkName(name) {
		let reg = /^[\u4e00-\u9fa5]{2}[\u4e00-\u9fa5]{0,2}$/;
		if (reg.test(name)) {
			return true;
		} else {
			return false;
		}
	}

	function checkMajor(major) {
		let reg = /^[\u4e00-\u9fa5]{2,}$/;
		if (reg.test(major)) {
			return true;
		} else {
			return false;
		}
	}

	function checkEmail(mail) {
		let reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
		if (reg.test(mail)) {
			return true;
		} else {
			return false;
		}
	}

	function checkQQ(qq) {
		let reg = /^[1-9][0-9]{5,}$/;
		if (reg.test(qq)) {
			return true;
		} else {
			return false;
		}
	}

	function checkTel(tel) {
		let reg = /^[1-9][0-9]{10}$/;
		if (reg.test(tel)) {
			return true;
		} else {
			return false;
		}
	}

	$('#modify').on('click', function() {
		$('.profile-card__button').css('display', 'block');
		$(this).css('display', 'none');
		$('#return').css('display', 'none');
		$('.profile-card-social__item').removeAttr('disabled');
	});
	$('#return').on('click', function() {
        window.location.href="index.html?login-name=" + $("#name").val() + "&login-id=" + id + '&position=' + getQueryStringChinese("position");

	});
	$('#cancel').on('click', function() {
		$('.profile-card__button').css('display', 'none');
		$('#modify').css('display', 'block');
		$('#return').css('display', 'block');

		$('.profile-card-social__item').prop('disabled', 'true');
		// 恢复原样
		$("#name").val(name);
		$("#id").val(id);
		$("#email").val(email);
		$("#major").val(major);
		$("#qq").val(qq);

		$("#tel").val(phone);
		if (sex == "男")
			$("#gender").val("male");
		else
			$("#gender").val("female");

	});

	$('#submit').on(
			'click',
			function(e) {
				let name = $('#name').val();
				let id = $('#id').val();
				let mail = $('#email').val();
				let major = $('#major').val();
				let qq = $('#qq').val();
				let tel = $('#tel').val();
				console.log(checkName(name));
				console.log(checkID(id));
				console.log(checkEmail(mail));
				console.log(checkMajor(major));
				console.log(checkQQ(qq));
				console.log(checkTel(tel));
				if (checkName(name) && checkID(id) && checkEmail(mail)
						&& checkMajor(major) && checkQQ(qq) && checkTel(tel)) {
					console.log($("#name").val());
					var gender;
					if ($("#gender").val() == 'male') 
						gender = '男';
					else
						gender = '女';
					$.ajax({
						type : "post",
						url : "ModifyInfo",
						dataType : "json",
						data : "name=" + $("#name").val() 
							+ "&id=" + $("#id").val()
							+ "&sex=" + gender
							+ "&major=" + $("#major").val()
							+ "&email=" + $("#email").val()
							+ "&qq=" + $("#qq").val()
							+ "&phone=" + $("#tel").val(),
						success : function(json) {
							console.log(json.message);
							alert(json.message);
							$('.profile-card__button').css('display', 'none');
							$('#modify').css('display', 'block');
							$('#return').css('display', 'block');
							$('.profile-card-social__item').prop('disabled', 'true');
						}
					});
				} else {
					e.preventDefault();
					$('.js-profile-card').addClass('active');
					$('.profile-card__overlay').css('display', 'block');
					return false;
				}

			});

	$('#ok').on('click', function(e) {
		e.preventDefault();
		$('.js-profile-card').removeClass('active');
		$('.profile-card__overlay').css('display', 'none');
	});
});
$(function() {

	const container = document.getElementById('container');
	const registerForm = document.getElementById('register');

	$("#login-btn").click(function(e) {
		var un = $("#login-id").val();
		var pd = $("#login-pwd").val();
		if ($('#login-id').val().trim().length == 0) {
			$('#error_login').text("学号不能为空！");
		} else if ($('#login-pwd').val().trim().length == 0) {
			$('#error_login').text("密码不能为空！");
		} else if (!checkID('login-id')) {
			$('#error_login').text('学号格式错误，应该由12位组成哦');
		} else if (!checkPassword('login-pwd')) {
			$('#error_login').text('密码格式错误，应该由6-16位组成哦');
		} else if (checkID('login-id') && checkPassword('login-pwd')) {
			$.ajax({
				type : "post",
				url : "Login",
				dataType : "json",
				data : 'id=' + un + '&password=' + pd,
				success : function(json) {
					if(json.message == "登录成功！") {
						window.location.href = "./index.html?login-name=" + json.name + "&login-id=" + un + "&position=" + json.position;
					} else {
						$("#error_login").html(json.message);
					}
				}
			});
		}
		e.preventDefault();

	});
	$("#register-btn").click(function(e) {
		var un = $("#register-id").val();
//		console.log(un.trim().length);
		var name = $("#register-name").val();
		var pd = $("#psw1").val();
		if ($('#register-id').val().trim().length == 0) {
			$('#error_register').text("学号不能为空！");
		} else if ($('#register-name').val().trim().length == 0) {
			$('#error_register').text("姓名不能为空！");
		} else if (!checkName('register-name')) {
			$('#error_register').text("姓名只能是2-4位的中文！");
		} else if ($('#psw1').val().trim().length == 0) {
			$('#error_register').text("密码不能为空！");
		} else if ($('#psw1').val() != $('#psw2').val()) {
			$('#error_register').text("两次密码不一致！");
		} else if (!checkID('register-id')) {
			$('#error_register').text('学号格式错误，应该由12位组成哦');
		} else if (!checkPassword('psw1')) {
			$('#error_register').text('密码格式错误，应该由6-16位组成哦');
		} else if (checkID('register-id') && checkPassword('psw1')) {
			$.ajax({
				type : "post",
				url : "Register",
				dataType : "json",
				data : 'id=' + un + '&password=' + pd + '&name=' + name,
				success : function(json) {
					$("#error_register").html(json.message);
				}
			});
		}
		e.preventDefault();

	});
	$('#login-id').keyup(function() {
		$('#error_login').text("");
	});

	$('#login-pwd').keyup(function() {
		$('#error_login').text("");
	});

	// console.log($('#error_register').text());
	// console.log($('#error_register').text().length);

	// if ($('#error_register').text().length != 0) { //
	// 当有注册成功或失败的提示信息时，重定向时要赚到注册界面
	// container.classList.add("right-panel-active");
	// }
	$("#signIn").click(function() { // 登录按钮点击事件
		$('#error_register').text("");
		container.classList.remove("right-panel-active");

	});
	$('#signUp').click(function() { // 注册按钮点击事件
		$('#error_login').text("");

		container.classList.add("right-panel-active");
	});
	function checkID(id) {
		let reg = /^[1-9][0-9]{11}$/;
		let idContent = document.getElementById(id).value;
		if (reg.test(idContent)) {
			return true;
		} else {
			return false;
		}
	}

	function checkName(name) {
		let reg = /^[\u4e00-\u9fa5]{2}[\u4e00-\u9fa5]{0,2}$/;
		let nameContent = document.getElementById(name).value;
		if (reg.test(nameContent)) {
			return true;
		} else {

			return false;
		}
	}

	function checkPassword(password) {
		let reg = /^[\w_-]{6,16}$/;;
		let idContent = document.getElementById(password).value;
		if (reg.test(idContent)) {
			return true;
		} else {
			return false;
		}
	}
});

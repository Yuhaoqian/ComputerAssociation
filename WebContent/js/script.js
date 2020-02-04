window.onload = function () {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');
    const loginForm = document.getElementById('login');
    const registerForm = document.getElementById('register');

    signUpButton.addEventListener('click', () => {
        clearTimeout(loginForm.timeID);
        let tip = document.getElementById('tip');
        if (tip){
            loginForm.removeChild(tip);
        }
        container.classList.add("right-panel-active");
    });

    signInButton.addEventListener('click', () => {
        clearTimeout(registerForm.timeID);
        let tip = document.getElementById('tip');
        if (tip){
            registerForm.removeChild(tip);
        }
        container.classList.remove("right-panel-active");
    });

    function checkID(id){
        let reg = /^[1-9][0-9]{11}$/;
        let idContent = document.getElementById(id).value;
        if (reg.test(idContent)){
            return true;
        }else{
            return false;
        }
    }

    function checkName(name){
        let reg = /^[\u4e00-\u9fa5]{2}[\u4e00-\u9fa5]{0,2}$/;
        let nameContent = document.getElementById(name).value;
        if (reg.test(nameContent)){
            return true;
        }else{
            return false;
        }
    }

    function checkPassword(password){
        let reg = /^[1-9][0-9]{11}$/;
        let idContent = document.getElementById(id).value;
        if (reg.test(idContent)){
            return true;
        }else{
            return false;
        }
    }

    function insert(element, before, parent){
        element.id = 'tip';
        element.style.color = '#fff';
        parent.insertBefore(element, before);
        parent.timeID = setTimeout(() => {
            parent.removeChild(element);
        },5000);
    }

    loginForm.addEventListener('submit', function (e) {
        let tt = document.getElementById('tip');
        if (checkID('login-id')) {
            clearTimeout(this.timeID);
            if (tt){
                this.removeChild(tt);
            }
            $('#login-id').attr('name', 'id');
            $('#login-pwd').attr('name', 'password');
            return true;
        }else {
            if (!tt){
                let tip = document.createElement('p');
                let tipContent = document.createTextNode('学号或密码错误，请核实您的用户信息');
                tip.appendChild(tipContent);
                insert(tip, document.getElementById('login-btn'), this);
            }
            e.preventDefault();
//            return false;
        }
    });

    registerForm.addEventListener('submit',function () {
        let tt = document.getElementById('tip');
        if (checkID('register-id') && checkName('register-name')) {
            clearTimeout(this.timeID);
            if (tt){
                this.removeChild(tt);
            }
            return true;
        }else {
            if (!tt){
                let tip = document.createElement('p');
                let tipContent = document.createTextNode('学号一定得写对哦，而且密码只能由数字和字母组成');
                tip.appendChild(tipContent);
                insert(tip, document.getElementById('register-btn'), this);
            }
            return false;
        }
    });
};
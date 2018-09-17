<template>
  <div class="pen-title">
<div class="container">
    <div class="error_msg">
        <span v-if="hasError">{{ error_msg }}</span>
    </div>
    <div class="card">
        <h1 class="title">Вход</h1>
        <form @submit.prevent="login" name="login" action="/login">
            <div class="input-container">
                <input v-model="log_username" name="username" type="text" id="log_username" required="required"/>
                <label for="log_username">Имя пользователя</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input v-model="log_password" name="password" type="password" id="log_password" required="required"/>
                <label for="log_password">Пароль</label>
                <div class="bar"></div>
            </div>
            <div class="button-container">
                <button type="submit"><span>Войти</span></button>
            </div>
        </form>
    </div>
    <div class="card alt">
        <div class="toggle"></div>
        <h1 class="title">Регистрация
            <div class="close"></div>
        </h1>
        <form @submit.prevent="register" name="register">
            <div class="input-container">
                <input v-model="reg_username" name="username" type="text" id="reg_username" required="required"/>
                <label for="reg_username">Имя пользователя</label>
                <div class="bar"></div>
            </div>
             <div class="input-container">
                <input v-model="reg_email" name="email" type="text" id="reg_email" required="required"/>
                <label for="reg_email">E-mail</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input v-model="reg_name" name="name" type="text" id="reg_name" required="required"/>
                <label for="reg_name">Name</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input v-model="reg_password" name="password" type="password" id="reg_password" required="required"/>
                <label for="reg_password">Пароль</label>
                <div class="bar"></div>
            </div>
            <div class="input-container">
                <input v-model="reg_confirmPassword" name="confirmPassword" type="password" id="reg_confPassword" required="required"/>
                <label for="reg_confPassword">Подтвердите пароль</label>
                <div class="bar"></div>
            </div>
            <div class="button-container">
                <button type="submit"><span>Зарегистрироваться</span></button>
            </div>
        </form>
    </div>
</div>
</div>
</template>

<script>

  export default {
    name: 'home',
    data() {
      return {
        updateInterval: 20,
        log_username: '',
        log_password: '',
        reg_username: '',
        reg_password: '',
        reg_confirmPassword: '',
        reg_email: '',
        reg_name: '',
        error_msg: '',
        hasError: false,
      }
    },
    mounted() {
    let loginScript = document.createElement('script')
    loginScript.setAttribute('src', './../../static/js/login_js.js');
    document.head.appendChild(loginScript)
  },
    methods: {
      login() {
         let params = {
          username: this.log_username,
          password: this.log_password,
         };

         this.$http.post('http://localhost:8080/login', params)
          .then(function (response) {
            localStorage.setItem('token', response.headers.get('Authorization'));
            localStorage.setItem('username', response.headers.get('Username'));
            this.$router.replace('/');
          }, response => {
            this.hasError = true;
            this.error_msg = 'Invalid username or password';
          });
      },
      register() {
        this.hasError = false;
        if (this.reg_password != this.reg_confirmPassword) {
            this.error_msg = 'Password doesn`t match';
            this.hasError = true;
            return;
        }
        if (!this.validateEmail(this.reg_email)) {
            this.error_msg = 'Enter correct e-mail';
            this.hasError = true;
            return;
        }

        let params = {
          username: this.reg_username,
          password: this.reg_password,
          email: this.reg_email,
          name: this.reg_name
         };


         this.$http.post('http://localhost:8080/users/sign-up', params)
          .then(function (response) {
            console.log(response);
            this.$router.replace('/');
          });
      },
      validateEmail(email) {
        let re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
      }
    },
    created() {
        //if (localStorage.getItem('token') != '') {
        //    this.$router.replace('/');
        //    return;
        //} 
        localStorage.setItem('token', '');
        localStorage.setItem('username', '');
    }
  }
</script>

<style scoped>
@import url('./../../static/css/animate.css');
@import url('./../../static/css/login_style.css');

.error_msg {
    color: red;
    font-size: 1.5em;
    margin-top: -10px;
}
</style>

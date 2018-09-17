<template>
  <section id="addPublicSection" class="home-section text-center">
    <div class="container">

    <div class="row">
        <div class="col-lg-12">
            <div class="addPublic">
                      <div class="header_inputs">
                           <h3>Profile data</h3>
                      </div>
                       <div class="container">
                           <div class="row">
                               <div class="col-md-12">
                                   <table class="table">
                                       <thead>
                                       <tr>
                                           <th scope="col">Field</th>
                                           <th scope="col">Value</th>
                                       </tr>
                                       </thead>
                                       <tbody>
                                       <tr>
                                           <td>Username</td>
                                           <td>{{username}}</td>
                                       </tr>
                                       <tr>
                                           <td>Name</td>
                                           <td>{{name}}</td>
                                       </tr>
                                       <tr>
                                           <td>E-mail</td>
                                           <td>{{email}}</td>
                                       </tr>
                                       </tbody>
                                   </table>
                            </div>
                        </div>
                       </div>
                </div>
            </div>

    </div>
  </div>
  </section>
</template>

<script>
import Vue from 'vue';

  export default {
    name: 'home',
    data() {
      return {
        username: '',
        name: '',
        email: '',
      }
    },
    methods: {
      fetchData() {
        Vue.http.headers.common['Authorization'] = localStorage.getItem('token');
        let apiUrl = 'http://localhost:8080/api/getUserInfo?username=' + localStorage.getItem('username');
        
        this.$http.get(apiUrl)
          .then(function (response) {
            this.username = response.data.username;
            this.name = response.data.name;
            this.email = response.data.email;
          });
      },
    },
    created() {
      if (localStorage.getItem('token') == '') {
        this.$router.replace('/login')
      } else {
        this.fetchData();
      }
    }
  }
</script>

<style scoped>
@import url('./../../static/css/style.css');
@import url('./../../static/css/default.css');
@import url('https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css');
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css');

 td {
      text-align: center;
    }

  #addPublicSection {
      height: 100vh;
  }
</style>

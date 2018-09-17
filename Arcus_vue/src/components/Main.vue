<template>
  <div>
    <section id="addPublicSection" class="home-section text-center">
    <div class="heading-contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <div class="section-heading">
                        <h3>
                            <router-link to="/profile">PROFILE</router-link>
                        </h3>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>
  </div>
</template>

<script>
  export default {
    name: 'home',
    data() {
      return {
       
      }
    },
    methods: {
     
    },
    created() {
       if (localStorage.getItem('token') == '') {
        this.$router.replace('/login')
      } 
    }
  }
</script>

<style scoped>
@import url('./../../static/css/style.css');
@import url('./../../static/css/default.css');

 #addPublicSection {
        height: 100vh;
    }
    a {
        margin-left: 20%;
    }
    .section-heading {
        margin-top: 30vh;
    }
</style>

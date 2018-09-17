<template>
    <router-view></router-view>
</template>

<script>
import Profile from './components/Profile'
import Main from './components/Main.vue'
import Login from './components/Login.vue'
import TableComponent from './components/TableComponent.vue'

export default {
  name: 'app',
  components: {
    Main, Profile, Login, TableComponent
  }
}
</script>

<style>
</style>

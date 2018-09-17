// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import Profile from './components/Profile.vue'
import Main from './components/Main.vue'
import Login from './components/Login.vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
Vue.use(VueResource)

Vue.config.productionTip = false

const router = new VueRouter({
	mode: 'history',
	routes: [
		{path: '/profile', component: Profile },
		{path: '/', component: Main},
		{path: '/login', component: Login},
	]
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})

<template>
<div class="hello">
<TableComponent/>
</div>
</template>

<script>
import TableComponent from './TableComponent.vue'

export default {
  name: 'Profile',
  components: {TableComponent },
  data () {
    return {
      loading: false,
    }
  },
  methods: {
    
  },
  created() {
     if (localStorage.getItem('token') == '') {
        this.$router.replace('/login')
      } 
  },
}
</script>
<style scoped>

</style>

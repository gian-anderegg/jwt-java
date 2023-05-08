<template>
  <div class="mt-3">
<!--    Todo Not worki -->
    <div v-if="users">
      <h3>Helo {{ user.name }}</h3>
      <router-link class="nav-link" :to="{name:'Blogs'}">Deeez Blogs</router-link>
    </div>
    <div v-if="!user">
      <h3>You are not logged in! </h3>
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import axios from "axios";

export default {
  name: "Home",
  data() {
    return {
      users: []
    }
  },
  async created() {
    if (localStorage.getItem('token')) {
      console.log("token is here wooooo")
    }
      await axios.get('user', {
        headers: {
          Authorization: 'Bearer ' + localStorage.getItem('token')
        }
      }).then(res => {
        this.users = res
      }).catch(error => {
        console.log(error)
      });
  },
  computed: {
    ...mapGetters(['user'])
  }
}
</script>

<style scoped>

</style>
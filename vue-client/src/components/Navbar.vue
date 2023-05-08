<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
      <router-link class="navbar-brand" :to="{name:'Home'}">Home</router-link>

        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
          <template>
            <li class="nav-item">
              <a class="nav-link" href="" @click.prevent="logout">Logout</a>
            </li>
          </template>
          <template>
            <li class="nav-item">
              <router-link class="nav-link" :to="{name:'Login'}">Login</router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" :to="{name:'Register'}">Register</router-link>
            </li>
          </template>
        </ul>
      </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  methods: {
    logout() {
      localStorage.removeItem('token')
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>
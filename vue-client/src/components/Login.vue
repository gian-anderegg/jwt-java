<template>
  <div class="form-signin">
    <div class="card">
      <div class="card-body">
        <form @submit.prevent="login">
          <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" v-model="form.username">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" v-model="form.password">
          </div>
          <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Login",
  data() {
    return {
      form: this.initForm()
    }
  },

  methods: {
    login() {
      axios.post('auth/login', this.form).then((response) => {
        console.log(response)
        localStorage.setItem('token', response.data.accessToken)
        this.$store.dispatch('user', response.data)
        //if user = admin -> push to /admin
        this.$router.push('/')
      }).catch(error => {
        console.log(error)
      })
    },

    initForm() {
      return {
        username: null,
        password: null
      }
    }
  }
}
</script>

<style scoped>

</style>
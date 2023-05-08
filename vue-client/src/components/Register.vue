<template>
  <div class="form-signin">
    <div class="card">
      <div class="card-body">
        <form @submit.prevent="register">
          <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" class="form-control" id="username" v-model="form.username">
          </div>
          <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" v-model="form.email">
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" v-model="form.password">
          </div>
          <button type="submit" class="btn btn-primary w-100">Register</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "Register",
  data() {
    return {
      form: this.initForm()
    }
  },
  methods: {
    register() {
      axios.post('auth/sign-up', this.form).then(() => {
        this.form = this.initForm()
        this.$router.push('/login')
      }).catch(error => {
        console.log(error)
      })
    },

    initForm() {
      return {
        username: null,
        email: null,
        password: null,
      }
    }
  }
}
</script>

<style scoped>

</style>
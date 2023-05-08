<template>
  <div>
    <h1>Admin View</h1>
    <table>
      <thead>
      <tr>
        <td>email</td>
        <td>name</td>
        <td>role</td>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user in users" :key="user.id">
        <td>{{ user.email }}</td>
        <td>{{ user.username }}</td>
        <td>{{ user.roles[0].name }}</td>
        <td>
          <!-- TODO Make role selection  work -->
          <select name="Role" id="role" @change="setRole(user.id)" v-model="newRole">
            <option :selected="user.roles[0].name === 'ROLE_ADMIN'" value="ROLE_ADMIN">Admin</option>
            <option :selected="user.roles[0].name === 'ROLE_USER'" value="ROLE_USER">User</option>
            <option :selected="user.roles[0].name === 'ROLE_MODERATOR'" value="ROLE_MODERATOR">Moderator</option>
          </select>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "Admin",
  data: () => {
    return {
      users: [],
      newRole: '',
    };
  },
  async created() {
    await this.getUsers()
  },
  methods: {
    async setRole(userId){
      await axios.put('/user/role/' + userId +'/ROLE_ADMIN').then(res => {
        console.log(res)
      }).catch(error => {
        console.log(error)
      });
      await this.getUsers()
    },
    async getUsers() {
      await axios.get('user').then(res => {
        this.users = res
      }).catch(error => {
        console.log(error)
      });
    }
  },
}
</script>

<style scoped>

</style>
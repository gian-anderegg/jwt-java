import Vue from 'vue'
import router from 'vue-router'
import Login from "@/components/Login";
import Home from "@/components/Home";
import Register from "@/components/Register";
import Blogs from "@/components/Blogs";
import Admin from "@/components/Admin";

Vue.use(router)

export default new router({
    mode: 'history',
    routes: [
        {
            path: '',
            name: 'Home',
            component: Home
        },
        {
            path: '/login',
            name: 'Login',
            component: Login
        },
        {
            path: '/register',
            name: 'Register',
            component: Register
        },
        {
            path: '/blogs',
            name: 'Blogs',
            component: Blogs
        },
        {
            path: '/admin',
            name: 'Admin',
            component: Admin
        }
    ]
})
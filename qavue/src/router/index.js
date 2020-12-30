import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import register from '../views/register'
import teacher from '../views/teacher'
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'register',
        component: register
    },
    {
        path: '/teacher',
        name: 'teacher',
        component: teacher
    }

]

const router = new VueRouter({
    routes
})

export default router

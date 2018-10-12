import Vue from 'vue'
import Router from 'vue-router'
import Dashboard from '@/components/dashboard'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'dashboard',
      component: Dashboard
    }
  ]
})

// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'

import moment from 'moment'
import axios from 'axios'
import curvejs from 'curvejs'

Vue.config.productionTip = false

Object.defineProperty(Vue.prototype, '$moment', {value: moment})
Object.defineProperty(Vue.prototype, '$axios', {value: axios})
Object.defineProperty(Vue.prototype, '$curvejs', {value: curvejs})

Vue.use(ElementUI)
locale.use(lang)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})

import Vue from "vue";
import Vuex from "vuex";
import App from "./app/App.vue";
import "./plugins/element.js";
import axios from "axios";

Vue.config.productionTip = false;

Vue.prototype.$http = axios;

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    message: "VueJS"
  },
  getters: {
    message(state) {
      return state.message;
    }
  },
  mutations: {
    changeMessage(state, payload) {
      state.message = payload;
    }
  },
  actions: {
    changeMessageAction(state, payload) {
      state.commit("changeMessage", payload);
    }
  }
});

new Vue({
  render: h => h(App),
  store
}).$mount("#app");

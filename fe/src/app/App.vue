<template>
  <div id="app">
    <img alt="Vue logo" src="/assets/logo.png" />
    <hello-world msg="Welcome to Your from Vue.js App!!!" />
    <button @click="upByFive">Up by 5</button>
    <span>{{ counter }}</span>
    <hello-again
      name="Antonel-Ernest Pazargic"
      v-bind:counterFromParent="counter"
    >
    </hello-again>
  </div>
</template>

<script>
import HelloWorld from "../components/HelloWorld.vue";
import HelloAgain from "../components/HelloAgain.vue";

export default {
  name: "app",
  components: {
    HelloWorld,
    HelloAgain
  },
  data() {
    return {
      counter: 0
    };
  },
  methods: {
    upByFive: function() {
      this.counter += 5;
    }
  }
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 10px;
}
button {
  display: inline-block;
  color: black;
  background: burlywood;
  border-radius: 5px;
  margin-top: 10px;
  border: none;
  cursor: pointer;
  padding: 5px;
}
span {
  display: block;
  margin-top: 10px;
}
</style>

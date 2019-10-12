<template>
  <div>
    <div>Hello for again mr. {{name}} from Vue world!!!</div>
    <div>Message from store is {{message}}!!!</div>
    <div>Your age is {{age}}</div>
    <div>Your age incremented by parent {{age + counterFromParent}}</div>
    <button v-on:click="incrementUp">Increment your age;)</button>
  </div>
</template>

<script>
export default {
  name: "HelloAgain",
  props: {
    name: String,
    counterFromParent: Number
  },
  data() {
    return {
      age: 0
    };
  },
  methods: {
    incrementUp: function() {
      this.age++;
    }
  },
  computed: {
    message() {
      return this.$store.state.message;
    }
  }
};
</script>

<style scoped>
div {
  font-size: 16px;
  font-weight: bold;
  text-align: center;
  color: tomato;
  margin-top: 10px;
}
button {
  display: inline-block;
  color: whitesmoke;
  background: tomato;
  border-radius: 5px;
  margin-top: 10px;
  border: none;
  cursor: pointer;
  padding: 5px;
}
</style>

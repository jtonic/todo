<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>
      <el-dialog
        title="Important question"
        :visible.sync="dialogVisible"
        width="40%"
        :before-close="handleClose"
      >
        <span>Do you want to get married?</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="cancel">Cancel</el-button>
          <el-button type="primary" @click="confirm"
            >Confirm</el-button
          >
        </span>
      </el-dialog>
      <el-tooltip content="An important question for you" placement="bottom" effect="light">
        <el-button type="primary" plain @click="openAlert">Question</el-button>
      </el-tooltip>
    </div>

    <el-row :gutter="6">
      <el-col span="24"><div class="grid-content bg-purple-dark">Installed CLI Plugin</div></el-col>
      <el-col :span="12"><div class="grid-content bg-purple-dark">Kkmk1</div></el-col>
      <el-col :span="12"><div class="grid-content bg-purple-dark">Kkmk2</div></el-col>
    </el-row>

    <p>
      For a guide and recipes on how to configure / customize this project,
      <br />check out the
      <a href="https://cli.vuejs.org" target="_blank" rel="noopener"
        >vue-cli documentation</a
      >.
    </p>
    <h3>Installed CLI Plugins</h3>
    <ul>
      <li>
        <a
          href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-babel"
          target="_blank"
          rel="noopener"
          >babel</a
        >
      </li>
      <li>
        <a
          href="https://github.com/vuejs/vue-cli/tree/dev/packages/%40vue/cli-plugin-eslint"
          target="_blank"
          rel="noopener"
          >eslint</a
        >
      </li>
    </ul>
    <h3>Essential Links</h3>
    <ul>
      <li>
        <a href="https://vuejs.org" target="_blank" rel="noopener">Core Docs</a>
      </li>
      <li>
        <a href="https://forum.vuejs.org" target="_blank" rel="noopener"
          >Forum</a
        >
      </li>
      <li>
        <a href="https://chat.vuejs.org" target="_blank" rel="noopener"
          >Community Chat</a
        >
      </li>
      <li>
        <a href="https://twitter.com/vuejs" target="_blank" rel="noopener"
          >Twitter</a
        >
      </li>
      <li>
        <a href="https://news.vuejs.org" target="_blank" rel="noopener">News</a>
      </li>
    </ul>
    <h3>Ecosystem</h3>
    <ul>
      <li>
        <a href="https://router.vuejs.org" target="_blank" rel="noopener"
          >vue-router</a
        >
      </li>
      <li>
        <a href="https://vuex.vuejs.org" target="_blank" rel="noopener">vuex</a>
      </li>
      <li>
        <a
          href="https://github.com/vuejs/vue-devtools#vue-devtools"
          target="_blank"
          rel="noopener"
          >vue-devtools</a
        >
      </li>
      <li>
        <a href="https://vue-loader.vuejs.org" target="_blank" rel="noopener"
          >vue-loader</a
        >
      </li>
      <li>
        <a
          href="https://github.com/vuejs/awesome-vue"
          target="_blank"
          rel="noopener"
          >awesome-vue</a
        >
      </li>
      <li>
        <a
          href="https://vuejsexamples.com"
          target="_blank"
          rel="noopener noreferrer"
          >VueJS examples</a
        >
      </li>
      <li>
        <a
          href="https://vuetifyjs.com/en/getting-started/quick-start"
          target="_blank"
          rel="noopener noreferrer"
          >Vuetify</a
        >
      </li>
      <li>
        <a
          href="https://element.eleme.io/#/en-US/component/installation"
          target="_blank"
          rel="noopener noreferrer"
          >Element-UI</a
        >
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  props: {
    msg: String
  },
  data() {
    return {
      dialogVisible: false
    };
  },
  methods: {
    openAlert() {
      this.dialogVisible = true;
    },
    handleClose() {
      this.cancel();
    },
    cancel() {
      console.log("Are you sure you don't want to ruin your life");
      this.dialogVisible = false;
    },
    confirm() {
      console.log("You made a good decision");
      this.dialogVisible = false;
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.el-row {
  margin-bottom: 20px;
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
</style>

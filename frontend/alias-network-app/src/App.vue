<template>
  <div id="app">
    <ContactsList ref="contactsList"/>
  </div>
</template>

<script>
import ContactsList from "@/components/ContactsList.vue";
export default {
  name: 'App',
  components: {
    ContactsList,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

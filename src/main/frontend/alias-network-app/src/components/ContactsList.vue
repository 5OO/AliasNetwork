

<template>
  <div>
    <h1>Contacts</h1>
    <ul>
      <li v-for="contact in contacts" :key="contact.id">
        {{contact.id}} {{ contact.firstName }} {{ contact.lastName }} - {{ contact.codeName }}
      </li>
    </ul>
  </div>
</template>
<script>

import axios from 'axios';
export default {
  name: 'ContactsList',
  data() {
    return {
      contacts: []
    };
  },
  mounted() {

    axios.get('http://localhost:8080/api/contacts')
        .then(response => {
          this.contacts = response.data;
        })
        .catch(error => {
          console.error('There was an error fetching the contacts:', error);
        })
  },
}
</script>

<style scoped>

</style>
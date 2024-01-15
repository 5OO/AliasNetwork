<template>
  <div>
    <!-- Search Form -->
    <h1>Search contacts</h1>
    <div>
      <input type="text" v-model="searchQuery" placeholder="Search by Code Name">
      <button @click="searchContacts">Search</button>
      <button @click="resetSearch">Reset</button>
    </div>
    <h1>Available contacts</h1>
    <ul>
      <li v-for="contact in contacts" :key="contact.id">
        {{contact.id}}. {{ contact.firstName }} {{ contact.lastName }}  ► {{ contact.codeName }} ☎ {{contact.phoneNumber}}
      </li>
    </ul>
    <AddContactForm @contactAdded="handleContactAdded" />
  </div>
  </template>

<script>
import axios from 'axios';
import AddContactForm from "@/components/AddContactForm.vue";

export default {
  name: 'ContactsList',
  components: {
    AddContactForm
  },
  data() {
    return {
      contacts: [],
      searchQuery: '' // Search input
    };
  },
  methods: {
    handleContactAdded(newContact) {
      this.contacts.push(newContact); // Add the new contact to the local contacts array
    },
    fetchContacts() {
      axios.get('http://localhost:8080/api/contacts')
          .then(response => {
            this.contacts = response.data;
          })
          .catch(error => {
            console.error('There was an error fetching the contacts:', error);
          });
    },
    searchContacts() {
      axios.get(`http://localhost:8080/api/contacts/search/${this.searchQuery}`)
          .then(response => {
            this.contacts = response.data;
          })
          .catch(error => {
            console.error('There was an error fetching the contacts:', error);
          });
    },
    resetSearch() {
      this.searchQuery = '';
      this.fetchContacts();
    }
  },
  mounted() {
    this.fetchContacts(); // Fetch contacts when component mounts
  }
};
</script>

<style scoped>
body {
  font-family: 'Arial', sans-serif;
  margin: 0;
  padding: 0;
  background-color: #f4f4f4;
  color: #333;
}

header {
  background-color: #fff;
  padding: 1rem;
  text-align: center;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

ul {
  list-style: none;
  padding: 0;
}

li {
  background-color:#fff;
  margin: 0.5rem;
  padding: 1rem;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  background-color: #008CBA; /* Blue */
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
}

button:hover {
  background-color: #005f73;
}

input, select, textarea {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
</style>
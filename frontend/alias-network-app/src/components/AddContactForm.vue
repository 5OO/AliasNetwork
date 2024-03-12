<template>
  <div class="add-contact-form">
    <h1>Add new contact:</h1>
    <form @submit.prevent="addContact">
      <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" id="firstName" v-model="contact.firstName" required>
      </div>
      <div class="form-group">
        <label for="lastName">Last Name</label>
        <input type="text" id="lastName" v-model="contact.lastName" required>
      </div>
      <div class="form-group">
        <label for="codeName">Code Name</label>
        <input type="text" id="codeName" v-model="contact.codeName" class="form-control" required>
      </div>
      <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <input type="tel" id="phoneNumber" v-model="contact.phoneNumber" class="form-control" required>
      </div>

      <button type="submit">Add Contact</button>
    </form>
  </div>
</template>

<script >
import axios from "axios";

export default {
  data() {
    return {
      contact: {
        firstName: '',
        lastName: '',
        codeName: '',
        phoneNumber: ''
      }
    };
  },
  methods: {
    addContact() {
      axios.post('http://localhost:8080/api/contacts', this.contact)
          .then(response => {
            // Handle the response, e.g., list added contact, clear form
            this.$emit('contactAdded', response.data);
            this.contact = { firstName: '', lastName: '' , codeName: '', phoneNumber: ''}; // Reset form
          })
          .catch(error => {
            // Handle errors - > show error message
            console.error('There was an error adding the contact:', error);
          });
    }
  }
};
</script>
<style scoped>

.form-group {
  margin-bottom: 1rem;
}

</style>
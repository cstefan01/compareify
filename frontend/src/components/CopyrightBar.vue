<template>
  <div class="container-fluid footer p-0">
    <div class="copyright col-12">
      <span
        >Copyright &copy; {{ copyright_year }} All rights reserved by
        <a :href="copyright_author_link">{{ copyright_author_name }}</a></span
      >
    </div>
  </div>
</template>

<script>
export default {
  name: "CopyrightBar",
  props: {
    copyright_year: String,
    copyright_author_name: String,
    copyright_author_link: String,
  },
};
</script>

<style scoped>
.copyright {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 50px;
  background: var(--ion-color-primary-shade);
  color: var(--ion-color-primary-contrast);
}

a {
  text-decoration: none;
  color: var(--ion-color-secondary);
}
</style>

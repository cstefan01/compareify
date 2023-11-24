<template>
    <div class="page">
      <NavigationBar site_name="compareify" />
      <MainHero />
  
      <MainContent />
  
     <ToastMessage 
        title = "No product to be shown"
        message = "Search for a product now"
     />
  
      <MainFooter
        copyright_year="2023"
        copyright_author_name="Claudiu Stefan"
        copyright_author_link="https://github.com/cstefan01"
      />
    </div>
  </template>
  
  <script>
  
  import ToastMessage from '../components/ToastMessage.vue'
  import NavigationBar from "../components/NavigationBar.vue";
  import MainHero from "../components/MainHero.vue";
  import MainFooter from "../components/MainFooter.vue";
  import MainContent from "../components/MainContent.vue";
  
  export default {
    name: "LandingPage",
    components: {
      NavigationBar,
      MainHero,
      MainFooter,
      MainContent,
      ToastMessage
    },
  };
  </script>
  
  <style>
  .page {
    display: flex;
    flex-direction: column;
    /* background: var(--ion-color-primary); */
  }
  </style>
  
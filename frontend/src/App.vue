<template>
  <div>
    <NavigationBar 
      site_name="compareify" 
    />
    <MainHero />
  </div>
</template>

<script>
import NavigationBar from './components/NavigationBar.vue';
import MainHero from './components/MainHero.vue';

export default {
  name: 'App',
  components: {
    NavigationBar,
    MainHero,
    
  }
}
</script>

<style>
body{
  height: 9000px;
}


</style>

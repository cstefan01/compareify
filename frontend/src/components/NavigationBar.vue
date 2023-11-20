<template>
    <div class="navigation-bar container-fluid p-0">
        <div class="site-name h-100 col-2 d-flex align-items-center justify-content-end float-start ">
            <h1 class="text-capitalize" v-text="site_name"></h1>
        </div>

        <div class="navs h-100 col-1 d-flex align-items-center justify-content-center float-end ">
            <router-link to="/">about us</router-link>
            <router-view></router-view>
        </div>

    </div>
  
</template>

<script>
export default {
    name: "NavigationBar",
    props:{
        site_name: String,
    }

}
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Pacifico&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500&display=swap');
.navigation-bar{
    background: var(--ion-color-primary);
    height: 50px;
}
.navigation-bar .site-name h1{
    font-family: 'Pacifico', cursive;
    color: var(--ion-color-secondary);
    font-size: 1.8em;
    letter-spacing: .25em;
}

router-link{
    color: var(--ion-color-secondary-tint);
    text-decoration: underline;
    font-family: 'Ubuntu', sans-serif;
}


</style>
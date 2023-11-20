<template>
    <div class="navigation-bar container-fluid d-flex">
        <div class="site-name h-100 col-6 d-flex justify-content-start align-items-center ">
            <h1 class="text-capitalize" v-text="site_name"></h1>
        </div>

        <div class="navs h-100 col-6 d-flex justify-content-end align-items-center">
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
    padding: 0px 50px 0px 50px;
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
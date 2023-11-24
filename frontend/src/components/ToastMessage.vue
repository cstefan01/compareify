<template>
    <div class="toast-message col-4">

        <EarthBoyIllustration />
        <h4 v-text="title"></h4>
        <h5 v-text="message"></h5>
    </div>

    
</template>

<script>
import EarthBoyIllustration from './illustrations/EarthBoyIllustration.vue';


export default {
    name: "ToastMessage",
    components:{
        EarthBoyIllustration 
    },
    props:{
        title: String,
        message: String


    }
}

</script>

<style scoped>

.toast-message{
    display: flex;
    min-height: 450px;
    background: #fff;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.toast-message h4{
    font-family: 'Kanit', sans-serif;
    font-size: 2em;
    margin-bottom: 15px;
}

.toast-message h5{
    font-family: 'Kanit', sans-serif;
    font-family: 'Montserrat', sans-serif;
    color: rgb(117, 117, 117);
    font-size: 1.5em;
}

</style>
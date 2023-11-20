<template>
     <div class="half-circle-illustration">
        <svg width="69" height="130" viewBox="0 0 69 220" fill="none" xmlns="http://www.w3.org/2000/svg">
            <ellipse cx="-63.5" cy="110" rx="132.5" ry="110" :fill="outer_color" fill-opacity="0.53"/>
            <ellipse cx="-51.5" cy="109" rx="72.5" ry="61" :fill="inner_color" fill-opacity="0.7"/>
        </svg>
    </div>

    
</template>

<script>
 export default {
    name: "HalfCircle",
    props:{
        inner_color: String,
        outer_color: String,
    }
 }
</script>

<style scoped>
.half-circle-illustration{
    position: absolute; 
}
</style>
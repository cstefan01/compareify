<template>
    <div class="full-circle-illustration">
        <svg width="35" height="38" viewBox="0 0 35 38" fill="none" xmlns="http://www.w3.org/2000/svg">
            <ellipse cx="17.5" cy="19" rx="17.5" ry="19" :fill="outer_color" fill-opacity="0.53"/>
            <ellipse cx="18" cy="19" rx="13" ry="14" :fill="inner_middle_color" fill-opacity="0.7"/>
            <circle cx="17.5" cy="18.5" r="8.5" :fill="inner_color" fill-opacity="0.7"/>
        </svg>
    </div>
    
</template>

<script>
export default {
    name: "FullCircle",
    props:{
        inner_color: String,
        inner_middle_color: String,
        outer_color: String,
    }
}

</script>

<style scoped>
.full-circle-illustration{
    position: absolute; 
}

</style>
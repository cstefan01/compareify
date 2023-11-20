<template>
    <div class="container-fluid d-flex p-0 flex-column">
        <div class="hero col-12 d-flex">
            <div class="left-container col-6 d-flex justify-content-start align-items-center">
                <SloganSearchBar
                    slogan = "your source for price comparison"
                    search_placeholder="Enter product name"
                    button_text="Search Now!"
                    search_icon = "fas"
                />

                <HalfCircle 
                    class="half-circle-1"
                    outer_color="#ED6663"
                    inner_color="#FFA372"
                />

               <FullCircle 
                    class="full-circle-1"
                    outer_color="#ED6663"
                    inner_middle_color = "#FFA372"
                    inner_color="#B52B65"
                />

                <FullCircle 
                    class="full-circle-2"
                    outer_color="#ED6663"
                    inner_middle_color = "#FFA372"
                    inner_color="#B52B65"
                />

                <GirlIllustration 
                    class="girl-illustration-1"
                />
            </div>
            <div class="right-container col-6">
                <BoyIllustration />

                <HalfCircle 
                    class="half-circle-2"
                    outer_color="#ED6663"
                    inner_color="#FFA372"
                />

                <FullCircle 
                    class="full-circle-3"
                    outer_color="#ED6663"
                    inner_middle_color = "#FFA372"
                    inner_color="#B52B65"
                />

            </div>
        </div>

        <div class="hero-wave">
            <svg viewBox="30 110 1260 235" xmlns="http://www.w3.org/2000/svg">
                <path d="M1312.45 148.929L1292.63 139.489C1272.81 130.397 1233.35 110.998 1193.26 110.951C1153.62 110.387 1113.9 129.18 1073.74 142.5C1034.03 156.344 994.355 164.721 954.194 178.562C914.583 191.886 874.763 210.678 834.717 200.823C795.309 190.972 755.667 154.212 715.599 148.957C676.258 144.056 636.213 171.525 597.055 166.625C556.896 161.37 517.071 124.608 477.847 133.248C437.71 142.228 397.349 197.472 358.056 220.347C317.945 242.869 277.804 233.881 238.736 210.146C198.94 186.404 159.753 149.647 119.707 139.792C79.9348 129.939 40.3881 148.733 20.2989 157.52L0.20789 166.653L1.01432 -1.24096e-05L20.8782 0.152149C40.7419 0.30431 80.2872 0.607236 120.379 0.91435C160.016 1.21797 199.652 1.5216 239.744 1.82871C279.381 2.13234 319.017 2.43596 359.109 2.74307C398.654 3.046 438.382 3.35032 478.474 3.65744C517.928 3.95966 557.747 4.26468 597.839 4.5718C637.202 4.87333 677.112 5.17905 716.293 5.47918C756.476 5.78699 796.477 6.09341 835.658 6.39354C875.75 6.70066 915.842 7.00777 955.023 7.30791C995.024 7.61432 1035.21 7.92213 1074.39 8.22227C1114.3 8.52799 1153.66 8.82952 1193.75 9.13663C1233.57 9.44165 1273.03 9.74388 1293.07 9.89744L1313.12 10.051L1312.45 148.929Z"/>
            </svg>
        </div>
</div>
    
</template>

<script>
import SloganSearchBar from './SloganSearchBar.vue';
import HalfCircle from './illustrations/HalfCircle.vue';
import FullCircle from './illustrations/FullCircle.vue';
import GirlIllustration from './illustrations/GirlIllustration.vue';
import BoyIllustration from './illustrations/BoyIllustration.vue';

export default {
    name: "MainHero",
    props:{

    },
    components:{
        SloganSearchBar,
        HalfCircle,
        FullCircle,
        GirlIllustration,
        BoyIllustration
    }

}
</script>

<style scoped>
.hero{
    background: var(--ion-color-primary);
    min-height: 300px;
    padding: 20px 50px 20px 50px;
}

.hero-wave svg{
    fill: var(--ion-color-primary);
}
.hero-wave img{
  width: 100%;
}

.half-circle-1{
    left: -10px; 
    top: 115px;
    height: 10px;
}

.half-circle-2{
    right: -10px;
    top: 160px;
    transform: rotate(180deg);
    
}
.full-circle-1{
    left: 78px;
    top: 375px;
}

.full-circle-2{
    left: 850px;
    top: 400px;
}

.full-circle-3{
    right: 640px;
    top: 455px;
}

.girl-illustration-1{
    top: 400px;
    left: 305px;
}


</style>
<template>
  <div class="container-fluid d-flex p-0 flex-column">
    <div class="hero col-12 d-flex">
      <div
        class="left-container col-6 d-flex justify-content-start align-items-center"
      >
        <SloganSearchBar
          class="slogan-search-bar"
          slogan="your source for price comparison"
          search_placeholder="Enter product name"
          button_text="Search Now!"
          search_icon="fas"
          animation="slide-in-left  1s ease-in-out"
        />

        <HalfCircle
          class="half-circle-1"
          outer_color="#ED6663"
          inner_color="#FFA372"
          animation="slide-in-left  1s  500ms ease-in-out"
          show="true"
        />

        <FullCircle
          class="full-circle-1"
          outer_color="#ED6663"
          inner_middle_color="#FFA372"
          inner_color="#B52B65"
          animation="bounce-in-top 2.6s ease-in-out"
          show="true"
        />

        <FullCircle
          class="full-circle-2"
          outer_color="#ED6663"
          inner_middle_color="#FFA372"
          inner_color="#B52B65"
          animation="bounce-in-top 2.6s ease-in-out"
          show="true"
        />

        <GirlIllustration
          class="girl-illustration-1"
          animation="fade-in 1.5s ease-in-out"
          show="true"
        />
      </div>
      <div class="right-container col-6">
        <BoyIllustration animation="fade-in 1.5s ease-in-out" show="true" />

        <HalfCircle
          class="half-circle-2"
          outer_color="#ED6663"
          inner_color="#FFA372"
          animation="slide-in-right 1s 500ms ease-in-out"
          show="true"
        />

        <FullCircle
          class="full-circle-3"
          outer_color="#ED6663"
          inner_middle_color="#FFA372"
          inner_color="#B52B65"
          animation="bounce-in-top 2.6s ease-in-out"
          show="true"
        />
      </div>
    </div>

    <WavePattern
      class="hero-wave"
      min_x="30"
      min_y="110"
      width="1260"
      height="235"
    />
  </div>
</template>

<script>
import SloganSearchBar from "./SloganSearchBar.vue";
import HalfCircle from "./illustrations/HalfCircle.vue";
import FullCircle from "./illustrations/FullCircle.vue";
import GirlIllustration from "./illustrations/GirlIllustration.vue";
import BoyIllustration from "./illustrations/BoyIllustration.vue";
import WavePattern from "./illustrations/WavePattern.vue";

export default {
  name: "MainHero",
  props: {},
  components: {
    SloganSearchBar,
    HalfCircle,
    FullCircle,
    GirlIllustration,
    BoyIllustration,
    WavePattern,
  },
};
</script>

<style scoped>
.hero {
  background: var(--ion-color-primary);
  min-height: 300px;
  padding: 20px 50px 20px 50px;
}

.half-circle-1 {
  left: -10px;
  top: 115px;
  height: 10px;
}

.half-circle-2 {
  right: -10px;
  top: 160px;
  transform: rotate(180deg);
}
.full-circle-1 {
  left: 78px;
  top: 375px;
}

.full-circle-2 {
  left: 850px;
  top: 400px;
}

.full-circle-3 {
  right: 640px;
  top: 455px;
}

.girl-illustration-1 {
  top: 400px;
  left: 305px;
}

.hero-wave {
  fill: var(--ion-color-primary);
}
</style>

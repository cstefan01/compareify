<template>
  <div class="container-fluid footer p-0">
    <WavePattern
      class="footer-wave"
      fill="#fff"
      background="var(--ion-color-primary)"
      min_x="30"
      min_y="10"
      width="1260"
      height="235"
    />
    <div class="content col-12 d-flex p-0 flex-column">
      <NewsLetter />

      <div class="line-breaker">
        <hr />
      </div>

      <div class="about-site col-12">
        <div class="col-6">
          <h4>Compareify</h4>
        </div>

        <div class="site-description col-6">
          <span>
            Since 2023, Compareify has been dedicated to helping millions of
            users discover top-quality products at the most affordable
            prices.</span
          >
          <span>
            Compareify is a completely independent and freely accessible
            platform. Our mission is to become your trusted destination for
            effortless product and price comparisons.</span
          >
        </div>

        <div class="col-6">
          <ul class="socials">
            <li></li>
          </ul>
        </div>
      </div>
    </div>
    <CopyrightBar
      copyright_year="2023"
      copyright_author_name="Claudiu Stefan"
      copyright_author_link="https://github.com/cstefan01"
    />
  </div>
</template>

<script>
import CopyrightBar from "./CopyrightBar.vue";
import NewsLetter from "./NewsLetter.vue";
import WavePattern from "./illustrations/WavePattern.vue";

export default {
  name: "MainFooter",
  components: {
    CopyrightBar,
    NewsLetter,
    WavePattern,
  },
};
</script>

<style scoped>
.footer {
  color: var(--ion-color-primary-contrast);
}
.content {
  min-height: 600px;
}
.about-site {
  display: flex;
  flex-direction: column;
  justify-content: start;
  min-height: 300px;
  padding: 20px 0px 0px 70px;
  background: var(--ion-color-primary);
}

.about-site h4 {
  color: var(--ion-color-secondary);
  font-family: "Pacifico", cursive;
  font-size: 1.8em;
  letter-spacing: 0.25em;
  margin-bottom: 15px;
  padding: 0;
}

.line-breaker {
  width: 100%;
  padding: 0px 74px 0px 74px;
  background: var(--ion-color-primary);
}
.line-breaker hr {
  border: none;
  min-height: 5px;
  min-width: 100%;
  background: #ffffff;
  opacity: 0.8;
  border-radius: 20px;
}

.site-description {
  margin-bottom: 10px;
}
</style>

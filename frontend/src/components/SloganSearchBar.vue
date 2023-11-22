<template>
  <div class="slogan-search col-6" :style="computedAnimation">
    <div class="slogan">
      <h2 v-text="slogan"></h2>
    </div>

    <i class="fa-solid fa-face-smile"></i>

    <div class="search-bar d-flex">
      <div class="search-icon col-1">
        <font-awesome-icon :icon="['fas', 'face-smile']" />
      </div>
      <div class="search-input h-100 col-7">
        <input type="text" :placeholder="search_placeholder" />
      </div>
      <div class="search-button col-4">
        <button v-text="button_text"></button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SloganSearchBar",
  props: {
    slogan: String,
    search_placeholder: String,
    button_text: String,
    animation: String,
  },
  computed: {
    computedAnimation() {
      return "animation: " + this.animation + ";";
    },
  },
};
</script>

<style scoped>
.slogan {
  width: 100%;
  position: relative;
}
.slogan h2 {
  text-transform: uppercase;
  word-wrap: break-word;
  overflow-wrap: break-word;
  white-space: pre-wrap;
  font-family: "Lilita One", sans-serif;
  color: var(--ion-color-primary-contrast);
  font-size: 2.5em;
  margin-bottom: 25px;
}

.search-bar {
  width: 100%;
  height: 50px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 35px;
  border: 2px white solid;
}
.search-bar .search-button {
  display: flex;
  justify-content: end;
  height: 100%;
  border-radius: 0px 35px 35px 0px;
}
.search-bar .search-button button {
  border: none;
  height: 100%;
  width: 100%;
  background: var(--ion-color-secondary);
  color: var(--ion-color-primary-contrast);
  border-top-left-radius: 50px;
  border-top-right-radius: 30px;
  border-bottom-right-radius: 30px;
}

.search-bar .search-input {
  border-radius: 35px 0px 0px 35px;
}

.search-bar .search-input input[type="text"] {
  border: none;
  height: 100%;
  width: 100%;
  background: transparent;
  color: #fff;
  font-family: "Oswald", sans-serif;
}

.search-bar .search-input input[type="text"]::placeholder {
  color: #fff;
  font-family: "Oswald", sans-serif;
  letter-spacing: 0.2em;
}

.search-bar .search-input input[type="text"]:focus {
  border: none;
  outline: none;
}
.search-bar .search-icon {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  border-radius: 35px 0px 0px 35px;
  color: #fff;
  font-size: 1.1em;
}
</style>

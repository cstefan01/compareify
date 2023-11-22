<template>
  <div class="newsletter col-12">
    <i></i>
    <h3>Subscribe to our newsletter</h3>
    <p>
      We handpick the very best deals, trends and product news - making sure you
      never miss a thing.
    </p>

    <div class="newsletter-entry col-3">
      <div class="newsletter-icon mh-100 col-2">s</div>
      <div class="newsletter-input mh-100 col-8">
        <input type="text" placeholder="Your email address" />
      </div>
      <div class="newsletter-button mh-100 col-2">
        <button>-></button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "NewsLetter",
};
</script>

<style scoped>
.newsletter {
  min-height: 300px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: var(--ion-color-primary);
  background: var(--ion-color-primary);
  text-align: center;
}
.newsletter h3 {
  font-family: "DM Sans", sans-serif;
  font-size: 2.5em;
}

.newsletter p {
  font-family: "Roboto Condensed", sans-serif;
  letter-spacing: 0.2em;
  font-size: 1em;
}

.newsletter-entry {
  display: flex;
  min-height: 50px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 35px;
  border: 1px #cec7c7 solid;
  background: #fff;
}

.newsletter-entry .newsletter-icon {
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 35px 0px 0px 35px;
  color: #000000;
}
.newsletter-entry .newsletter-input input[type="text"] {
  border: none;
  height: 100%;
  width: 100%;
  background: #fff;
  color: #000000;
  font-family: "Oswald", sans-serif;
  
}
.newsletter-entry .newsletter-input input[type="text"]::placeholder {
  color: #000000;
  font-family: "Oswald", sans-serif;
  letter-spacing: 0.2em;
}

.newsletter-entry .newsletter-input input[type="text"]:focus {
  border: none;
  outline: none;
}
.newsletter-entry .newsletter-button {
  display: flex;
  justify-content: end;
  align-items: center;
  border-radius: 0px 35px 35px 0px;
}

.newsletter-entry .newsletter-button button{
    border: none;
    border-radius: 40px;
    width: 50px;
    height: 40px;
    background: #ED6663;
    margin-right: 10px;
}
</style>

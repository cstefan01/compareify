<template>
    <VueFragment>
      <NavigationBar site_name="compareify" />
      <MainHero />
  
      <div class="col-12 d-flex justify-content-center align-items-center">
        <!-- <ToastMessage 
              title = "No product to be shown"
              message = "Search for a product now"
          /> -->
  
        <div class="products-container">
          <h3>You searched for "iphone"</h3>
  
          <div class="show-all-divider">
            <hr />
            <span>Show all</span>
            <hr />
          </div>
          <div class="products">
            <ProductCard
              name="Apple IPhone 15 Pro Max 256GB"
              :cost="1700.5"
              image_path="https://m.media-amazon.com/images/I/81TTB6rxyWL.jpg"
              :isOnDiscount="true"
              :discount_rate="20"
            />
  
            <ProductCard
              name="Apple IPhone 15 Pro Max 256GB"
              :cost="1700.5"
              image_path="https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-finish-select-202207-pink?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1693063160403"
              :isOnDiscount="true"
              :discount_rate="20"
            />
  
            <ProductCard
              name="Apple IPhone 15 Pro Max 256GB"
              :cost="1700.5"
              image_path="https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-finish-select-202207-pink?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1693063160403"
              :isOnDiscount="true"
              :discount_rate="20"
            />
  
            <ProductCard
              name="Apple IPhone 15 Pro Max 256GB"
              :cost="1700.5"
              image_path="https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-finish-select-202207-pink?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1693063160403"
              :isOnDiscount="true"
              :discount_rate="20"
            />
          </div>
          <div class="show-all-divider">
            <hr />
            <span>Show all</span>
            <hr />
          </div>
        </div>
      </div>
  
      <MainFooter
        copyright_year="2023"
        copyright_author_name="Claudiu Stefan"
        copyright_author_link="https://github.com/cstefan01"
      />
    </VueFragment>
  </template>
  
  <script>
  //import ToastMessage from '../components/ToastMessage.vue'
  import NavigationBar from "../components/NavigationBar.vue";
  import MainHero from "../components/MainHero.vue";
  import MainFooter from "../components/MainFooter.vue";
  import ProductCard from "../components/ProductCard.vue";
  
  export default {
    name: "SearchResultPage",
    components: {
      NavigationBar,
      MainHero,
      MainFooter,
      ProductCard,
      //ToastMessage
    },
  };
  </script>
  
  <style>
  .page {
    display: flex;
    flex-direction: column;
    /* background: var(--ion-color-primary); */
  }
  
  .products-container {
    width: 1000px;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
  }
  
  .products {
    display: flex;
    width: 900px;
    align-items: center;
    justify-content: space-evenly;
    flex-wrap: wrap;
  }
  
  .show-all-divider {
    display: flex;
    justify-content: center;
    justify-items: center;
    align-items: center;
    width: 100%;
    padding-left: 50px;
    padding-right: 50px;
    margin-bottom: 20px;
    margin-top: 20px;
  }
  
  .show-all-divider hr {
    border: solid #ada2a6 1px;
    position: relative;
    z-index: 10;
    min-width: 367px;
  }
  
  .show-all-divider span {
    position: relative;
    color: var(--ion-color-primary);
    cursor: pointer;
    padding: 5px;
    z-index: 20;
    text-align: center;
    min-width: 120px;
    background: #fff;
    font-family: "Oswald", sans-serif;
    letter-spacing: 2px;
    font-size: 1.2em;
  }
  </style>
  
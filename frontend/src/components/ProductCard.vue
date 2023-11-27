<template>
  <div class="product-card">
    <div class="top-container">
      <div class="product-image">
        <img :src="image_path" alt="" />
      </div>
    </div>

    <div class="product-attributes">
      <div class="left-attributes">
        <h4 v-text="name"></h4>
        <div class="price-tag">
          <span class="product-cost"><del v-text="formattedCost"></del></span>
          <span class="product-discounted-cost">£1,512.00</span>
        </div>
      </div>

      <div class="right-attributes">
        
        <div v-if="isOnDiscount" class="discount-tag">
            <span>{{discount_rate}}% off</span>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ProductCard",
  props: {
    name: String,
    sub_title: String,
    isOnDiscount: Boolean,
    discount_rate: Number,
    isProductFound: Boolean,
    hasRating: Boolean,
    isWatched: Boolean,
    cost: Number,
    image_path: String,
  },
  computed: {
    formattedCost() {
      return this.cost.toLocaleString("en-GB", {
        style: "currency",
        currency: "GBP",
      });
    },
  },
};
</script>

<style scoped>
.product-card {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  min-height: 400px;
  min-width: 400px;
  border-radius: 10px;
  border: solid 1px rgb(223, 223, 223);
  margin-bottom: 20px;
}

.top-container {
  min-height: 250px;
  background: var(--ion-color-tertiary);
  border-radius: 10px 10px 0px 0px;
  padding: 10px;
}

.product-attributes {
  min-height: 150px;
  border-radius: 0px 0px 10px 10px;
}

.product-image {
  min-width: 400px;
  min-height: 250px;
  background: #fff;
  border-radius: 10px;
}

.product-image img {
  min-width: 400px;
  max-width: 400px;
  min-height: 250px;
  max-height: 250px;
  border-radius: 10px;
}

.product-attributes .left-attributes {
  padding: 10px;
  min-height: 150px;
  max-height: 150px;

  min-width: 260px;
  max-width: 260px;

  float: left;
  border-radius: 0px 0px 0px 10px;
  background: transparent;
}

.product-attributes .left-attributes h4 {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: wrap;
  word-wrap: break-word;
  min-height: 60px;
  max-height: 60px;
}

.product-attributes .right-attributes {
  min-height: 150px;
  max-height: 150px;

  min-width: 160px;
  max-width: 160px;

  float: right;
  border-radius: 0px 0px 10px 0px;
  display: flex;
  flex-direction: column;
  justify-content: end;
  align-items: end;
  justify-items: center;
  justify-content: space-around;
}

.price-tag {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
  text-align: center;
  min-width: 140px;
  max-width: 140px;

  min-height: 60px;
  max-height: 60px;

  background: var(--ion-color-tertiary);

  border-radius: 6px;
}
.price-tag .product-cost,
.product-discounted-cost {
  color: var(--ion-color-primary);
}

.price-tag .product-cost {
  margin-top: 4px;
  font-size: 1em;
  font-family: "Roboto Slab", serif;
}

.price-tag .product-discounted-cost {
  font-size: 1.2em;
  font-family: "Vina Sans", sans-serif;
  letter-spacing: 0.2em;
  margin-bottom: 5px;
}

.discount-tag{
    text-align: center;
    background: #FF5858;
    min-width: 10px;
    padding: 3px;
    border-radius: 5px;
    color: #fff;
    font-family: 'Vina Sans', sans-serif;
    letter-spacing: 2px;
    min-width: 100px;
    max-width: 100px;
}
</style>

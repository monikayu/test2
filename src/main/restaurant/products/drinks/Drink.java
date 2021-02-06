package main.restaurant.products.drinks;

import main.restaurant.products.FoodProduct;

import static main.restaurant.products.FoodProduct.Kind.drink;

public abstract class Drink extends FoodProduct {

    public enum Type {
        alcoholic(4, "алкохолна напитка"), nonalcoholic(2, "безалкохолна напитка");

        private int price;
        private String name;

        Type(int price, String name) {
            this.price = price;
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public Drink(Type type) {
        super(drink, type.name, type.price);
    }

}

package main.restaurant.products.dishes;

import main.restaurant.products.FoodProduct;
import util.Generate;

import static main.restaurant.products.FoodProduct.Kind.dish;

public abstract class Dish extends FoodProduct {

    public enum Type{
        main(400, 800, 9, "основно ястие"), dessert(200,300,4, "десерт"), salad(300, 600,5, "салата");
        private int minGramage;
        private int maxGramage;
        private int price;
        private String name;

        Type(int minGramage, int maxGramage, int price, String name) {
            this.minGramage = minGramage;
            this.maxGramage = maxGramage;
            this.price = price;
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    private int quantity;

    public Dish(Type type) {
        super(dish, type.name, type.price);
        this.quantity = Generate.number(type.minGramage, type.maxGramage);
    }

    public Kind getKind(){
        return dish;
    }
}

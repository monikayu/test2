package main.people.clients;

import main.restaurant.Restaurant;
import main.restaurant.products.FoodProduct;
import main.restaurant.products.dishes.Dish;
import main.restaurant.products.drinks.Drink;

public class Mug extends Client { //мутра

    public Mug(Restaurant restaurant) {
        super(50, restaurant);
    }

    @Override
    protected FoodProduct chooseDish() {
        return restaurant.getDish(Dish.Type.main);
    }

    @Override
    protected FoodProduct chooseDrink() {
        return  restaurant.getDrink(Drink.Type.alcoholic);
    }




}

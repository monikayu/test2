package main.people.clients;

import main.restaurant.Restaurant;
import main.restaurant.products.FoodProduct;
import main.restaurant.products.dishes.Dish;
import main.restaurant.products.drinks.Drink;

public class Vegan extends Client {

    public Vegan(Restaurant restaurant) {
        super(30, restaurant);
    }

    @Override
    protected FoodProduct chooseDish() {
        return restaurant.getDish(Dish.Type.salad);
    }

    @Override
    protected FoodProduct chooseDrink() {
        return restaurant.getDrink(Drink.Type.nonalcoholic);
    }

}

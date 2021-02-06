package main.people.clients;

import main.restaurant.Restaurant;
import main.restaurant.products.FoodProduct;
import main.restaurant.products.dishes.Dish;
import main.restaurant.products.drinks.Drink;

public class Student extends Client {

    public Student(Restaurant restaurant) {
        super(10, restaurant);
    }

    @Override
    protected FoodProduct chooseDish() {
        return restaurant.getDish(Dish.Type.values()[Dish.Type.values().length - 1]);
    }

    @Override
    protected FoodProduct chooseDrink() {
        return restaurant.getDrink(Drink.Type.values()[Drink.Type.values().length -1]);
    }

}

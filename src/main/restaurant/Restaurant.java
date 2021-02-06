package main.restaurant;

import main.people.waiters.Waiter;
import main.restaurant.products.FoodProduct;
import main.restaurant.products.dishes.Dessert;
import main.restaurant.products.dishes.Dish;
import main.restaurant.products.dishes.MainDish;
import main.restaurant.products.dishes.Salad;
import main.restaurant.products.drinks.AlcoholicDrink;
import main.restaurant.products.drinks.Drink;
import main.restaurant.products.drinks.NonalcoholicDrink;
import util.Generate;

import java.util.*;

public class Restaurant {
    private String name;
    private String address;
    private final double capital; //начална сума, налична в касата на ресторанта;
    private double balance;
    private HashSet<Waiter> waiters;
    private HashMap<Drink.Type, Queue<Drink>> drinks;
    private HashMap<Dish.Type, Queue<Dish>> dishes;
    private HashMap<FoodProduct.Kind, HashMap<String, Queue<FoodProduct>>> menu;

    public Restaurant(String name, double capital) {
        this.name = name;
        this.capital = capital;
        this.balance = capital;
        //waiters
        waiters = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            waiters.add(new Waiter());
        }
        // menu
        menu = new HashMap<FoodProduct.Kind, HashMap<String, Queue<FoodProduct>>>();
        for (int i = 0; i < 10; i++) {
            addProduct(new MainDish());
            addProduct(new Dessert());
            addProduct(new Salad());
        }
        for (int i = 0; i < 20; i++) {
            addProduct(new NonalcoholicDrink());
            addProduct(new AlcoholicDrink());
        }

    }

    public FoodProduct getDish(Dish.Type type){
        return getProduct(FoodProduct.Kind.dish, type.getName());
    }

    public FoodProduct getDrink(Drink.Type type){
        return getProduct(FoodProduct.Kind.drink, type.getName());
    }

    private FoodProduct getProduct(FoodProduct.Kind k, String n){
        if(menu.get(k).get(n).isEmpty()){
            System.out.println(n + " не е в наличност.");
            return null;
        }
        return menu.get(k).get(n).peek();
    }

    public void serve(FoodProduct p){
        menu.get(p.getKind()).get(p.getName()).poll();
    }

    public Waiter getRandomWaiter() {
        int rand = Generate.number(0, waiters.size() - 1);
        int counter = 0;
        for (Waiter w : waiters) {
            if (counter == rand)
                return w;
            counter++;
        }
        System.out.println("No waiters found");
        return null;
    }

    private void addProduct(FoodProduct p){
        FoodProduct.Kind kind = p.getKind();
        String name = p.getName();
        if(!menu.containsKey(kind)){
            menu.put(kind, new HashMap<>());
        }
        if(!menu.get(kind).containsKey(name)){
            menu.get(kind).put(name, new LinkedList<FoodProduct>());
        }
        menu.get(kind).get(name).offer(p);
    }

    public void printWaitersByTip(){
        TreeSet<Waiter> waitersSorted = new TreeSet<Waiter>((o1, o2) -> {
            if (o1.getId() == o2.getId()) {
                return 0;
            }
            if (o1.getTip() == o2.getTip()) {
                return 1;
            }
            return Double.compare(o2.getTip(), o1.getTip());
        });

        waitersSorted.addAll(waiters);
        System.out.println();
        System.out.println("--Сервитьори--");
        waitersSorted.forEach(w -> System.out.printf(w + " %.2f лв \n", w.getTip()));

        Waiter j = waitersSorted.first();
        System.out.printf("Сервитьорът с най-голям бакшиш: " + j + " %.2f лв \n", j.getTip());
    }

    public void printBalance(){
        System.out.println("Паричен баланс на ресторанта: " + balance + " лв");
    }

    public void printProductsLeft(){
        TreeMap<Integer, String> drinksOrdered = new TreeMap<Integer, String>((i1, i2) -> {
            if(i1 == i2){
                return 1;
            }
            return Integer.compare(i1, i2);
        });
        TreeMap<Integer, String> dishesOrdered = new TreeMap<Integer, String>(((i1, i2) -> {
            if(i1 == i2){
                return 1;
            }
            return Integer.compare(i1, i2);
        }));
        System.out.println();
        System.out.println("Ястия: ");
        menu.get(FoodProduct.Kind.dish).forEach((key, value) -> dishesOrdered.put(value.size(), key));
        dishesOrdered.forEach((key, value) ->
                System.out.println(value + " - " + key + " порции")
        );
        System.out.println();
        System.out.println("Напитки:");
        menu.get(FoodProduct.Kind.drink).forEach((key, value) -> drinksOrdered.put(value.size(), key));
        drinksOrdered.forEach((key, value) ->
                System.out.println(value + " - " + key + " броя")
        );
    }

    public void earn(double amount) {
        balance += amount;
    }
}

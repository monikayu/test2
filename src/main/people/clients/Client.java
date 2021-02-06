package main.people.clients;

import main.people.Person;
import main.people.waiters.Waiter;
import main.restaurant.Restaurant;
import main.restaurant.products.FoodProduct;
import util.Generate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Client extends Person {
    protected ArrayList<FoodProduct> order;
    protected double wallet;
    protected Restaurant restaurant;
    protected Waiter waiter;
    private double bill;

    public Client(double wallet, Restaurant restaurant) {
        this.wallet = wallet;
        this.restaurant = restaurant;
    }

    public void pay() {
        if(order != null && bill == 0){
            askForBill();
        }
        wallet -= bill;
        restaurant.earn(bill);
        int rand = Generate.number(1, 10);
        if(rand <= 8) {
            double tip = (Generate.number(5, 10) * 1.0 / 100 * bill);
            waiter.receiveTip(tip);
        }
        order = null;
    }

    public void askForBill(){ //TODO
        if(order != null){
            bill = waiter.giveBill(this);
            return;
        }
        System.out.println("Скандален! Нищо не си поръчал.");
    }
    protected double computeBill(){
        int total = 0;
        if(order != null){
            for(FoodProduct p : order){
                total += p.getPrice();
            }
        }
        return total;
    }

    public void placeOrder() {
        this.waiter = restaurant.getRandomWaiter();
        order = new ArrayList<>();

        int productsOrdered = Generate.number(1, 3);
        for (int i = 0; i < productsOrdered; i++) {
            FoodProduct p = new Random().nextBoolean() ? chooseDish() : chooseDrink();
            if(p == null){
                continue;
            }
            if(computeBill() + p.getPrice() <= .9 * wallet){
                order.add(p);
                waiter.writeDownOrder(this, p);
                restaurant.serve(p);
            }
        }
    }

    protected abstract FoodProduct chooseDish();

    protected abstract FoodProduct chooseDrink();

    public void leaveRestaurant(){
        order = null;
        waiter.clearTable(this);
    }


}

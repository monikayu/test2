package main.people.waiters;

import main.people.Person;
import main.people.clients.Client;
import main.restaurant.products.FoodProduct;
import java.util.ArrayList;
import java.util.HashMap;

public class Waiter extends Person {

    private double tip;
    private HashMap<Client, ArrayList<FoodProduct>> clients;

    public Waiter() {
        clients = new HashMap<>();
    }

    public void receiveTip(double amount) {
        tip += amount;
    }

    public double getTip() {
        return tip;
    }

    public double giveBill(Client c) {
        double total = 0;
        if (clients.get(c).isEmpty()) {
            return 0;
        }
        for (int i = 0; i < clients.get(c).size(); i++) {
            total += clients.get(c).get(i).getPrice();
        }
        System.out.printf("Вашата сметка е %.2f лв \n", total);
        return total;
    }

    public void writeDownOrder(Client c, FoodProduct p){
        if(!clients.containsKey(c)){
            clients.put(c, new ArrayList<>());
        }
        clients.get(c).add(p);
    }

    public void clearTable(Client c){
        clients.remove(c);
    }
}

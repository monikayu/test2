package main;

import main.people.clients.Client;
import main.people.clients.Mug;
import main.people.clients.Student;
import main.people.clients.Vegan;
import main.restaurant.Restaurant;
import util.Generate;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Restaurant rest = new Restaurant("При Пешо Таланта", 1000);
        ArrayList<Client> clients = new ArrayList<Client>();
        for (int i = 0; i < 15; i++) {
            clients.add(randomClient(rest));
        }
        clients.forEach(client -> client.placeOrder());
        clients.forEach(client -> client.askForBill());
        clients.forEach(client -> client.pay());
        clients.forEach(client -> client.leaveRestaurant());
        rest.printWaitersByTip();
        rest.printBalance();
        rest.printProductsLeft();
    }

    public static Client randomClient(Restaurant r) {
        int rand = Generate.number(1, 10);
        if(rand > 5){
            return new Mug(r);
        }
        if(rand <= 2){
            return new Vegan(r);
        }
        return new Student(r);
    }
}

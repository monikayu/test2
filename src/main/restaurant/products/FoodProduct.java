package main.restaurant.products;

import java.util.Objects;

public abstract class FoodProduct{
    protected String name;
    protected final int price;
    protected int number; //Номер подред
    private static int sequenceNumber = 0;
    private Kind kind;

    public enum Kind{
        drink, dish;
    }

    public FoodProduct(Kind kind, String name, int price) {
        this.kind = kind;
        this.name = name;
        this.price = price;
        this.number = ++sequenceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodProduct foodProduct = (FoodProduct) o;
        return number == foodProduct.number &&
                Objects.equals(name, foodProduct.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public String getName(){
        return name;
    }

    public Kind getKind(){
        return kind;
    }

}

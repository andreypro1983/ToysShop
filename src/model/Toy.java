package model;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private int quantity;
    private int weight;

    public Toy(String name, int quantity, int weight) {
        this.id = 0;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "id: " + this.id + " name: " + this.name + " quantity: " + this.quantity + " weight: " + this.weight;
    }

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(this.id, o.id);
    }

}

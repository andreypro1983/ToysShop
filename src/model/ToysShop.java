package model;

public class ToysShop {
    public ToysList toys;
    public ToysDraw draw;

    private ToysShop(ToysList toys, ToysDraw draw) {
        this.toys = new ToysList();
        this.draw = new ToysDraw();
    }

    public ToysShop() {
        this(new ToysList(), new ToysDraw());
    }

    public void addToy(String name, int quantity, int weight) {
        Toy new_toy = new Toy(name, quantity, weight);
        this.toys.addToy(new_toy);
    }

}

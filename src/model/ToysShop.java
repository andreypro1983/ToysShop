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
    
}

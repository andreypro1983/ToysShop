package model;

import java.util.LinkedList;

public class ToysDraw {
    private ToysList toys;
    private LinkedList<Toy> drawToys;


    public ToysDraw(ToysList toys) {
        this.toys = toys;
        this.drawToys = new LinkedList<Toy>();
    }

    public ToysDraw() {
        this.toys = new ToysList();
        this.drawToys = new LinkedList<Toy>();
    }


    
    
}
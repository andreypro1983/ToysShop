package model;

import java.util.ArrayList;
import java.util.List;

public class ToysList {
    private List<Toy> toys;

    // private ToysList(List<Toy> toys) {
    //     this.toys = toys;
    // }

      public ToysList() {
        this.toys = new ArrayList<Toy>();
    }
    
    public void addToy(Toy toy){
        this.toys.add(toy);
    }
    
}

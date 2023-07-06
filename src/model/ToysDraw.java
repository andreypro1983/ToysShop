package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

    public LinkedList<Toy> getDrawToys() {
        return drawToys;
    }

    public String chooseGiftToy() {
        Toy chooseToy = toys.getToys().get(findIndexToyWithMaxSumWeight());
        if (chooseToy.getQuantity() > 1) {
            drawToys.addLast(chooseToy);
            chooseToy.setQuantity(chooseToy.getQuantity() - 1);
            return "Выпала призовая игрушка - " + chooseToy.getName();
        } else if (chooseToy.getQuantity() == 1) {
            drawToys.addLast(chooseToy);
            toys.removeToy(chooseToy);
            return "Выпала призовая игрушка - " + chooseToy.getName();
        } else {
            toys.removeToy(chooseToy);
            return chooseGiftToy();
        }
    }

    public String giveGiftToy() {
        Toy giveToy = this.drawToys.pollFirst();
        if (giveToy == null) {
            return null;
        } else {
            return giveToy.getName();
        }
    }

    private int findIndexToyWithMaxSumWeight() {
        List<Integer> sumWeight = new ArrayList<>();
        for (int i = 0; i < toys.getToys().size(); i++) {
            sumWeight.add(toys.getToys().get(i).getWeight() * toys.getToys().get(i).getQuantity());
        }
        return sumWeight.indexOf(Collections.max(sumWeight));
    }

    public void setToys(ToysList toys) {
        this.toys = toys;
    }

    public ToysList getToys() {
        return toys;
    }

}

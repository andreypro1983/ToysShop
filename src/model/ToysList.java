package model;

import java.util.ArrayList;
import java.util.List;

public class ToysList {
    private ArrayList<Toy> toys;
    private int count;

    public ToysList() {
        this.toys = new ArrayList<Toy>();
        this.count = 0;
    }

    public void addToy(Toy toy) {
        this.toys.add(toy);
    }

    public void removeToy(Toy toy) {
        this.toys.remove(toy);
    }

    public void editWeightToy(Toy toy, int weight) {
        toy.setWeight(weight);
    }

    public List<Toy> getToys() {
        return toys;
    }

    public String showToys() {
        StringBuilder stringBuilder = new StringBuilder();
        if (toys.size() > 0) {
            for (Toy toy : toys) {
                stringBuilder.append(toy.toString()).append("\n");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else {
            stringBuilder.append("СПИСОК ИГРУШЕК ПУСТ");
        }
        return stringBuilder.toString();
    }

    public boolean checkExistToyById(int id) {
        boolean isExist = false;
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getId() == id) {
                isExist = true;
            }
        }
        return isExist;
    }

    public Toy getToyById(int id) {
        for (int i = 0; i < toys.size(); i++) {
            if (toys.get(i).getId() == id) {
                Toy editToy = toys.get(i);
                return editToy;
            }
        }
        return null;
    }

    public int getCount() {
        count += 1;
        return count;
    }

}

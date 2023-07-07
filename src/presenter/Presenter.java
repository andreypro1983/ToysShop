package presenter;

import model.ToysShop;
import view.View;

public class Presenter {
    private ToysShop toysShop;
    private View view;

    public Presenter(ToysShop toysShop, View view) {
        this.toysShop = toysShop;
        this.view = view;
        view.setPresenter(this);
    }

    public void addToy(String name, int quantity, int weight) {
        this.toysShop.addToy(name, quantity, weight);
    }

    public void showToys() {
        view.print(this.toysShop.showToys());
    }

    public void chooseGiftToy() {
        view.print(this.toysShop.chooseGiftToy());
    }

    public void giveGiftToy() {
        view.print(this.toysShop.giveGiftToy());
    }

    public void editWeightToy(int id, int weight) {
        view.print(this.toysShop.editWeightToy(id, weight));
    }

    public boolean isEmptyToysList() {
        return this.toysShop.isEmptyToysList();
    }

}

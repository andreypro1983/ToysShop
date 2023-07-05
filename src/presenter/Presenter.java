package presenter;


import model.ToysShop;
import view.Console;

public class Presenter {
    private ToysShop toysShop;
    private Console view;
    
    public Presenter(ToysShop toysShop, Console view) {
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
        view.print("Выпала призовая игрушка - " + this.toysShop.chooseGiftToy());
    }
    
    public void editWeightToy(int id, int weight) {
        view.print(this.toysShop.editWeightToy(id, weight));
    }


}

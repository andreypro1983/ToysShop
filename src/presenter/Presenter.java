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
        
    }


}

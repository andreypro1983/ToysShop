import model.ToysShop;
import presenter.Presenter;
import view.Console;

public class Main {
    public static void main(String[] args) throws Exception {

        ToysShop toysShop = new ToysShop();
        Console view = new Console();
        Presenter presenter = new Presenter(toysShop, view);
        view.start();

    }
}

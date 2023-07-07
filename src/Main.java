import model.ToysShop;
import presenter.Presenter;
import view.Console;
import view.View;

public class Main {
    public static void main(String[] args) throws Exception {

        ToysShop toysShop = new ToysShop();
        View view = new Console();
        Presenter presenter = new Presenter(toysShop, view);
        view.start();
    }
}

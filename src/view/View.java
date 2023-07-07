package view;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);

    void print(String text);

    void start();

    void chooseGiftToy();

    void editWeightToy();

    void showToys();

    void giveGiftToy();

    void addToy();

    void exit();

}

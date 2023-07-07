package view.commands;

import view.View;

public class ShowToys implements Command {
    View view;

    public ShowToys(View view) {
        this.view = view;

    }

    @Override
    public void execute() {
        this.view.showToys();

    }

    @Override
    public String getDescription() {
        return "Показать все игрушки";
    }

}

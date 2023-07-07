package view.commands;

import view.View;

public class AddToy implements Command {
    View view;

    public AddToy(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.addToy();

    }

    @Override
    public String getDescription() {
        return "Добавить игрушку";
    }

}

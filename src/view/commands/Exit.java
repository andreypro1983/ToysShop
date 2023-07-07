package view.commands;

import view.View;

public class Exit implements Command {
    View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.exit();

    }

    @Override
    public String getDescription() {
        return "Выход";
    }

}

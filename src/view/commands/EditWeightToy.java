package view.commands;

import view.View;

public class EditWeightToy implements Command {
    View view;

    public EditWeightToy(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.editWeightToy();

    }

    @Override
    public String getDescription() {
        return "Изменить вес выпадения игрушки";
    }

}

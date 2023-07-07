package view.commands;

import view.View;

public class ChooseGiftToy implements Command {
    View view;

    public ChooseGiftToy(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.chooseGiftToy();

    }

    @Override
    public String getDescription() {
        return "Определить призовую игрушку";
    }

}

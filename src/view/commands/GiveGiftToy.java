package view.commands;

import view.View;

public class GiveGiftToy implements Command {
    View view;

    public GiveGiftToy(View view) {
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.giveGiftToy();

    }

    @Override
    public String getDescription() {
        return "Выдать призовую игрушку";
    }

}

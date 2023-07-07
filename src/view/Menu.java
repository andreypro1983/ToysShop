package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddToy;
import view.commands.ChooseGiftToy;
import view.commands.Command;
import view.commands.EditWeightToy;
import view.commands.Exit;
import view.commands.GiveGiftToy;
import view.commands.ShowToys;

public class Menu {
    View view;
    List<Command> listCommand;

    public Menu(View view) {
        this.view = view;
        this.listCommand = new ArrayList<>();
        this.listCommand.add(new AddToy(view));
        this.listCommand.add(new ShowToys(view));
        this.listCommand.add(new EditWeightToy(view));
        this.listCommand.add(new ChooseGiftToy(view));
        this.listCommand.add(new GiveGiftToy(view));
        this.listCommand.add(new Exit(view));
    }

    public void execute(int numCommand) {
        if (numCommand != 0) {
            listCommand.get(numCommand - 1).execute();
        }
    }

    public String show() {
        int size = listCommand.size();
        if (size > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\nГЛАВНОЕ МЕНЮ: \n\n");
            for (int i = 0; i < size; i++) {
                stringBuilder.append(i + 1);
                stringBuilder.append(". ");
                stringBuilder.append(listCommand.get(i).getDescription());
                stringBuilder.append("\n");
            }
            // stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        return null;
    }

    public int size() {
        return this.listCommand.size();
    }

}

package model;

import java.io.FileWriter;
import java.io.IOException;

public class GiftedToyToFile {
    String path;

    public GiftedToyToFile(String path) {
        this.path = path;
    }

    public GiftedToyToFile() {
        this("giftToy.txt");
    }

    public void saveToFile(String toy) {

        try (FileWriter writer = new FileWriter(this.path, true)) {
            writer.write(toy);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

}

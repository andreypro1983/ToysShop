package model;

public class ToysShop {
    public ToysList toys;
    public ToysDraw draw;
    public GiftedToyToFile toFile;

    private ToysShop(ToysList toys, ToysDraw draw) {
        this.toys = new ToysList();
        this.draw = new ToysDraw(this.toys);
        this.toFile = new GiftedToyToFile();
    }

    public ToysShop() {
        this(new ToysList(), new ToysDraw());
    }

    public void addToy(String name, int quantity, int weight) {
        Toy newToy = new Toy(name, quantity, weight);
        newToy.setId(this.toys.getCount());
        this.toys.addToy(newToy);
    }

    public String showToys() {
        return this.toys.showToys();
    }

    public String chooseGiftToy() {
        if (this.toys.getToys().isEmpty()) {
            return "ОТСУТСТВУЮТ ИГРУШКИ ДЛЯ ВЫБОРА ПРИЗОВОЙ";
        } else {
            return this.draw.chooseGiftToy();
        }

    }

    public boolean isEmptyToysList() {
        if (this.toys.getToys().size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public String giveGiftToy() {
        String giftToy = this.draw.giveGiftToy();
        if (giftToy != null) {
            this.toFile.saveToFile(giftToy);
            return "Выдана призовая игрушка - " + giftToy;
        } else {
            return "ОТСУТСТВУЮТ ПРИЗОВЫЕ ИГРУШКИ ДЛЯ ВЫДАЧИ";
        }
    }

    public String editWeightToy(int id, int weight) {
        if (this.toys.checkExistToyById(id)) {
            Toy editToy = this.toys.getToyById(id);
            this.toys.editWeightToy(editToy, weight);
            return "Вес выпадения игрушки изменен";
        } else {
            return "\nИГРУШКА С ТАКИМ id НЕ НАЙДЕНА.";
        }
    }

}

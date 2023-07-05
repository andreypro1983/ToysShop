package model;

public class ToysShop {
    public ToysList toys;
    public ToysDraw draw;

    private ToysShop(ToysList toys, ToysDraw draw) {
        this.toys = new ToysList();
        this.draw = new ToysDraw();
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
        this.draw.setToys(this.toys);
        this.draw.chooseGiftToy();
        return this.draw.getDrawToys().peekLast().getName();

    }
    
    public String editWeightToy(int id, int weight) {
        if (this.toys.checkExistToyById(id)) {
            Toy editToy = this.toys.getToyById(id);
            this.toys.editWeightToy(editToy, weight);
            return "Вес выпадения игрушки изменен";
        }
        else {
            return "Игрушка с таким id не найдена";
        }
    }

}

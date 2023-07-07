package view;

import java.util.Scanner;
import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu mainMenu;
    private boolean work;
    private final String notDigitError = "\nВВЕДЕННЫЕ ДАННЫЕ НЕ ЯВЛЯЮТСЯ ЧИСЛОМ";
    private final String digitPositiveInfoError = "\nВВОДИМОЕ ЗНАЧЕНИЕ ДОЛЖНО БЫТЬ ПОЛОЖИТЕЛЬНЫМ ЦЕЛЫМ ЧИСЛОМ";

    public Console() {
        this.scanner = new Scanner(System.in, "Cp866");
        this.work = true;
        this.mainMenu = new Menu(this);
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void print(String text) {
        System.out.println(text);
    }

    public void start() {
        while (work) {
            printMenu();
            int command = inputMenu();
            mainMenu.execute(command);
        }
    }

    public void printMenu() {
        System.out.println(mainMenu.show());
    }

    public void chooseGiftToy() {
        System.out.println("\nОПРЕДЕЛЕНИЕ ПРИЗОВОЙ ИГРУШКИ\n");
        this.presenter.chooseGiftToy();
    }

    public void editWeightToy() {
        System.out.println("\nИЗМЕНЕНИЕ ВЕСА ИГРУШКИ");
        if (this.presenter.isEmptyToysList()) {
            System.out.println("\nСПИСОК ИГРУШЕК ПУСТ");
        } else {
            int toyId = inputId();
            int toyWeight = inputWeight();
            if ((toyId != -1) && (toyWeight != -1)) {
                this.presenter.editWeightToy(toyId, toyWeight);
            }
        }
    }

    public void showToys() {
        System.out.println("\nСПИСОК ИГРУШЕК:\n");
        this.presenter.showToys();
    }

    public void giveGiftToy() {
        System.out.println("\nВЫДАЧА ПРИЗОВОЙ ИГРУШКИ\n");
        this.presenter.giveGiftToy();

    }

    public int inputMenu() {
        System.out.print("Выберите один из пунктов меню: \n");
        String inputData = this.scanner.nextLine();
        if (checkTextIsNumber(inputData)) {
            int inputNumber = Integer.parseInt(inputData);
            if ((inputNumber > 0) && (inputNumber < mainMenu.size() + 1)) {
                return inputNumber;
            } else {
                System.out.printf("\nВВЕДЕНО НЕДОПУСТИМОЕ ЧИСЛО. ВВЕДИТЕ ЗНАЧЕНИЕ ОТ 1 ДО %d\n", mainMenu.size());
                return 0;
            }
        } else {
            System.out.println(notDigitError);
            return 0;
        }
    }

    public int inputId() {
        System.out.println("\nВведите id игрушки для изменения ее веса: ");
        String inputId = this.scanner.nextLine();
        if (checkTextIsNumber(inputId)) {
            int intId = Integer.parseInt(inputId);
            if (intId <= 0) {
                System.out.println(digitPositiveInfoError);
                return -1;
            } else {
                return intId;
            }
        } else {
            System.out.println(notDigitError);
            return -1;
        }
    }

    public String inputName() {
        System.out.println("Введите имя игрушки: ");
        String inputName = this.scanner.nextLine();
        if ((inputName.length() == 0) && (inputName != null)) {
            System.out.println("ИМЯ ИГРУШКИ НЕ МОЖЕТ БЫТЬ ПУСТЫМ");
            return null;
        } else {
            return inputName;
        }
    }

    public int inputQuantity() {
        System.out.println("\nВведите количество игрушек: ");
        String inputQuantity = this.scanner.nextLine();
        if (checkTextIsNumber(inputQuantity)) {
            int intQuantity = Integer.parseInt(inputQuantity);
            if (intQuantity <= 0) {
                System.out.println(digitPositiveInfoError);
                return -1;
            } else {
                return intQuantity;
            }
        } else {
            System.out.println(notDigitError);
            return -1;
        }
    }

    public int inputWeight() {
        System.out.println("\nВведите вес (вероятность выпадения) игрушки от 1 до 100: ");
        String inputWeight = this.scanner.nextLine();
        if (checkTextIsNumber(inputWeight)) {
            int intWeight = Integer.parseInt(inputWeight);
            if ((intWeight <= 0) || (intWeight > 100)) {
                System.out.println("\nВВЕДЕННОЕ ЗНАЧЕНИЕ ДОЛЖНО БЫТЬ ПОЛОЖИТЕЛЬНЫМ ЦЕЛЫМ ЧИСЛОМ ОТ 1 ДО 100");
                return -1;
            } else {
                return intWeight;
            }
        } else {
            System.out.println(notDigitError);
            return -1;
        }
    }

    public void addToy() {
        System.out.println("\nДОБАВЛЕНИЕ ИГРУШКИ\n");
        String toyName = inputName();
        int toyQuantity = inputQuantity();
        int toyWeight = inputWeight();
        if ((toyName != null) && (toyQuantity != -1) && (toyWeight != -1)) {
            this.presenter.addToy(toyName, toyQuantity, toyWeight);
            System.out.println("\nИГРУШКА УСПЕШНО ДОБАВЛЕНА");
        } else {
            System.out.println("\nНЕ УДАЛОСЬ ДОБАВИТЬ ИГРУШКУ. ПОВТОРИТЕ ПОПЫТКУ");
        }

    }

    public void exit() {
        System.out.println("\nДО СВИДАНИЯ!");
        work = false;
    }

    private boolean checkTextIsNumber(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

}

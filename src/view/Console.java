package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import presenter.Presenter;

public class Console {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private List<String> menu;

    public Console() {
        this.scanner = new Scanner(System.in, "Cp866");
        this.work = true;
        this.menu = new ArrayList<>(Arrays.asList("Главное меню:",
                "Добавить игрушку",
                "Изменить игрушку",
                "Определить призовую игрушку",
                "Выдать призовую игрушку",
                "Выход"));
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void print(String text) {
        System.out.println(text);
    }

    public void start() {
        while (work) {
            System.out.println(menu());
            int key = input_menu();
            switch (key) {
                case 1:
                    addToy();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    exit();
                    break;
            }
        }

    }

   

    public int input_menu() {
        System.out.print("Выберите один из пунктов меню: ");
        String inputData = this.scanner.nextLine();
        if (checkTextIsNumber(inputData)) {
            int inputNumber = Integer.parseInt(inputData);
            int menu_size = menu.size();
            if ((inputNumber > 0) && (inputNumber < menu_size)) {
                return inputNumber;
            } else {
                System.out.printf("\nВведено недопустимое число. Введите значение от 1 до %d\n", menu_size - 1);
                return 0;
            }
        } else {
            System.out.println("\nВведенные данные не являются числом");
            return 0;
        }
    }

    public String input_name() {
        System.out.println("Введите имя игрушки: ");
        String input_name = this.scanner.nextLine();
        if ((input_name.length() == 0) && (input_name != null)) {
            System.out.println("Имя игрушки не может быть пустым");
            return null;
        } else {
            return input_name;
        }
    }
    
    public int input_quantity() {
        System.out.println("Введите количество игрушек: ");
        String input_quantity = this.scanner.nextLine();
        if (checkTextIsNumber(input_quantity)) {
            int int_quantity = Integer.parseInt(input_quantity);
            if (int_quantity <= 0) {
                System.out.println("Вводимое количество должно быть положительным целым числом");
                return -1;
            } else {
                return int_quantity;
            }
        } else {
            System.out.println("Введенные данные не являются числом");
            return -1;
        }
    }

    public int input_weight() {
            System.out.println("Введите вес игрушки: ");
            String input_weight = this.scanner.nextLine();
            if (checkTextIsNumber(input_weight)) {
                int int_weight = Integer.parseInt(input_weight);
                if ((int_weight <= 0) || (int_weight > 100)) {
                    System.out.println("Вес игрушки должно быть положительным целым числом от 1 до 100");
                    return -1;
                } else {
                    return int_weight;
                }
            }
            else {
                System.out.println("Введенные данные не являются числом");
                return -1;
            }        
    }

    public void addToy() {
        System.out.println("Добавление игрушки");
        String toy_name = input_name();
        int toy_quantity = input_quantity();
        int toy_weight = input_weight();
        if ((toy_name != null) && (toy_quantity != -1) && (toy_weight != -1)) {
            this.presenter.addToy(toy_name, toy_quantity, toy_weight);
            System.out.println("Игрушка успешно добавлена");
        }

    }
    
    public void exit() {
        System.out.println("\nДо свидания!");
        work = false;
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append(menu.get(0)).append("\n\n");
        for (int i = 1; i < menu.size(); i++) {
            stringBuilder.append(i).append(". ").append(menu.get(i)).append("\n");
        }
        return stringBuilder.toString();

    }
    
        private boolean checkTextIsNumber(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }

}

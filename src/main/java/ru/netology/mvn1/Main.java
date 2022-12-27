package ru.netology.mvn1;
public class Main {
    public static void main(String[] args) {
        BonusService service = new BonusService();
        long amount = 4_994_000;
        long bonus = service.calculate(amount, false);

        System.out.println(bonus);

    }
}
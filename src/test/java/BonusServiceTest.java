import org.junit.jupiter.api.Test;
import ru.netology.mvn1.BonusService;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test // Граничное значение: 0 Для зарегистрированных
    void shouldCalculateForRegisteredZeroBonus() {
        BonusService service = new BonusService();
        long amount = 3333;
        boolean registered = true;
        long expected = 0;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test // Граничное значение: 1 Для зарегистрированных
    void shouldCalculateForRegisteredOneBonus() {
        BonusService service = new BonusService();
        long amount = 3334;
        boolean registered = true;
        long expected = 1;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test // Граничное значение: 0 Для НЕ зарегистрированных
    void shouldCalculateForNoRegisteredZeroBonus() {
        BonusService service = new BonusService();
        long amount = 9999;
        boolean registered = false;
        long expected = 0;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test // Граничное значение: 1 Для НЕ зарегистрированных
    void shouldCalculateForNoRegisteredOneBonus() {
        BonusService service = new BonusService();
        long amount = 10000;
        boolean registered = false;
        long expected = 1;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test //Граничное значение: 499 Для зарегистрированных
    void shouldCalculateForRegisteredAroundMaxBonus() {
        BonusService service = new BonusService();
        long amount = 1_664_000;
        boolean registered = true;
        long expected = 499;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test //Граничное значение: 499 Для НЕ зарегистрированных
    void shouldCalculateForNoRegisteredAroundMaxBonus() {
        BonusService service = new BonusService();
        long amount = 4_994_000;
        boolean registered = false;
        long expected = 499;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}

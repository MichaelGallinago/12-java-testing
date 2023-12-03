import org.junit.Test;
import org.junit.Assert;

public class TestIntegerDecode {

    @Test
    public void testEmpty() {
        try {
            Integer.decode("");
            throw new Exception("Исключение отсутствует");
        } catch (Exception exception) {
            Assert.assertTrue("Тип исключения не является NumberFormatException", exception instanceof NumberFormatException);
            Assert.assertEquals("Выведено неправильное сообщение об исключении", "Zero length string", exception.getMessage());
        }
    }

    @Test
    public void plusTest() {
        Assert.assertEquals("Неправильно считано обыкновенное положительное число", 4, (long) Integer.decode("4"));
        Assert.assertEquals("Неправильно считано максимальное положительное число", Integer.MAX_VALUE, (long) Integer.decode(String.valueOf(Integer.MAX_VALUE)));
        Assert.assertEquals("Неправильно считан ноль со знаком +", 0, (long) Integer.decode("+0"));
    }

    @Test
    public void minusTest() {
        Assert.assertEquals("Неправильно считано отрицательное число", -4, (long) Integer.decode("-4"));
        Assert.assertEquals("Неправильно считан ноль со знаком -", 0, (long) Integer.decode("-0"));
        Assert.assertEquals("Неправильно считано минимальное отрицательное число", Integer.MIN_VALUE, (long) Integer.decode(String.valueOf(Integer.MIN_VALUE)));
    }

    @Test
    public void radixSpecifierTest16() {
        Assert.assertEquals("Неправильно считано число в 16-ой системе счисления с префиксом 0x", 68, (long) Integer.decode("0x44"));
        Assert.assertEquals("Неправильно считано число в 16-ой системе счисления с префиксом 0X", 68, (long) Integer.decode("0X44"));
        Assert.assertEquals("Неправильно считано число в 16-ой системе счисления с префиксом #", 68, (long) Integer.decode("#44"));
    }

    @Test
    public void radixSpecifierTest8() {
        Assert.assertEquals("Неправильно считано число в 8-ой системе счисления с префиксом 0x", 36, (long) Integer.decode("044"));
    }

    @Test
    public void signCharacterWrongPositionTest() {
        try {
            Integer.decode("--10");
            throw new Exception("Исключение отсутствует");
        } catch (Exception exception) {
            Assert.assertTrue("Тип исключения не является NumberFormatException", exception instanceof NumberFormatException);
            Assert.assertEquals("Выведено неправильное сообщение об исключении", "Sign character in wrong position", exception.getMessage());
        }
    }

    @Test
    public void numberFormatExceptionTest1() {
        checkNumberFormatException("error");
    }

    @Test
    public void numberFormatExceptionTest2() {
        checkNumberFormatException("23O567");
    }

    @Test
    public void numberFormatExceptionTest3() {
        checkNumberFormatException("-44444444444444444");
    }

    private void checkNumberFormatException(String value)
    {
        try {
            Integer.decode(value);
            throw new Exception("Исключение отсутствует");
        } catch (Exception exception) {
            Assert.assertTrue("Тип исключения не является NumberFormatException", exception instanceof NumberFormatException);
            Assert.assertEquals("Выведено неправильное сообщение об исключении", String.format("For input string: \"%s\"", value), exception.getMessage());
        }
    }
}
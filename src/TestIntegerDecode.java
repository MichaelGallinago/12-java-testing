import org.junit.Test;

public class TestIntegerDecode {

    @Test
    public void testEmpty() throws Exception {
        try {
            System.out.println(Integer.decode(""));
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Выдано правильное исключение NumberFormatException");
            return;
        }

        throw new Exception("Исключение отсутствует, или же не является NumberFormatException");
    }

    @Test
    public void plusTest() {
        System.out.println("2 + 2 = " + (2 + Integer.decode("+2")));
    }

    @Test
    public void minusTest() {
        System.out.println("4 - 2 = " + (4 + Integer.decode("-2")));
    }

    @Test
    public void radixSpecifierTest16() {
        System.out.println("0X10 = " + Integer.decode("0X10"));
        System.out.println("0x10 = " + Integer.decode("0x10"));
        System.out.println("#10 = " + Integer.decode("#10"));
    }

    @Test
    public void radixSpecifierTest8() {
        System.out.println("010 = " + Integer.decode("010"));
    }

    @Test
    public void signCharacterWrongPositionTest() throws Exception {
        try {
            System.out.println(Integer.decode("--10"));
        }
        catch (NumberFormatException exception) {
            System.out.println("Выдано правильное исключение NumberFormatException");
            return;
        }

        throw new Exception("Исключение отсутствует, или же не является NumberFormatException");
    }

    @Test
    public void numberFormatExceptionTest1() {
        String minValue = String.valueOf(Integer.MIN_VALUE);
        String maxValue = String.valueOf(Integer.MAX_VALUE);

        System.out.println(minValue + " = " + Integer.decode(minValue));
        System.out.println(maxValue + " = " + Integer.decode(maxValue));
    }

    @Test
    public void numberFormatExceptionTest2() throws Exception {
        try {
            System.out.println(Integer.decode("error"));
        }
        catch (NumberFormatException exception) {
            System.out.println("Выдано правильное исключение NumberFormatException");
            return;
        }

        throw new Exception("Исключение отсутствует, или же не является NumberFormatException");
    }
}
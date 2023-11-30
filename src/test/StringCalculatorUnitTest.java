import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorUnitTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void add_emptyString() throws Exception {
        int result = stringCalculator.add("");
        assertEquals(0, result);
    }

    @Test
    public void add_oneNumberString() throws Exception {
        int result = stringCalculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void add_twoNumberString() throws Exception {
        int result = stringCalculator.add("1,4");
        assertEquals(5, result);
    }


    @Test
    public void add_moreThanOneNumberString() throws Exception {
        int result = stringCalculator.add("1,4,7,17");
        assertEquals(29, result);
    }

    @Test
    public void add_stringWithSpaces() throws Exception {
        int result = stringCalculator.add("1\n2,3");
        assertEquals(6, result);
    }

    @Test
    public void add_stringWithDifferentDelimiters() throws Exception {
        int result = stringCalculator.add("//[;]\n1;2");
        assertEquals(3, result);
    }


    @Test
    public void add_assertThrowException(){

        assertThrows(Exception.class, () -> stringCalculator.add("1,-2,-3,4,-5"));
    }

    @Test
    public void add_stringWithBigInt() throws Exception {
        int result = stringCalculator.add("1001,2");
        assertEquals(2, result);
    }

    @Test
    public void add_differentDelimiters() throws Exception {
        int result = stringCalculator.add("//[|||]\n1|||2|||");
        assertEquals(3, result);
    }

    @Test
    public void add_allowMultipleDelimiters() throws Exception {
        int result = stringCalculator.add("//[|][%]\n1|2%3");
        assertEquals(6, result);
    }

    @Test
    public void add_MultipleDelimitersDifferentSizes() throws Exception {
        int result = stringCalculator.add("//[|||][%]\n1|||2%3");
        assertEquals(6, result);
    }











}

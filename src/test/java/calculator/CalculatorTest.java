package calculator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class CalculatorTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testCalculatorAskUserInput() {
        // given
        String userInput = "4 / 2";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        Calculator calculator = new Calculator();
        // when
        calculator.askUserInput();
        // then
        Assert.assertEquals("            CALCULATOR\r\n" +
                "Enter the operation according to the form:\r\n" +
                "[number] space [+, -, /, *, ^] space [number]\r\n", systemOutRule.getLog());
        Assert.assertEquals(4, calculator.getNum1());
        Assert.assertEquals('/', calculator.getOperator());
        Assert.assertEquals(2, calculator.getNum2());
    }

}

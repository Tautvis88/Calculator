package calculator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorTestParameterized {

    @Parameterized.Parameter()
    public int num1;

    @Parameterized.Parameter(1)
    public int num2;

    @Parameterized.Parameter(2)
    public char operator;

    @Parameterized.Parameter(3)
    public String answer;
    // create test data

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {{4,2,'+', "4 + 2 = 6\r\n"}, {4,2,'-',"4 - 2 = 2\r\n"},
                {4,2,'/', "4 / 2 = 2\r\n"}, {4,2,'*',"4 * 2 = 8\r\n"},
                {4,2,'^', "4 ^ 2 = 16\r\n"}, {4,2,'~',"There is no such operator.\r\n"}};
        return Arrays.asList(data);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testCalculate() {
        //given
        Calculator calculator = new Calculator();
        //when
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        calculator.setOperator(operator);
        calculator.calculate();
        //then
        Assert.assertEquals(answer, systemOutRule.getLog());
    }

}

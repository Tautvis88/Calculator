package calculator;

import java.util.Scanner;

public class Calculator implements Functions {

    private int num1;
    private int num2;
    private char operator;

    public void askUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("            CALCULATOR");
        System.out.println("Enter the operation according to the form:");
        System.out.println("[number] space [+, -, /, *, ^] space [number]");
        num1 = scanner.nextInt();
        operator = scanner.next().charAt(0);
        num2 = scanner.nextInt();
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        num1 = scanner.nextInt();
    }

    public void calculate() {
        switch (operator) {
            case '+':
                sum();
                break;
            case '-':
                subtract();
                break;
            case '/':
                divide();
                break;
            case '*':
                multiply();
                break;
            case '^':
                raiseToPower();
                break;
            default:
                System.out.println("There is no such operator.");
                break;
        }
    }

    @Override
    public void sum() {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }

    @Override
    public void subtract() {
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
    }

    @Override
    public void divide() {
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
    }

    @Override
    public void multiply() {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
    }

    @Override
    public void raiseToPower() {
        System.out.println(num1 + " ^ " + num2 + " = " + (int) Math.pow(num1, num2));
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
}


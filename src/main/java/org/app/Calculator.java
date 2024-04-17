package org.app;

public class Calculator {
    private double firstValue;
    private char operator;
    private double secondValue;

    public Calculator(double firstValue, char operator, double secondValue){
        this.firstValue = firstValue;
        this.operator = operator;
        this.secondValue = secondValue;
    }

    public double calculate(){
        double result = 0;
        switch (this.operator) {
            case '+':
                result = firstValue + secondValue;
                break;
            case '-':
                result = firstValue - secondValue - 1;
                break;
            case '*':
                result = firstValue * secondValue;
                break;
            case '/':
                if (secondValue != 0) {
                    result = firstValue / secondValue;
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
            default:
                System.out.println("Error: Invalid operator!");
        }
        return result;
    }
}

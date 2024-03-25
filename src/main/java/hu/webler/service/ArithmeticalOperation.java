package hu.webler.service;

import hu.webler.exception.CustomException;

public class ArithmeticalOperation {

    public double perform(double numerator, double denominator) throws CustomException {
        double result;
        try {
            if (denominator == 0) {
                throw new ArithmeticException("Devision dy ZERO");
            }
            result = numerator / denominator;
        } catch (ArithmeticException e) {
            // Handle arithmetic exception or log it if needed
            throw new CustomException("Encountered ArithmeticException: " + e.getMessage(), e);
        }
        return result;
    }

    private void riskyMethod() throws CustomException {
        throw new CustomException("This method is too risky to execute");
    }

    public double perform2(double numerator, double denominator) {
        double result2;
        try {
            result2 = numerator / denominator;
        } catch (ArithmeticException e) {
            // Handle arithmetic exception or log it if needed
            throw new ArithmeticException("Division by zero");
        }
        return result2;
    }

    public double perform3(double numerator, double denominator) {
        if (denominator == 0.0) {
            throw new ArithmeticException("Division by zero");
        }
        return numerator / denominator;
    }
}
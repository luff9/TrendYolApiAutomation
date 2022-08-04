package utils;

import model.MathOperation;

import java.util.ArrayList;


public class MathUtil {

    public static Integer getResult(ArrayList<Integer> params, MathOperation operation) {
        switch (operation.name()) {
            case "add":
                return addition(params);
            case "subtraction":
                return subtraction(params);
            case "multiplication":
                return multiplication(params);
            case "division":
                return division(params);
            case "sum":
                return sum(params);
            default:
                return null;

        }
    }


    private static Integer sum(ArrayList<Integer> params) {
        int number = params.get(0);
        return (number * (number + 1)) / 2;
    }

    private static Integer division(ArrayList<Integer> params) {
        int number1 = params.get(0);
        int number2 = params.get(1);
        return number1 / number2;
    }


    private static Integer multiplication(ArrayList<Integer> params) {
        int result = params.get(0);
        int number = params.size();
        for (int i = 1; i < number; i++) {
            result = result * params.get(i);
        }
        return result;
    }

    private static Integer subtraction(ArrayList<Integer> params) {
        int number1 = params.get(0);
        int number2 = params.get(1);
        return number1 - number2;
    }

    private static Integer addition(ArrayList<Integer> params) {
        int result = 0;
        int number = params.size();
        for (int i = 0; i < number; i++) {
            result = result + params.get(i);
        }
        return result;
    }


}

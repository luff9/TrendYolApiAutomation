package data;

import io.restassured.http.Method;
import model.MathOperation;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    @DataProvider(name = "validUsernameAndPassword")
    public static Object[][] getValidUserList() {
        return new Object[][]{
                {"username1", "password1"}
                , {"username2", "password2"}
        };
    }

    @DataProvider(name = "invalidUsernameAndPassword")
    public static Object[][] getInvalidUserList() {
        return new Object[][]{
                {"invalid username1", "invalid password1"}
                , {"invalid username2", "invalid password2"}
        };
    }


    @DataProvider(name = "validMathOperation")
    public static Object[][] validMathOperation() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1, 25)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(451, 2, 344)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(1, 52, 3, 445)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(14, 2, 43, 4, 234)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(-641, 0, -3, 4, 78)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(1, 2)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(1, 42, 3)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(1, -82, 3, 64)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(21, 2, -3, 94, 456)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(41, -62, 63, 4, -89)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(71, 0)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(461, -2)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(-16, 245)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(123, 2092)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(234, 3)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(34567, -24)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(-1123, 90)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(345, 56)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(-1, -25)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(-451, -2, -344)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(-1, -52, -3, -445)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(-14, -2, -43, -4, -234)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(641, 0, 3, -4, -78)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(-1, -2)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(-1, -42, -3)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(-1, -82, -3, -64)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(-21, -2, 3, -94, -456)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(-41, 62, -63, -4, 89)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(-71, 0)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(-461, 2)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(16, -245)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(-123, -2092)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(-234, -3)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(-34567, 24)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(1123, -90)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(-345, -56)), MathOperation.DIVISION}
        };
    }

    @DataProvider(name = "invalidMathOperation")
    public static Object[][] invalidMathOperation() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1, 25, 3, 4, 5, 5)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(1, "25", 3, 4)), MathOperation.ADD}
                , {new ArrayList<>(List.of(1)), MathOperation.ADD}
                , {new ArrayList<>(Arrays.asList(1, 2, 63, 24, 34, 6)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(1, 2, "63")), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(List.of(1)), MathOperation.MULTIPLICATION}
                , {new ArrayList<>(Arrays.asList(123, 2092, 4, 45, 6, 345, 567)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(123, 2092, 4, "45")), MathOperation.SUBTRACTION}
                , {new ArrayList<>(List.of(123)), MathOperation.SUBTRACTION}
                , {new ArrayList<>(Arrays.asList(345, 56, 5, 7, 6, 4, 5)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(4, "5")), MathOperation.DIVISION}
                , {new ArrayList<>(List.of(4)), MathOperation.DIVISION}
                , {new ArrayList<>(Arrays.asList(1, 0)), MathOperation.DIVISION}
        };
    }

    public static Object[][] validSumOperation() {
        return new Object[][]{
                {new ArrayList<>(List.of(4)), MathOperation.SUM}
                , {new ArrayList<>(List.of(9)), MathOperation.SUM}
                , {new ArrayList<>(List.of(15)), MathOperation.SUM}
                , {new ArrayList<>(List.of(546)), MathOperation.SUM}
        };
    }

    public static Object[][] invalidSumOperation() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(4, 5)), MathOperation.SUM}
                , {new ArrayList<>(List.of(-9)), MathOperation.SUM}
                , {new ArrayList<>(Arrays.asList(155, 4, 6, 2, 56, 2, 4, 3)), MathOperation.SUM}
                , {new ArrayList<>(Arrays.asList(546, 54, 6, 2, 43, 6)), MathOperation.SUM}
                , {new ArrayList<>(Arrays.asList("546", "54", "invalid", "test", "random", "string")), MathOperation.SUM}
        };
    }

    public static Object[][] invalidRequestTypeForMathOperation() {
        return new Object[][]{
                {Method.GET}
                , {Method.PUT}
                , {Method.DELETE}
                , {Method.HEAD}
                , {Method.TRACE}
                , {Method.OPTIONS}
                , {Method.PATCH}
        };
    }

    public static Object[][] invalidRequestTypeForSumOperation() {
        return new Object[][]{
                {Method.POST}
                , {Method.PUT}
                , {Method.DELETE}
                , {Method.HEAD}
                , {Method.TRACE}
                , {Method.OPTIONS}
                , {Method.PATCH}
        };
    }

    private static Object[][] mergeData(Object[][] list1, Object[][] list2) {
        int d1Size = list1.length * list2.length;
        int d2Size = list1[0].length + list2[0].length;

        Object[][] ret1 = new Object[d1Size][d2Size];
        int d1Index = 0;
        int d2Index = 0;
        for (Object[] item1 : list1) {
            for (Object[] item2 : list2) {
                for (Object o1 : item1) {
                    ret1[d1Index][d2Index] = o1;
                    d2Index++;
                }
                for (Object o2 : item2) {
                    ret1[d1Index][d2Index] = o2;
                    d2Index++;
                }
                d1Index++;
                d2Index = 0;
            }
        }
        return ret1;
    }

    @DataProvider(name = "mathOperationSuccess")
    public static Object[][] mathOperationSuccess() {
        return mergeData(getValidUserList(), validMathOperation());
    }

    @DataProvider(name = "mathOperationFail")
    public static Object[][] mathOperationFail() {
        return mergeData(getValidUserList(), invalidMathOperation());
    }

    @DataProvider(name = "mathOperationFailWithWrongRequestType")
    public static Object[][] mathOperationFailWithWrongRequestType() {
        return mergeData(mergeData(getValidUserList(), validMathOperation()), invalidRequestTypeForMathOperation());
    }

    @DataProvider(name = "sumOperationFailWithWrongRequestType")
    public static Object[][] sumOperationFailWithWrongRequestType() {
        return mergeData(mergeData(getValidUserList(), validSumOperation()), invalidRequestTypeForSumOperation());
    }

    @DataProvider(name = "sumOperationSuccess")
    public static Object[][] sumOperationSuccess() {
        return mergeData(getValidUserList(), validSumOperation());
    }

    @DataProvider(name = "sumOperationFail")
    public static Object[][] sumOperationFail() {
        return mergeData(getValidUserList(), invalidSumOperation());
    }

}

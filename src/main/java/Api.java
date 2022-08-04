import model.MathOperation;

public class Api {
    //TODO Update BASE_URL when the api ready;
    public static final String BASE_URL = "";
    public static final String ADD_URL = BASE_URL + "/add";
    public static final String MULTIPLICATION_URL = BASE_URL + "/multiplication";
    public static final String DIVISION_URL = BASE_URL + "/division";
    public static final String SUBTRACTION_URL = BASE_URL + "/subtraction";
    public static final String SUM_URL = BASE_URL + "/sum";
    public static final String LOGIN_URL = BASE_URL + "/login";

    public static String setUrl(MathOperation operation) {
        switch (operation.name()) {
            case "add":
                return ADD_URL;
            case "subtraction":
                return SUBTRACTION_URL;
            case "multiplication":
                return MULTIPLICATION_URL;
            case "division":
                return DIVISION_URL;
            case "sum":
                return SUM_URL;
            default:
                return null;

        }
    }
}

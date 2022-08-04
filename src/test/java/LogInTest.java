import data.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest {


    public static Headers getHeaders(String username, String password) {
        Response response = RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .when()
                .post(Api.LOGIN_URL);
        return response.getHeaders();
    }

    @Test(dataProvider = "validUsernameAndPassword", dataProviderClass = TestData.class)
    @DisplayName("Login should be successful with valid credentials")
    public void loginSuccess(String username, String password) {
        RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .when()
                .post(Api.LOGIN_URL)
                .then()
                .statusCode(HttpStatus.SC_OK);

    }


    @Test(dataProvider = "invalidUsernameAndPassword", dataProviderClass = TestData.class)
    @DisplayName("Login should be fail with invalid credentials")
    public void loginFail(String username, String password) {
        RestAssured
                .given()
                .auth()
                .preemptive()
                .basic(username, password)
                .contentType(ContentType.JSON)
                .when()
                .post(Api.LOGIN_URL)
                .then()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test(dataProvider = "validUsernameAndPassword", dataProviderClass = TestData.class)
    @DisplayName("Login should return header that has username and password")
    public void headerHasUsernameAndPassword(String username, String password) {
        Headers headers = getHeaders(username, password);
        String user = headers.getValue("username");
        String userPass = headers.getValue("password");
        Assert.assertFalse(user.isEmpty());
        Assert.assertFalse(userPass.isEmpty());
    }

}

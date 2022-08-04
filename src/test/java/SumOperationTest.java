import data.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.MathOperation;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.MathUtil;

import java.util.ArrayList;

public class SumOperationTest {


    @Test(dataProvider = "sumOperationSuccess", dataProviderClass = TestData.class)
    @DisplayName("Sum operation should be successful with valid credentials & params")
    public void sumOperationSuccess(String username, String password, ArrayList<Integer> params, MathOperation operation) {
        Headers headers = LogInTest.getHeaders(username, password);
        Response response = RestAssured
                .given()
                .headers(headers)
                .param("params", params)
                .contentType(ContentType.JSON)
                .when()
                .get(Api.setUrl(operation));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        Integer result = MathUtil.getResult(params, operation);

        JsonPath jsnPath = response
                .getBody()
                .jsonPath();
        Integer responseResult = jsnPath.get("result");
        Assert.assertEquals(responseResult, result);
    }

    @Test(dataProvider = "sumOperationFail", dataProviderClass = TestData.class)
    @DisplayName("Sum operation should return bad request with invalid params")
    public void sumOperationFailWithWrongParameters(String username, String password, ArrayList<Integer> params, MathOperation operation) {
        Headers headers = LogInTest.getHeaders(username, password);
        Response response = RestAssured
                .given()
                .headers(headers)
                .param("params", params)
                .contentType(ContentType.JSON)
                .when()
                .post(Api.setUrl(operation));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }


    @Test(dataProvider = "sumOperationFailWithWrongRequestType", dataProviderClass = TestData.class)
    @DisplayName("Sum operation should return bad request with invalid request type")
    public void sumOperationFailWithWrongRequestType(String username, String password, ArrayList<Integer> params, MathOperation operation, Method method) {
        Headers headers = LogInTest.getHeaders(username, password);
        Response response = RestAssured
                .given()
                .headers(headers)
                .param("params", params)
                .contentType(ContentType.JSON)
                .when()
                .request(method, Api.setUrl(operation));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }


    @Test(dataProvider = "sumOperationSuccess", dataProviderClass = TestData.class)
    @DisplayName("Sum operation should return bad request with invalid header")
    public void sumOperationWrongHeaderFail(String username, String password, ArrayList<Integer> params, MathOperation operation) {
        Headers headers = LogInTest.getHeaders(username, password);
        Response response = RestAssured
                .given()
                .headers(headers)
                .header("username", "invalid username")
                .header("password", "invalid password")
                .param("params", params)
                .contentType(ContentType.JSON)
                .when()
                .post(Api.setUrl(operation));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }

}

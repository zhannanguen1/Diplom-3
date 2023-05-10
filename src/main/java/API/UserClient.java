package API;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserClient {

    private final static String API_AUTH_LOGIN = "/api/auth/login";
    private final static String API_AUTH_USER = "/api/auth/user";

    public UserClient() {
    }

    @Step("Создание юзера")
    public static Response postApiAuthLogin(LoginUser loginUser) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(loginUser)
                .when()
                .post(API_AUTH_LOGIN);
    }

    @Step("Удаление юзера")
    public static Response deleteApiAuthUser(String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .header("authorization", accessToken)
                .when()
                .delete(API_AUTH_USER);
    }

}

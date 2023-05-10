package API;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserClient {

    private final static String API_AUTH_LOGIN = "/api/auth/login";
    private final static String API_AUTH_USER = "/api/auth/user";

    public UserClient() {
    }

    public static Response postApiAuthLogin(LoginUser loginUser) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(loginUser)
                .when()
                .post(API_AUTH_LOGIN);
    }

    public static Response deleteApiAuthUser(String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .header("authorization", accessToken)
                .when()
                .delete(API_AUTH_USER);
    }

}

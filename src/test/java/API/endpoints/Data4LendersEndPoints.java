package API.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Data4LendersEndPoints extends Routes{

    public static Response GetOptions()
    {
        Response response = given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_options);
        return response;
    }

    public static Response GetUsers()
    {
        Response response = given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_users);
        return response;
    }
}

package API.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OperationalServicesEndpoints extends Routes{

    public static Response GetAdutorPricing()
    {
        Response response = given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_AdjutorPricing);
        return response;
    }

    public static Response GetWallet()
    {
        Response response = given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_wallet);
        return response;
    }

    public static Response GetBankList()
    {
        Response response = given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_BankList);
        return response;
    }
}

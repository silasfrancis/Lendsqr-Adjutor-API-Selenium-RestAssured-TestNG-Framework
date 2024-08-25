package API.endpoints;

import API.payload.Loans;
import API.payload.Payment;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class EmbeddedLoansAndPaymentsEndpoints extends Routes {

    public static Response GetLoanProducts() {
        Response response = given()
                .header("Authorization", ApiKey)

                .when()
                .get(get_loanProducts);
        return response;
    }

    public static Response InitializeLoanApp(JSONObject payload)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .header("Authorization", ApiKey)

                .when()
                .post(post_initializeLoanApplication);
        return response;
    }

    public static Response GetLoan(String reference)
    {
        Response response = given()
                .header("Authorization", ApiKey)
                .pathParam("reference", reference)

                .when()
                .get(get_loan);
        return response;
    }

    public static Response InitializePayment(Payment payload)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .header("Authorization", ApiKey)

                .when()
                .post(post_initailizePayment);
        return response;
    }

    public static Response QueryPayment(String reference)
    {
        Response response = given()
                .header("Authorization", ApiKey)
                .pathParam("reference", reference)

                .when()
                .get(get_QueryPayment);
        return response;
    }

}

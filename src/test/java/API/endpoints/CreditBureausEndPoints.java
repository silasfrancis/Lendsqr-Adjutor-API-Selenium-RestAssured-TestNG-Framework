package API.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreditBureausEndPoints extends Routes{

    public static Response GetCRCReport(String bvn)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", ApiKey)
                .pathParam("bvn", bvn)

                .when()
                .get(get_creditReportCRC);
        return response;
    }

    public static Response GetFirstCentralReport(String bvn)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", ApiKey)
                .pathParam("bvn", bvn)

                .when()
                .get(get_creditReportFirstCentral);
        return response;
    }
}

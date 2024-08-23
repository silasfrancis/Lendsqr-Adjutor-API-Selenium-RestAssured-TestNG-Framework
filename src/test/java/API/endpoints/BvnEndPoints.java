package API.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

public class BvnEndPoints extends Routes{

    public static Response InitializeBVN(HashMap contact, String bvn)
    {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(contact)
                .header("Authorization", ApiKey)
                .pathParam("bvn", bvn)

                .when()
                .post(post_initailzie_bvn);
        return response;
    }

    public static Response getBVNDetails(HashMap otp, String bvn)
    {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(otp)
                .header("Authorization", ApiKey)
                .pathParam("bvn", bvn)

                .when()
                .put(put_getBvndetails);
        return response;
    }

    public static Response InitializeBVNAccounts(HashMap contact, String bvn)
    {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(contact)
                .header("Authorization", ApiKey)
                .pathParam("bvn", bvn)

                .when()
                .post(post_initalize_bvnAccounts);
        return response;

    }
}

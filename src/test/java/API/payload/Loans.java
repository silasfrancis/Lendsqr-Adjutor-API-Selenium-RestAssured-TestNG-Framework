package API.payload;

import API.testCases.BaseClass;
import com.github.javafaker.Faker;
import org.json.JSONObject;

public class Loans {
    public static JSONObject data = new JSONObject();
    public static BaseClass base = new BaseClass();

    String product_id;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    String reference;


    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public static void Data(JSONObject data)
    {
        Loans loans = new Loans();
        Faker faker = new Faker();

        Loans.data = data;
        data.put("product_id", loans.getProduct_id());

        JSONObject meta = new JSONObject();
        meta.put("email", faker.internet().emailAddress());
        meta.put("phone_number", "080"+ base.randomNumber(8));
        data.put("meta", meta);
    }




}

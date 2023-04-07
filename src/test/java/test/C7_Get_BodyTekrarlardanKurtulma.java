package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C7_Get_BodyTekrarlardanKurtulma {

    /*
    https://restful-booker.herokuapp.com/booking/150 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Jake",
                    ve "lastname“in, "Smith",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in, true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
     */

    @Test
    public void get01(){

        // 1- URL ve Body hazirla
        String url="https://restful-booker.herokuapp.com/booking/150";

        // 2- Expected data hazirla

        // 3- Response'i kaydet

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Josh"),
                        "lastname",Matchers.equalTo("Allen"),
                        "totalprice",Matchers.equalTo(111),
                        "depositpaid",Matchers.equalTo(true),
                        "additionalneeds",Matchers.equalTo("super bowls")
                );



    }

}

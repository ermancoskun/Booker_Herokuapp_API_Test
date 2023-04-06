package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C2_Get_ResponseBilgileriAssertion {

    /*
    https://restful-booker.herokuapp.com/booking/850 url’ine bir GET request
        gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin.
     */

    @Test
    public void get01() {

        // 1- Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
        // 2- Eger soruda verilmisse Expected Data hazirla
        // 3- Bize donen Response'i Actual Data olarak kaydet
        // 4- Expected Data ile Actual Data'yi karsilastir yani Assertion yapmamiz gerek

        // 1- Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
        String url = "https://restful-booker.herokuapp.com/booking/850";

        // 2- Eger soruda verilmisse Expected Data hazirla

        // 3- Bize donen Response'i Actual Data olarak kaydet
        Response response = given().when().get(url);
        // System.out.println(response);
        response.prettyPrint();

        // 4- Expected Data ile Actual Data'yi karsilastir yani Assertion yapmamiz gerek

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");


    }
}

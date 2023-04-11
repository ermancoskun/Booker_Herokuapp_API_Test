package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class C16_BaseUrlHerokuapp extends HerokuAppBaseUrl {

    /*
        Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

        1- https://restful booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        Response’ta 12 booking oldugunu test edin

        2- https://restful booker.herokuapp.com/booking
        endpointine asagidaki body’ye sahip bir POST
        request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “firstname”
        degerinin “Ahmet” oldugunu test edin
        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021 06 01",
            "checkout" : "2021 06 10"
            },
        "additionalneeds" : "wi-fi"
        }
     */

    @Test
    public void get01(){

        /*
        1- https://restful booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        Response’ta 12 booking oldugunu test edin
         */

        // 1- Url hazirla (Path parametreleri)

        specHerokuApp.pathParam("pp1","booking");

        // 2- Expected data hazirla

        // 3- Response'i kaydet

        Response response= given().spec(specHerokuApp).when().get("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat().statusCode(200)
                .body("bookingid", Matchers.greaterThanOrEqualTo(1));

    }

    @Test
    public void post01(){

        /*
        2- https://restful booker.herokuapp.com/booking
        endpointine asagidaki body’ye sahip bir POST
        request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “firstname”
        degerinin “Ahmet” oldugunu test edin

        Request Body

        {
        "firstname" : "Ahmet",
        "lastname" : “Bulut",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }
         */

        // 1- Url hazirla (Path parametreleri)

        specHerokuApp.pathParam("pp1","booking");

        JSONObject bookingdates= new JSONObject();

        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject reqBody=new JSONObject();

        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" , bookingdates);
        reqBody.put("additionalneeds" , "wi-fi");

        // 2- Expected data hazirla

        // 3- Response'i kaydet

        Response response= given().spec(specHerokuApp).when().post("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        JsonPath respJS= response.jsonPath();

        response.then().assertThat().statusCode(200).body("firstname",Matchers.equalTo("firstname"));
    }

}

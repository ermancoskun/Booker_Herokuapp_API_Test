package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuApp;

import static io.restassured.RestAssured.given;

public class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip
    bir POST request gonderdigimizde donen response’un status kodunu ve id haric
    body'sinin asagidaki gibi oldugunu test edin.
    Request body
          {
          "firstname" : "Ali",
          "lastname" : “Bak",
          "totalprice" : 500,
          "depositpaid" : false,
          "bookingdates" : {
                      "checkin" : "2021-06-01",
                      "checkout" : "2021-06-10"
                        },
          "additionalneeds" : "wi-fi"
           }
    Expected Body
    {
    "bookingid":24,
    "booking":{
            "firstname":"Ali",
            "lastname":"Bak",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                            },
            "additionalneeds":"wi-fi"
               }
    }
     */

    @Test
    public void post01(){

        // 1- Url Hazirla

        specHerokuApp.pathParam("pp1","booking");

        TestDataHerokuApp testDataHerokuApp=new TestDataHerokuApp();

        JSONObject reqBody= testDataHerokuApp.reqBodyJson();

        // 2- Expected data hazirla

        JSONObject expBody=testDataHerokuApp.expBodyJson();

        // 3- Response kaydet

        Response response= given()
                .spec(specHerokuApp)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        JsonPath resJP=response.jsonPath();

        Assert.assertEquals(testDataHerokuApp.basarilistatusCode,response.getStatusCode());
        Assert.assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        Assert.assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                resJP.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));



    }
}

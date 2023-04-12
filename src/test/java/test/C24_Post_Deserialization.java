package test;

import baseURL.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuApp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C24_Post_Deserialization extends HerokuAppBaseUrl {

    /*
      https://restful-booker.herokuapp.com/booking url'ine asagidaki
      body'ye sahip bir POST request gonderdigimizde donen response'un
      id haric asagidaki gibi oldugunu test edin.
        Request body
   {
        "firstname" : "Ali",
        "lastname" : "Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                 "checkin" : "2021-06-01",
                 "checkout" : "2021-06-10"
                          },
        "additionalneeds" : "wi-fi"
    }
       Response Body
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

        // 1- Url ve body hazirla

        specHerokuApp.pathParam("pp1","booking");

        TestDataHerokuApp testDataHerokuApp=new TestDataHerokuApp();

        HashMap<String,Object> reqBody= testDataHerokuApp.reqBodyMap();

        // 2- Expected data hazirla

        HashMap<String,Object> expBody=testDataHerokuApp.expBodyMap();

        // 3- Response hazirla

        Response response= given()
                                .spec(specHerokuApp).contentType(ContentType.JSON)
                            .when()
                                .body(reqBody)
                                .post("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        HashMap<String,Object> resMap= response.as(HashMap.class);

        Assert.assertEquals(((Map)(expBody.get("booking"))).get("firstname") , ((Map)(resMap.get("booking"))).get("firstname"));
        Assert.assertEquals(((Map)(expBody.get("booking"))).get("lastname") , ((Map)(resMap.get("booking"))).get("lastname"));
        Assert.assertEquals(((Map)(expBody.get("booking"))).get("totalprice") , ((Map)(resMap.get("booking"))).get("totalprice"));
        Assert.assertEquals(((Map)(expBody.get("booking"))).get("depositpaid") , ((Map)(resMap.get("booking"))).get("depositpaid"));
        Assert.assertEquals(((Map)(expBody.get("booking"))).get("additionalneeds") , ((Map)(resMap.get("booking"))).get("additionalneeds"));
        Assert.assertEquals(((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkin") ,
                                     ((Map)(((Map)(resMap.get("booking"))).get("bookingdates"))).get("checkin"));
        Assert.assertEquals(((Map)(((Map)(expBody.get("booking"))).get("bookingdates"))).get("checkout") ,
                                    ((Map)(((Map)(resMap.get("booking"))).get("bookingdates"))).get("checkout"));

    }

}

package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseURL {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */

    @Test
    public void put01() {

        // 1- Url ve body hazirla

        specJsonPlace.pathParams("pp1", "posts", "pp2", 70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder = new TestDataJsonPlaceHolder();

        HashMap<String, Object> reqBody = testDataJsonPlaceHolder.reqBodyOlusturMap();

        // 2- Expected data hazirla

        HashMap<String, Object> expBody = testDataJsonPlaceHolder.reqBodyOlusturMap();

        // 3- Response kaydet

        Response response = given()
                .spec(specJsonPlace).contentType(ContentType.JSON)
                .when()
                .body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Assertion

        HashMap<String, Object> respMap =response.as(HashMap.class); // Bu adimda de-serialization islemini gerceklestirdik

        Assert.assertEquals(testDataJsonPlaceHolder.basarilistatusCode,response.getStatusCode());
        Assert.assertEquals(expBody.get("id"),respMap.get("id"));
        Assert.assertEquals(expBody.get("body"),respMap.get("body"));
        Assert.assertEquals(expBody.get("userId"),respMap.get("userId"));
        Assert.assertEquals(expBody.get("title"),respMap.get("title"));

    }
}

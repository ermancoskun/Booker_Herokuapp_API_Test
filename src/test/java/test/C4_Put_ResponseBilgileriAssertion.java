package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C4_Put_ResponseBilgileriAssertion {

    /*
    https://jsonplaceholder.typicode.com
    /posts/100 url’ine asagidaki Json formatindaki body ile
    bir PUT request gonderdigimizde
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 100

    }
     */

    @Test
    public void put01(){

        // 1- URL ve Body hazirla

        String url="https://jsonplaceholder.typicode.com/posts/100";

        JSONObject reqBody= new JSONObject();

        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userID",10);
        reqBody.put("id",100);

        System.out.println("reqBody = " + reqBody);

        // 2- Expected data hazirla

        // 3- Response'i kaydet

        Response response = given().
                                contentType(ContentType.JSON).
                            when().
                                body(reqBody.toString()).
                                put(url);


        response.prettyPrint();

        // 4- Assertion

        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");
    }

}

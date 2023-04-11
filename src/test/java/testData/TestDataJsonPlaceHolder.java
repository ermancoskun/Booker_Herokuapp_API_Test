package testData;

import org.json.JSONObject;

public class TestDataJsonPlaceHolder {

    public int basarilistatusCode=200;

    public JSONObject expectedBodyOlusturJson(){

        /*
        Response body : {=Expected data}
            {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
            um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
            }
         */

        JSONObject expBody= new JSONObject();

        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expBody;
    }

    public JSONObject requestBodyOlusturJson(){

        /*
        Request Body
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId": 10,
            "id":70
           }
         */
        JSONObject reqBody=new JSONObject();

        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);

        return  reqBody;
    }


}

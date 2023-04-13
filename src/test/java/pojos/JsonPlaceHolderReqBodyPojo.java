package pojos;

public class JsonPlaceHolderReqBodyPojo {

    /*
    Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    // 1- Tum Key degerlerini Class levelda aldiklari Data turune gore private variable olarak olusturalim

    private String title;
    private String body;
    private int userId ;
    private int id;

    // 2- Tum variable'lar icin getter() - setter() 'lari olusturalim


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // 3- Tum variable'lari iceren parametreli bir constructor olusturalim


    public JsonPlaceHolderReqBodyPojo(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4- Parametreli Constructor'i olusturdugum icin bir tane de parametresiz constructor olusturalim


    public JsonPlaceHolderReqBodyPojo() {
    }

    // 5- toString() olusturuyorum


    @Override
    public String toString() {
        return "JsonPlaceHolderReqBodyPojo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}

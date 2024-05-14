package lesson1.token;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class TryWithTokenClass {
    public static void main(String[] args) {
        RestAssured.baseURI="https://simple-books-api.glitch.me/";
        Random random = new Random();
        String randomMail = "mail"+ random.nextInt(1000)+ "mail" + random.nextInt(1000)+"@jsaedf.com";
       // System.out.println(randomMail);

        JSONObject registerBody = new JSONObject();
        registerBody.put("clientName", "Hakan");
        registerBody.put("clientEmail", randomMail);

        //Регистрация пользователя

        Response response = given()
                .contentType(ContentType.JSON)
                .body(registerBody)
                .when()
                .post("api-clients/");
        //System.out.println(response.getBody().asString());
    String token = JsonParser.parseString(response.getBody().asString()).getAsJsonObject().get("accessToken").getAsString();
        System.out.println(token);


        //заказ книг
        JSONObject orderBody = new JSONObject();
        orderBody.put("bookId", 1);
        orderBody.put("customerName", "Hakan");

        JSONObject orderBody2 = new JSONObject();
        orderBody2.put("bookId", 4);
        orderBody2.put("customerName", "Hakan");
        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody)
                .when()
                .post("orders");
        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody2)
                .when()
                .post("orders");


        //получить список заказов
        Response response1 = given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(orderBody)
                .when()
                .get("orders");

        System.out.println(response1.getBody().asString());

        JsonArray arrayOfOrders = JsonParser.parseString(response1.getBody().asString()).getAsJsonArray();
        System.out.println(arrayOfOrders.size());
        for (JsonElement order: arrayOfOrders){

            System.out.println( order.getAsJsonObject().get("id").getAsString());
        }


    }
}

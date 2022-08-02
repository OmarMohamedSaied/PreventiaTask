package apiTest;

import api.UserRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {
    String BaseUrl = "https://petstore.swagger.io/v2/";
    JsonPath jsonPath = new JsonPath(UserRequest.UserDetails());

    @BeforeMethod
    public void Setup(){
        RestAssured.baseURI=BaseUrl;
    }
    @Test
    public void CreateNewUser() {
        String response = given()
                .header("Content-Type","application/json")
                .body(UserRequest.UserDetails())
                .when().post("user").then().assertThat().body("code",equalTo(200)).
                extract().response().asString();

        String usernameValue = jsonPath.getString("username");

        System.out.println(response);
        System.out.println(usernameValue);
    }

    @Test(dependsOnMethods = {"CreateNewUser"})
    public void getUser(){

        String response = given().relaxedHTTPSValidation()
                .pathParam("username",jsonPath.getString("username"))
                .when().get("user/{username}")
                .then().assertThat().body("firstname",equalTo(jsonPath.getString("firstname")))
                .statusCode(200).extract().response().asString();

        System.out.println(response);
    }

    @Test(dependsOnMethods = {"CreateNewUser"}, dataProvider = "deleteDataProvider")
    public void DeleteUser(String username , int StatusCode){
        String response =given()
                .pathParam("username",jsonPath.getString("username"))
                .when().delete("user/{username}")
                .then().assertThat().body("message",equalTo(username))
                .statusCode(StatusCode).extract().response().asString();

        System.out.println(response);
    }
    @DataProvider(name = "deleteDataProvider")
    public Object[][] DeleteUserNotFound(){
        Object [][] data = new Object[2][2];
        data[0][0] = "OmarM";
        data[0][1] = 200;
        data[1][0] = "OmarM";
        data[1][1] = 404;
        return data;
    }


}

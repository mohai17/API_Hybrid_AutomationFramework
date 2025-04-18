package api.endpoints;

import api.payload.UserPayloads;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndpoints {

    public static Response createUser(UserPayloads userPayloads){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(userPayloads)
                .when()
                .post(Routes.create_url);

        return response;
    }

    public static Response readUser(String username){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username",username)
                .when()
                .get(Routes.read_url);

        return response;
    }

    public static Response updateUser(String username, UserPayloads userPayloads){

            Response response = given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .pathParams("username",username)
                    .body(userPayloads)
                    .when()
                    .put(Routes.update_url);

            return response;


    }

    public static Response deleteUser(String username){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParams("username",username)
                .when()
                .delete(Routes.delete_url);

        return response;

    }

}

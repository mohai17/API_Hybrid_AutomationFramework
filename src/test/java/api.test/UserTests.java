package api.test;

import api.endpoints.UserEndpoints;
import api.payload.UserPayloads;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    UserPayloads userPayloads;

    @BeforeClass
    public void setup(){

        faker = new Faker();
        userPayloads = new UserPayloads();

        userPayloads.setId(faker.idNumber().hashCode());
        userPayloads.setUsername(faker.name().username());
        userPayloads.setPassword(faker.internet().password(5,10));
        userPayloads.setFirstName(faker.name().firstName());
        userPayloads.setLastName(faker.name().lastName());
        userPayloads.setEmail(faker.internet().emailAddress());
        userPayloads.setPhone(faker.phoneNumber().cellPhone());

    }

    @Test(priority = 1)
    public void createUserTest(){

        Response response = UserEndpoints.createUser(this.userPayloads);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 2)
    public void readUserDataTest(){

        Response response = UserEndpoints.readUser(this.userPayloads.getUsername());

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 3)
    public void updateUserData() {

        Response response = UserEndpoints.updateUser(this.userPayloads.getUsername(), this.userPayloads);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }

    @Test(priority = 4)
    public void deleteUser(){

        Response response = UserEndpoints.deleteUser(this.userPayloads.getUsername());

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

    }


}

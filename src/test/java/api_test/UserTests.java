package api_test;

import api_endpoints.UserEndpoints;
import api_payload.UserPayloads;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    UserPayloads userPayloads;
    public Logger logger;

    @BeforeClass
    public void setup(){

        logger = LogManager.getLogger(this.getClass());
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

        logger.info("*** TC001 - Start - Create User ***");

        Response response = UserEndpoints.createUser(this.userPayloads);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*** TC002 - Finished - Create User ***");

    }

    @Test(priority = 2)
    public void readUserDataTest(){

        logger.info("*** TC002 - Start - Read User Data");

        Response response = UserEndpoints.readUser(this.userPayloads.getUsername());

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*** TC002 - Finished - Read User Data");

    }

    @Test(priority = 3)
    public void updateUserData() {

        logger.info("*** TC003 - Start - Update User Data");

        Response response = UserEndpoints.updateUser(this.userPayloads.getUsername(), this.userPayloads);

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*** TC003 - Finished - Read User Data");

    }

    @Test(priority = 4)
    public void deleteUser(){

        logger.info("*** TC004 - Start - Delete User Data");

        Response response = UserEndpoints.deleteUser(this.userPayloads.getUsername());

        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*** TC004 - Finished - Read User Data");

    }


}

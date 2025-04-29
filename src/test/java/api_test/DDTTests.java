package api_test;

import api_endpoints.UserEndpoints;
import api_payload.UserPayloads;
import api_utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.annotations.Test;


//UserID	UserName	FirstNameLastName		Email	Password	Phone
//1010	user1	John	Candy	a@gmail.com	abcd1234@	123456789
//1020	user2	Kim	    Kom	    b@gmail.com	abcd1234@	123456789
//1030	user3	Smith	Steve	c@gmail.com	abcd1234@	123456789


public class DDTTests {


    @Test(priority = 1, dataProvider = "allData", dataProviderClass = DataProviders.class)
    public void postTest(String userid, String username, String firstName, String lastName, String email, String password, String phone){



        UserPayloads payloads = new UserPayloads();
        payloads.setId((int)Double.parseDouble(userid));
        payloads.setUsername(username);
        payloads.setFirstName(firstName);
        payloads.setLastName(lastName);
        payloads.setEmail(email);
        payloads.setPassword(password);
        payloads.setPhone(phone);

        Response response = UserEndpoints.createUser(payloads);

        response.then().assertThat().statusCode(200);


    }


    @Test(priority = 2, dataProvider = "allUserNames", dataProviderClass = DataProviders.class)
    public void deleteTest(String username){

        Response response = UserEndpoints.deleteUser(username);
        response.then().statusCode(200);

    }


}

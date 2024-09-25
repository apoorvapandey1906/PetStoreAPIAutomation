package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {

	public Logger logger;
	
	@Test(priority=1,dataProvider = "APIData",dataProviderClass = DataProviders.class)
	public void testCreateUser(String userID, String username,String firstName, String lastName, String email,String password, String phone) {
		
		User userPayload = new User();
		//setting data by reading from dataprovider class
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPhone(phone);
		userPayload.setPassword(password);
		
		logger = LogManager.getLogger(this.getClass());
		Response response = UserEndpoints2.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*********** User details=> "+response.asPrettyString());
	}
	
	@Test(priority = 2 , dataProvider = "username",dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String username) {
		
		logger.info("**** deleting the user=>"+username+"******");
		Response response = UserEndpoints2.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**** user is deleted=>"+username+"******");

	}
}

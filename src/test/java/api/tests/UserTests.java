package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User();
		
		//generating fake and random data using Faker class for testing purpose
		//Also setting up testdata in User POJO class.
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setPassword(faker.internet().password(5,10));

		//setting up logger
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser() {

		logger.info("**** Creating the user******");
		
		Response response = UserEndpoints2.createUser(userPayload);
		response.then().log().all();	
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**** User is created******");
	}
	
	@Test(priority=2)
	public void testGetUser() {		
		logger.info("**** Reading the user******");
		Response response = UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**** User is read******");	}
	
	@Test(priority=3)
	public void testUpdateUser() {	
		logger.info("**** Updating the user******");
		//updating the details of request body
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndpoints2.updateUser(this.userPayload,this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**** User is updated******");
	}
	
	@Test(priority=4)
	public void testDeleteUser() {		
		logger.info("**** deleting the user******");

		Response response = UserEndpoints2.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("**** User is deleted******");	}
}

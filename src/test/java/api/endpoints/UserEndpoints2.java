package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoint.java file 
//Created for performing CRUD operations of apis
public class UserEndpoints2 {

	//This class uses routes.properties to fetch endpoints
	
	//This method is created to fetch details from routes.properties
	static ResourceBundle getURL(){
		ResourceBundle routes = ResourceBundle.getBundle("routes"); //loads the routes.properties 
		return routes;
	}
	
	
	 public static Response createUser(User payload){
		
		 String url = getURL().getString("post_uri");
		 
		Response response = given().log().all()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		.when()
		      .post(url);
		return response;
	}
	 
	 public static Response readUser(String username){
			
		 String url = getURL().getString("get_uri");
			Response response = given().log().all()
			      .pathParam("username", username)
			.when()
			      .get(url);
			return response;
		}
	 
	 public static Response updateUser(User payload ,String username){
			
		 String url = getURL().getString("update_uri");
			Response response = given()
			      .pathParam("username", username)
			      .contentType(ContentType.JSON)
			      .accept(ContentType.JSON)
			      .body(payload).log().all()
			.when()
			      .put(url);
			return response;
		}
	 
	 public static Response deleteUser(String username){
			
		 String url = getURL().getString("delete_uri");
			Response response = given()
			      .pathParam("username", username)
			.when()
			      .delete(url);
			return response;
		}
}

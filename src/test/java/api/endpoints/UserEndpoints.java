package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoint.java file 
//Created for performing CRUD operations of apis
public class UserEndpoints {

	//This class uses routes.java to fetch endpoints
	
	 public static Response createUser(User payload){
		
		Response response = given().log().all()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON)
		      .body(payload)
		.when()
		      .post(Routes.post_uri);
		return response;
	}
	 
	 public static Response readUser(String username){
			
			Response response = given().log().all()
			      .pathParam("username", username)
			.when()
			      .get(Routes.get_uri);
			return response;
		}
	 
	 public static Response updateUser(User payload ,String username){
			
			Response response = given()
			      .pathParam("username", username)
			      .contentType(ContentType.JSON)
			      .accept(ContentType.JSON)
			      .body(payload).log().all()
			.when()
			      .put(Routes.update_uri);
			return response;
		}
	 
	 public static Response deleteUser(String username){
			
			Response response = given()
			      .pathParam("username", username)
			.when()
			      .delete(Routes.delete_uri);
			return response;
		}
}

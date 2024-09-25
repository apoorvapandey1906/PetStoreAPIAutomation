package api.endpoints;

//created for storing api base uris and endpoints

public class Routes {
	public static String base_uri = "https://petstore.swagger.io";
	
	//User Module ->
	
	public static String post_uri = base_uri +"/v2/user";
	public static String get_uri = base_uri + "/v2/user/{username}";
	public static String update_uri = base_uri + "/v2/user/{username}";
	public static String delete_uri = base_uri + "/v2/user/{username}";
	
	//store module
	//Pet module

}

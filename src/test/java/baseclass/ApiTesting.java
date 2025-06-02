package baseclass;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

public class ApiTesting {

	public static void main(String[] args) {
		String url = "https://petstore.swagger.io/v2";
		RestAssured.baseURI=url ;
		Utility.getHttp("/pet/{petId}", "application/json","petId","1111", 200);
//		given().log().all().headers("Content-type","application/json").pathParams("petId","1111").
//		when().get("/pet/{petId}").
//		then().log().all().assertThat().statusCode(200).extract().response();
		
//		given().log().all().headers("Content-type","application/json").body("{\r\n" + 
//				"  \"id\": 1111,\r\n" + 
//				"  \"category\": {\r\n" + 
//				"    \"id\": 2222,\r\n" + 
//				"    \"name\": \"string\"\r\n" + 
//				"  },\r\n" + 
//				"  \"name\": \"doggie\",\r\n" + 
//				"  \"photoUrls\": [\r\n" + 
//				"    \"string\"\r\n" + 
//				"  ],\r\n" + 
//				"  \"tags\": [\r\n" + 
//				"    {\r\n" + 
//				"      \"id\": 3333,\r\n" + 
//				"      \"name\": \"string\"\r\n" + 
//				"    }\r\n" + 
//				"  ],\r\n" + 
//				"  \"status\": \"available\"\r\n" + 
//				"}").
//		when().post("/pet").
//		then().log().all().assertThat().statusCode(200).extract().response();
		
	}

}

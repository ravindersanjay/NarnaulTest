// not working 

package com.narnaul.testcases;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class CreateCustomerTest
{
	//@Test(dataProviderClass=DataUtil.class, dataProvider ="data")
	@Test 
	public void validateCustomerValidKey() // Hashtable<String, String> data
	{
		Response response = given()
				.auth()
				.basic("sk_test_51HUS4uHSHj7PrP7O8TJxytR1TfTICVAvuHmFhvl4sRyrgZtdS6wccKOIb0haMaX1o3MTSZlbxCX8dpkIlgrPBR7o00uW8XAgfB", "")
				.formParam("email", "tuesday@gmail.com")
				.formParam("description", "this is tuesday")
				.post("https://api.stripe.com/v1/customers");
		
		
//		Response response = given().auth().basic("sk_test_8Ek0AIAk0fyvUyJiDbG5ZOIN", "")
//				.formParams("limit", 3).formParam("email", "trainer@way2automation.com")
//							.get("https://api.stripe.com/v1/customers");
		
		
		//response.prettyPrint();
//		String jsonResponse = response.asString();
//		System.out.println(jsonResponse);
//		
		System.out.println("Response code --> "+ response.statusCode());
		
		System.out.println("Getting Id from JSON path : " + response.jsonPath().get("id").toString());
		Assert.assertEquals(response.statusCode(), 200 , "code not matching ");
		//TestUtil.jsonObject(response.asString(), "id");
		JSONObject jsonObject = new JSONObject(response.asString());
//		System.out.println(jsonObject.has("id"));
// 
		Assert.assertTrue(jsonObject.has("id"), "ID key is not present in the JSON response"); 
	}
}

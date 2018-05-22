package searchForFileAuthorities_API;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Discovery_API_SearchForFileAuthorities {
	
	@Test
	
	public void verifyRecords_Details()
	{
		
		Response resp = given()
		.accept(ContentType.JSON)
		.when()
		.get("http://test.discovery.nationalarchives.gov.uk/API/repository/v1/details/C6208104");
		System.out.println("The status cod is " +resp.asString());
		System.out.println("The status cod is " +resp.statusCode());
		int Actual= resp.statusCode();
		System.out.println(Actual);
		
		//System.out.println("The status cod is " +resp.statusCode());
	
		Assert.assertEquals(Actual, 200);
		if(resp.statusCode()==200){
			
			System.out.println("status code verified");
		}
			
			else
				
			{
				System.out.println("status code is not verified");
			}
		}
	
		
		
	     
	     
		
		
		
		
		
		
	}
	



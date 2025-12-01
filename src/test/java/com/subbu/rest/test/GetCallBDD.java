package com.subbu.rest.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {

	@Test
	public void test_getCallBDD() {
//		given().
//		when().
//		then().
//		assert()
		
		given().
		when().
			get("https://bookstore.toolsqa.com/BookStore/v1/Books").
		then().
			assertThat().
			statusCode(200).
			and().
			body("books.isbn",hasSize(8)).
			and().
			header("Content-Length",equalTo("4514"));
	}
}

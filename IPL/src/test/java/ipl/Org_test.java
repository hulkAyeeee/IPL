package ipl;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Org_test {
	
	int foreignPlayers = 0;
	int wicketkeeper = 0;
	double sum = 0;

	@Test
	public void RCBparcing() {

		String jsonStringPayload = "{\r\n"
				+ "  \"name\": \"Royal Challengers Bangalore\",\r\n"
				+ "  \"location\": \"Bangalore\",\r\n" 
				+ "  \"player\": [\r\n" 
				+ "    {\r\n"
				+ "      \"name\": \"Faf Du Plessis\",\r\n"
				+ "      \"country\": \"South Africa\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" 
				+ "      \"price-in-crores\": \"7\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Virat Kohli\",\r\n" 
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" 
				+ "      \"price-in-crores\": \"15\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Glenn Maxwell\",\r\n"
				+ "      \"country\": \"Australia\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" 
				+ "      \"price-in-crores\": \"11\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Mohammad Siraj\",\r\n" 
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" 
				+ "      \"price-in-crores\": \"7\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Harshal Patel\",\r\n"
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" 
				+ "      \"price-in-crores\": \"10.75\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Wanindu Hasaranga\",\r\n"
				+ "      \"country\": \"Srilanka\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" 
				+ "      \"price-in-crores\": \"10.75\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Dinesh Karthik\",\r\n" 
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Wicket-keeper\",\r\n"
				+ "      \"price-in-crores\": \"5.5\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Shahbaz Ahmed\",\r\n" 
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"All-Rounder\",\r\n" 
				+ "      \"price-in-crores\": \"2.4\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Rajat Patidar\",\r\n" 
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Batsman\",\r\n" 
				+ "      \"price-in-crores\": \"0.20\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Josh Hazlewood\",\r\n" 
				+ "      \"country\": \"Australia\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" 
				+ "      \"price-in-crores\": \"7.75\"\r\n" 
				+ "    },\r\n"
				+ "    {\r\n" 
				+ "      \"name\": \"Mahipal Lomror\",\r\n" 
				+ "      \"country\": \"India\",\r\n"
				+ "      \"role\": \"Bowler\",\r\n" 
				+ "      \"price-in-crores\": \"7.75\"\r\n" 
				+ "    }\r\n"
				+ "  ]\r\n" 
				+ "}";

		JsonPath J = new JsonPath(jsonStringPayload);

		List<Object> L = J.getList("player");
		System.err.println(L);
		System.out.println(L.size());

//		Test case 1 Validate only 4 foreign players in a team-------------

		List<Object> M = J.getList("player.country");
		System.err.println(M);
		System.out.println(M.size());

		for (int i = 0; i < M.size(); i++) {
			System.out.println(M.get(i));
			if (!M.get(i).equals("India")) {
				foreignPlayers++;
			}
		}

		System.out.println(foreignPlayers);

		if (foreignPlayers == 4) {

			System.out.println("Test case 1 is Pass");

		}

//		Test case 2-------------

		List<Object> X = J.getList("player.role");
		System.err.println(X);
		System.out.println(X.size());

		for (int i = 0; i < X.size(); i++) {
			if (X.get(i).equals("Wicket-keeper")) {

				wicketkeeper = wicketkeeper + 1;
			}
		}

		

		if (wicketkeeper <= 1) {

			System.out.println("Only "+wicketkeeper +"  wicketkeeper is present");

		}

//		Test case 3-----------
//		List<Object> y = J.getList("player.price-in-crores");
//		System.err.println(y);
//		System.out.println(y);
//
//		for (int i = 0; i < y.size(); i++) {
//			System.out.println(M.get(i));
//			if (!M.get(i).equals("India")) {
//				sum += Double.valueOf((String) y.get(i));
//			}
//		}
//		System.out.println(sum);

}
}

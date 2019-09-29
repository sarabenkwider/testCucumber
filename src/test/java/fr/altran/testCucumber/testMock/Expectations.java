package fr.altran.testCucumber.testMock;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.JsonBody;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import com.google.gson.Gson;

import fr.altran.testCucumber.model.Abonne;

public class Expectations {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	private static Gson gson = new Gson();

	public static void createDefaultExpectations(ClientAndServer mockServer) {

		// POST
		addAbonne(mockServer);

		// GET
		getAllAbonnes(mockServer);

		// PUT
		updateAdress(mockServer);

	}

	private static void addAbonne(ClientAndServer mockServer) {
		Abonne abonne = createAbonneObjectToPut();
		JsonBody body = new JsonBody(gson.toJson(abonne));

		mockServer
				.when(request().withMethod("POST").withHeader("Content-Type", "application/json")
						.withPath("/listAbonnes/addAbonne").withBody(gson.toJson(createAbonneObjectToPut())))
				.respond(response().withStatusCode(200).withBody(gson.toJson(body)));
	}

	private static void updateAdress(ClientAndServer mockServer) {
		Abonne abonne = updateAdressObjectToPut();
		JsonBody body = new JsonBody(gson.toJson(abonne));

		mockServer
				.when(request().withMethod("PUT").withHeader("Content-Type", "application/json")
						.withPath("/listAbonnes/updateAdress").withBody(body))
				.respond(response().withStatusCode(200).withBody(body));
	}

	private static void getAllAbonnes(ClientAndServer mockServer) {

		mockServer.when(request().withMethod("GET").withHeader("Accept", "application/json")
				.withPath("/listAbonnes/getAllAbonnes")).respond(response().withStatusCode(200));

	}

	public static Abonne createAbonneObjectToPut() {
		Abonne abonne = new Abonne();
		abonne.setNom("Test abonne");
		abonne.setAdress("Paris");
		return abonne;
	}

	public static Abonne updateAdressObjectToPut() {
		createAbonneObjectToPut().setAdress("Nice");
		return createAbonneObjectToPut();

	}

}

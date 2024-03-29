package fr.altran.testCucumber.testMock;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mockserver.integration.ClientAndServer;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;

public class TestMockServer {
	
	/* 
	 * Auteur : Sara BENKOUIDER  
	 */

	private static ClientAndServer mockServer;

	@BeforeClass
	public static void setupMockServer() throws IOException, JAXBException {
		mockServer = startClientAndServer(8000);

		Expectations.createDefaultExpectations(mockServer);
	}

	@AfterClass
	public static void after() {
		mockServer.stop();
	}

}

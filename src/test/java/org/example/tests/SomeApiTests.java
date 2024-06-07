package org.example.tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.example.be.MockedServiceController;
import org.example.models.MockResponse;
import org.junit.jupiter.api.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class SomeApiTests {

    private WireMockServer wireMockServer;
    private MockedServiceController serviceController;

    @BeforeEach
    public void setUp() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8080));
        wireMockServer.start();
        WireMock.configureFor("localhost", 8080);
        serviceController = new MockedServiceController();
    }

    @Test
    public void exampleTest() {
        stubFor(get(urlEqualTo("/test")).willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withBody("{\"message\":\"Hello, world!\"}")));
        MockResponse expectedResponseBody = MockResponse.builder()
                .message("Hello, world!").build();
        MockResponse actualServiceResponse = serviceController.getServiceResponse();

        Assertions.assertEquals(expectedResponseBody, actualServiceResponse);
    }

    @AfterEach
    public void tearDown() {
        wireMockServer.stop();
    }

}

package org.example.be;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import org.example.models.MockResponse;

public class MockedServiceController {

    @Step
    public MockResponse getServiceResponse() {
        return new ApiClient.Builder().build()
                .sendRequest(Method.GET, "/test", null, 200).as(MockResponse.class);
    }
}

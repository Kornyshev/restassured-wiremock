package org.example.be;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.configs.Config;

public class ApiClient {

    private RequestSpecification requestSpec;

    private ApiClient(Builder builder) {
        this.requestSpec = builder.requestSpecBuilder.build();
    }

    public static class Builder {
        private RequestSpecBuilder requestSpecBuilder;

        public Builder() {
            requestSpecBuilder = new RequestSpecBuilder()
                    .setBaseUri(Config.BASE_URL)
                    .log(LogDetail.ALL);
        }

        public Builder addHeader(String name, String value) {
            requestSpecBuilder.addHeader(name, value);
            return this;
        }

        public Builder addQueryParam(String name, String value) {
            requestSpecBuilder.addQueryParam(name, value);
            return this;
        }

        public Builder addPathParam(String name, String value) {
            requestSpecBuilder.addPathParam(name, value);
            return this;
        }

        public ApiClient build() {
            return new ApiClient(this);
        }
    }

    public Response sendRequest(Method method, String endpoint, Object body, int expectedStatusCode) {
        RequestSpecification spec = RestAssured.given()
                .filter(new AllureRestAssured()).spec(requestSpec);
        if (body != null) {
            spec.body(body).contentType(ContentType.JSON);
        }
        Response response = spec.request(method, endpoint);
        response.prettyPeek().then().statusCode(expectedStatusCode);
        return response;
    }
}

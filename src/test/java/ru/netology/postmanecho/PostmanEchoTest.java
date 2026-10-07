package ru.netology.postmanecho;

import io.restassured.RestAssured; // Исправленный импорт
import org.junit.jupiter.api.Test;

// Импорты для проверок

import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldSendBodyAndCheckResponse() { // Название метода можно изменить
        String bodyData = "some data";

        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .body(bodyData) // Отправляемые данные
                .when()
                .post("/post") // Метод POST
                .then()
                .statusCode(200)
                /* Проверка JSONPath-выражением */
                .body("data", equalTo(bodyData));
    }
}

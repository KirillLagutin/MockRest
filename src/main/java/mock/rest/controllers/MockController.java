package mock.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mock.rest.models.Request;
import mock.rest.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class MockController {

    // ObjectMapper из Jackson, для работы с JSON
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping("/random")
    public ResponseEntity<Response> getRandom() throws IOException {

        // json-файл с зпросами, котрый лежит в resources
        File fileRqs = new File("src/main/resources/request.json");

        // Создание POJO (Java Object) из файла JSON - класс запроса
        Request request = objectMapper.readValue(fileRqs, Request.class);
        // Экземпляр класса ответа
        Response response = new Response();

        // Запись рандомного айдишника в ответ
        response.setId((int) (Math.random() * 100));
        // Запись текста с запроса в ответ
        response.setText(request.getText());

        // Проверка на чётность айдишника и запись в статус ответа
        if(response.getId() % 2 == 0) {
            response.setStatus("Id even");
        } else {
            response.setStatus("Id odd");
        }

        // Из объекта (response) записываем данные в response.json
        objectMapper.writeValue(new File("src/main/resources/response.json"), response);

        // Возвращаем наш ответ с HttpStatus-ом
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Response> update(
            @PathVariable int id,
            @RequestBody Request request)
        throws IOException {

        // Экземпляр класса ответа
        Response response = new Response();

        // Запись айдишника с запроса в ответ
        response.setId(id);
        // Запись текста с запроса в ответ
        response.setText(request.getText());

        // Проверка на чётность айдишника и запись в статус ответа
        if(response.getId() % 2 == 0) {
            response.setStatus("Id even");
        } else {
            response.setStatus("Id odd");
        }

        // Из объекта (response) записываем данные в response.json
        objectMapper.writeValue(new File("src/main/resources/response.json"), response);

        // Возвращаем наш ответ с HttpStatus-ом
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

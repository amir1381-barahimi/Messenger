package rabbirmq.client.controller;

//import com.oracle.webservices.internal.api.message.ContentType;
//import javafx.application.Application;
import lombok.SneakyThrows;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbirmq.client.Model.RequestModel.MessageRequestModel;
import rabbirmq.client.Model.responseModel.MessageResponseModel;
//import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

@RestController
@RequestMapping("/client")
public class MessageController {


    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public String sendMessage(@RequestBody MessageRequestModel messageRequestModel) throws URISyntaxException, IOException, InterruptedException, JSONException {
        JSONObject jsonMessage = messageRequestModel.toJson();
        HttpRequest httpRequest = (HttpRequest) HttpRequest.newBuilder()
                .uri(new URI("http://localhost:23232/jsonRabbit/publish"))
                .POST(HttpRequest.BodyPublishers.ofString(String.valueOf(jsonMessage)))
                .header("Content-Type" , "application/json")
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest , HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }
}

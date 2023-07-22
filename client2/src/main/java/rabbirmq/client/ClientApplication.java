package rabbirmq.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
//		boolean flag = true;
//		if (flag){
//			RestTemplate restTemplate = new RestTemplate();
//			SendMessageImpl sendMessage = new SendMessageImpl(restTemplate);
//			sendMessage.sendToServer("salam Ali" , "ali");
//			flag = false;
//		}

	}

}

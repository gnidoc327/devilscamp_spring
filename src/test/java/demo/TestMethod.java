package demo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.client.RestTemplate;

public class TestMethod {

	public static void main(String[] args) throws URISyntaxException, IOException {
		URI uri = new URI("http://52.78.52.54:8080/login?email=kimhs327@hanmail.net&password=123");
		
		RestTemplate restTemplate = new RestTemplate();
		
		String str = restTemplate.getForObject(uri, String.class);
		
		System.out.println(str);
		
	}
}

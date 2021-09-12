package com.andree.evaluacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
//@ComponentScan(basePackages = SoapClient.class)
public class EvaluacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<center><br><strong>Andree Ochoa - andlody@gmail.com</strong><br><br> <a href='./swagger-ui.html'>Swagger</a><br><br> <a href='./h2-console'>H2 Console</a></center>";
	}
}

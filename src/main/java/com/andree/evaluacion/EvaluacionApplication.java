package com.andree.evaluacion;

import com.andree.evaluacion.controllers.JwtFilterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.AbstractFilterRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class EvaluacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvaluacionApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<center><br><strong>Andree Ochoa - andlody@gmail.com</strong><br><br> <a href='./swagger-ui.html'>Swagger</a><br><br> <a href='./h2-console'>H2 Console</a></center>";
	}

	@Bean
	public AbstractFilterRegistrationBean<JwtFilterRequest> filterBean() {
		final FilterRegistrationBean<JwtFilterRequest> filter = new FilterRegistrationBean<>();
		filter.setFilter(new JwtFilterRequest());
		filter.addUrlPatterns("/user/*");
		return filter;
	}
}

package br.com.compasso.springbootinterview.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SpringBootInterviewConfig {

	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.select().apis(RequestHandlerSelectors.basePackage("br.com.compasso.springbootinterview.api"))
				.paths(PathSelectors.any())
				.build()
		         .useDefaultResponseMessages(false)                                   
		         .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
				.apiInfo(buildInfoApi().build());

		return docket;
	}

	private ApiInfoBuilder buildInfoApi() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		Contact contact = new Contact("Everton Cezar Gonçalves", //
				"https://www.linkedin.com/in/evertoncezargoncalves/", //
				"evertoncg10@outlook.com");

		apiInfoBuilder.title("Spring Boot Interview API - Teste Compasso UOL");
		apiInfoBuilder.description("API para o teste de backend da Compasso UOL");
		apiInfoBuilder.version("0.0.1-SNAPSHOT");
		apiInfoBuilder.license("Everton Cezar Gonçalves: Todos os direitos reservados");
		apiInfoBuilder.licenseUrl("");
		apiInfoBuilder.contact(contact);
		return apiInfoBuilder;
	}

	private List<ResponseMessage> responseMessageForGET() {
		return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseMessageBuilder()
						.code(404)
						.message("Not Found").build());
			}
		};
	}
}

package br.com.brasilPrev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import br.com.brasilPrev.controller.UsuarioController;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableSpringDataWebSupport
@ComponentScan("br.com.brasilPrev.service")
@ComponentScan(basePackageClasses = UsuarioController.class)
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class BrasilPrevApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrasilPrevApplication.class, args);
	}

}

package mx.pliis.empresas_sindicatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("mx")
public class EmpresasSindicatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresasSindicatosApplication.class, args);
	}

}

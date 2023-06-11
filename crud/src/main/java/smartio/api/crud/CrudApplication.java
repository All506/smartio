package smartio.api.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import smartio.api.crud.services.UserService;

import java.util.List;
import java.util.Map;


@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CrudApplication.class, args);

		// Crear el contexto de la aplicación (puede variar dependiendo del framework que estés utilizando)

		// Obtener una instancia del servicio UserService desde el contexto
		UserService userService = context.getBean(UserService.class);

		// ID del usuario para el cual deseas obtener las puntuaciones
		Long userId = 1L;

		// Llamar al método getUserScores del servicio para obtener las puntuaciones del usuario
		List<Object> scores = userService.getUserScores(userId);

		// Imprimir los resultados
		System.out.println("UserId: " + userId);
		System.out.println("Scores: " + scores);
	}



}

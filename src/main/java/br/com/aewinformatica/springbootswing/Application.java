package br.com.aewinformatica.springbootswing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.aewinformatica.springbootswing.repository.PessoaRepository;
import br.com.aewinformatica.springbootswing.ui.MDIApplication;

@SpringBootApplication
public class Application {

	@Autowired
	PessoaRepository pessoaRepository;
	
	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(
				Application.class).headless(false).run(args);

		MDIApplication appFrame = context.getBean(MDIApplication.class);
		appFrame.setVisible(true);
		
	}
}

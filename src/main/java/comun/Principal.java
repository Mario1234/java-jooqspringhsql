package comun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Principal {	

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contexto = 
                new AnnotationConfigApplicationContext(ContextoPersistencia.class);

		PruebaSelect pruSel = contexto.getBean(PruebaSelect.class);
		//PruebaSelect pruSel = new PruebaSelect();
		pruSel.ejecutaSelect();
		System.out.println("Hecho");
		contexto.close();
	}

}

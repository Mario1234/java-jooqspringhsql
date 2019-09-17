package comun;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import comun.jooq.tables.Usuario;

@Component
public class PruebaSelect {
	@Autowired
	private DSLContext dsl;
	 
	Usuario usuario = Usuario.USUARIO;

	public void ejecutaSelect() {
		Result<Record3<Integer, String, String>> result = dsl
				  .select(usuario.ID, usuario.APELLIDO, usuario.NOMBRE)
				  .from(usuario)
				  .fetch();
		Record3<Integer, String, String> fila0 = result.get(0);
		System.out.println("id: "+fila0.field1());
		System.out.println("apellido: "+fila0.field2());
		System.out.println("nombre: "+fila0.field3());
	}
}

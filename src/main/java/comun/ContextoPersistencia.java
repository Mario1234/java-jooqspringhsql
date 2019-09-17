package comun;

import javax.sql.DataSource;

import org.jooq.SQLDialect;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"comun.jooq.tables.*","comun"})
@EnableTransactionManagement
@PropertySource("classpath:configuracion.properties")
public class ContextoPersistencia {
	//PERSISTENCIA
	@Autowired
	private Environment environment;
	 
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();		
		String url = environment.getRequiredProperty("db.url");
		String usuario = environment.getRequiredProperty("db.username");
		String contrasenia = environment.getRequiredProperty("db.password");
		System.out.println("url,usuario,contrasenia: "+url+","+usuario+","+contrasenia);
	    dataSource.setUrl(url);
	    dataSource.setUsername(usuario);
	    dataSource.setPassword(contrasenia);
	    return dataSource; 
	}
	
	//TRANSACCIONES
	@Bean
	public TransactionAwareDataSourceProxy transactionAwareDataSource() {
	    return new TransactionAwareDataSourceProxy(dataSource());
	}
	 
	@Bean
	public DataSourceTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}
	 
	@Bean
	public DataSourceConnectionProvider connectionProvider() {
	    return new DataSourceConnectionProvider(transactionAwareDataSource());
	}
	 
	@Bean
	public TraductorExcepciones exceptionTransformer() {
	    return new TraductorExcepciones();
	}
	     
	@Bean
	public DefaultDSLContext dsl() {
	    return new DefaultDSLContext(configuration());
	}
	
	//EXCEPCIONES Y DIALECTO
	@Bean
	public DefaultConfiguration configuration() {
	    DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
	    jooqConfiguration.set(connectionProvider());
	    jooqConfiguration.set(new DefaultExecuteListenerProvider(exceptionTransformer()));
	 
	    String sqlDialectName = environment.getRequiredProperty("jooq.sql.dialect");//HSQLDB
	    SQLDialect dialect = SQLDialect.valueOf(sqlDialectName);//org.jooq.SQLDialect.HSQLDB
	    jooqConfiguration.set(dialect);
	 
	    return jooqConfiguration;
	}
}

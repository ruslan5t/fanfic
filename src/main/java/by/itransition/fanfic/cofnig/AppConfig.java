package by.itransition.fanfic.cofnig;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.Search;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public EntityManager entityManager() {
		EntityManager entityManager = Persistence.createEntityManagerFactory("PersistenceUnit").createEntityManager();
		try {
			Search.getFullTextEntityManager(entityManager).createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return entityManager;
	}
	
}

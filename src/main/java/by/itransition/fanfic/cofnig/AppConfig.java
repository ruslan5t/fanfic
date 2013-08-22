package by.itransition.fanfic.cofnig;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.Search;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.itransition.fanfic.domain.Category;

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

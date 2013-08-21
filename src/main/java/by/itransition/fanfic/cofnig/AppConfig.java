package by.itransition.fanfic.cofnig;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.search.jpa.Search;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.dao.impl.ChapterDaoImpl;
import by.itransition.fanfic.dao.impl.FanficDaoImpl;
import by.itransition.fanfic.dao.impl.UserDaoImpl;

@Configuration
public class AppConfig {

	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public FanficDao fanficDao() {
		return new FanficDaoImpl();
	}
	
	@Bean
	public ChapterDao chapterDao() {
		return new ChapterDaoImpl();
	}
	
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

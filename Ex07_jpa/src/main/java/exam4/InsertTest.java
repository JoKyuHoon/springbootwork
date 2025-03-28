package exam4;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class InsertTest {

	public static void main(String[] args) {
		// JPA환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		try {
			ts.begin();
			
			Member4 user;
			user = new Member4("test1@test.com", "홍길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test2@test.com", "왕길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test3@test.com", "남궁길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test4@test.com", "황길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test7@test.com", "표길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test5@test.com", "남궁길동", LocalDate.now());
			em.persist(user);
			user = new Member4("test6@test.com", "선우길동", LocalDate.now());
			em.persist(user);
			
			
			ts.commit();
			System.out.println("가입 요청을 처리했습니다 : ");
		} catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		} 
		em.close();
		emf.close();
	}

}

package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DeleteTest {

	public static void main(String[] args) {
		// JPA환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		try {
			ts.begin();
			
			Member3 user = em.find(Member3.class, "test@test.com");
			if(user == null) {
				System.out.println("존재하지 않는 아이디입니다.");
				return;
			} 
			em.remove(user); // 영속성에서 객체 삭제(ORM)
			
			ts.commit();
			System.out.println("삭제되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		em.close();
		emf.close();
	}

}

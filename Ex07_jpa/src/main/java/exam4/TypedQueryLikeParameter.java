package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TypedQueryLikeParameter {

	public static void main(String[] args) {
		// JPA환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
				
		try {
			ts.begin();
			
			TypedQuery<Member4> query = 
					em.createQuery("select m from Member4 m"
								 + " where m.email like :email "
								 + " order by m.name"
								 , Member4.class)
								 .setParameter("email", "%test%");
								 List<Member4> list = query.getResultList();
								 
			ts.commit();
			
			if(list.isEmpty()) {
				System.out.println("사용자가 없습니다");
			} else {
				list.forEach(user -> System.out.println(user.getName() + " / " + user.getEmail()));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			ts.rollback();
		}
		em.close();
		emf.close();
	}

}
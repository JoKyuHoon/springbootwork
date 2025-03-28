package exam4;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class TypedQueryTest {

	public static void main(String[] args) {
		// JPA환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		/*
		 * TypedQuery 클래스 : sql문을 직접 작성하고자 할 때
		   - 일반 sql 구문이 아닌 영속성의 객체에 넣을 구문 jpa문법
		     > select * => *은 사용불가능. 테이블의 별칭을 이용하여 사용해야함
		 */
		try {
			ts.begin();
			TypedQuery<Member4> query = em.createQuery("select m from Member4 m order by m.name", Member4.class);
			
			List<Member4> list = query.getResultList();
			
			ts.commit();
			
			if(list.isEmpty()) {
				System.out.println("테이블이 비어있습니다.");
			} else {
				list.forEach(user -> System.out.println(user.getEmail() + " / " + user.getName()));
			}
		} catch(Exception e) {
			ts.rollback();
			e.printStackTrace();
		}
		em.close();
		emf.close();
	}

}

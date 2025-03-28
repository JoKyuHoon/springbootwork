package exam3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class SelectTest {

	public static void main(String[] args) {
		// JPA환경 설정
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEx01");
		// 실제 DB와 연결하여 CRUD
		EntityManager em = emf.createEntityManager();
		// 트랜잭션 관리
		EntityTransaction ts = em.getTransaction();
		
		/*
		 * 검색시 find() 메서드 사용
		   - test@test.com을 찾아서 Member3에 담아서 가지고 오려고 함
		     > find 뒤에 아무것도 붙이지 않으면 @Id(primary key)가 붙은 필드에서 검색함
		 */
		Member3 user = em.find(Member3.class, "test@test.com");
		System.out.println(user);
		
		if(user != null) {
			System.out.println("이름 : " + user.getName());
			System.out.println("이메일 : " + user.getEmail());
			System.out.println("날짜 : " + user.getCreateDate());
		} else {
			System.out.println("존재하지 않는 아이디 입니다");
		}
		em.close();
		emf.close();
	}

}

package hellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			/* [create]
			Member member = new Member();
			member.setId(2L);
			member.setName("helloB");

			em.persist(member);
			*/

			/*	[select]	*/
			Member findMember = em.find(Member.class, 1L);

			/*	[update] -> java 객체값만 바뀌었는데 어떻게 DB값이 변할까?	*/
			/*	commit시점 변경점 감지 후 update query 생성	*/
			findMember.setName("helloJAP");

			System.out.println("findMember.id = " + findMember.getId());
			System.out.println("findMember.name = " + findMember.getName());

			/* [JPQL] 나이가 18이상인 회원 검색 ? || 모든 회원을 검색 ?*/
			List<Member> result = em.createQuery("SELECT m FROM Member AS m", Member.class)
				.getResultList();

			for (Member member : result) {
				System.out.println("member.name = " + member.getName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();


	}
}

package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        /*
        * param : persistence.xml ->   <persistence-unit name="hello"> name 부분
        * */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // -> Factory는 하나만 만들어야 한다.
        EntityManager em = emf.createEntityManager(); // -> connection 얻고 종료되는 일괄의 과정은 em단위로 실행한다.

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        /*
         * JPA Logic ↓
         * */

        try {
            Member member = new Member();
            member.setId(2L);               //ln17
            member.setName("HelloB");       //ln18
            em.persist(member);             //ln19
            /*
             * ln 17, 18, 19까지만해도 실행이 안된다. why ? JPA는 Transaction이라는 단위가 매우 중요하다.
             * 데이터를 변경하는 모든 작업은 JPA에서 Transaction 안에서 작업을 해야한다. -> ln 14로 간다.
             * */
            tx.commit();
        } catch (Exception e){
            tx.rollback(); //exception 발생시 롤백해준다.
        } finally {
            em.close();
        }
        emf.close();
    }
}

package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdJpaMain { //Member객체를 Update하고싶다 ?
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
        try { //EntityMagager를 Java의 Collection 단위로 이해하면된다.

            Member findMember = em.find(Member.class, 1L);
            /*
            * Update Logic
            * */
            findMember.setName("HelloJPA"); //Update로직은 이걸로 끝이다. 어? persist해야하지 않아요 ? 안해도된다. -> Java Collection 을 다루는것처럼 설계되서 그런다.
            //JAVA객체에서 값만 바꿨는데 이게 어떻게 되는것이지 ?
            //어떻게 이럴까 ? -> JPA를 통해서 Entity를 가져오면  ln:23  JPA가 관리를 한다. 변경 내역을 확인해서 Transaction.commit하는 시점에 다 체크를 한다.
            //어 ? 바꼈네 ? -> Update Query 작성

            /*
            * 만약 조건문을 검색을 한다면 ? -> JPQL사용
            * Join 및 기타 세부 쿼리 작성 -> 결국 JPA에서도 기승전Query
            List<Member> resutl = em.createQuery("select m from Member as m", Member.class)
                                   .getResultList(); -> select m from Member as m ? -> 테이블을 대상으로 코드를 짜지 않는다. -> Member객체를 대상으로 쿼리를 작성한다.\
            *  -> 이게 무슨 메리트가 있지 ? -> ex) Paging을 하고싶다 ?

            List<Member> resutl = em.createQuery("select m from Member as m", Member.class)
                                    .setFirstResult(1)
                                    .setMaxResults(10)
                                       .getResultList(); -> ex) persistence.xml에 oracle이다라면 rownum으로 oracle문법으로 바뀐다.
                                       <<property name="hibernate.dialect" value="org.hibernate.dialect.Oracle12cDialect"/>> 참조
           -> JPQL -> 객체를 대상으로 하는 객체지향 쿼리 -> 방언에 맞춰서 번역을 해서 돌린다.
            * */

            //em.remove(findMember); -> Delete 로직
            tx.commit();
        } catch (Exception e){
            tx.rollback(); //exception 발생시 롤백해준다.
        } finally {
            em.close();
        }
        emf.close();
    }
}

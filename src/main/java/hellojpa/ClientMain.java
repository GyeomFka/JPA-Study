package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ClientMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /*Client c = new Client();
            c.setEmpno("SS022028");
            c.setName("김용환3");
            c.setPassword("ss022027");

            em.persist(c);*/
            Client findClient = em.find(Client.class, "SS022027");

            System.out.println("찾아온 사번 : " + findClient.getEmpno());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();



    }
}

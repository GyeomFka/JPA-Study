package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {


    public Client() {
    }

    @Id
    String empno;
    String name;
    String password;

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* JPA가 관리하도록 인식
* */
@Entity // <- JPA가 관리하는 객체다 라고 선언.
//@Table(name = "Table_Name") // <- 이렇게도 선언이 가능하다.
public class Member { //Table Naming은 관례를 따른것
    /*
    * PK 등록
    * */
    @Id
    private Long id;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //@Column(name ="Column_Name")
    private String name; //Column Naming은 관례를 따른것것

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
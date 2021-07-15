package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* JPA가 관리하도록 인식
* */
@Entity
//@Table(name = "Table_Name")
public class Member { //Table Naming은 관례를 따른것
    /*
    * PK 등록
    * */
    @Id
    private Long id;

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
package MemberPracticePackage;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MemberPractice {

    public MemberPractice() {
    }

    @Id
    private Long id;

    @Column(name = "name") //객체이름과 컬럼이름이 달라도 매핑시킨다.
    private String username;

    private Integer age; //타입도 알아서 맞춰준다.

    @Enumerated(EnumType.STRING)
    private RoleType roleType; //DB에는 enum type이 없다. 그때 @Enumerated anno를 붙이면 된다.
    //enumtype.string이 권장사항이 된다. enum이란 녀석이란걸 봤을때.

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    /*
    * JAVA의 datetype은 날짜-시간 다 있다.
    * */

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //varchar를 넘어서는 큰 컨텐츠를 넣고 싶으면 Lob을 쓰면된다.
    private String description;

    @Transient //얘는 DB에서 건들지 말아줘 , 매모리에서만 활용 하고 싶다.
    private int temp; //얘는 DB랑 뭔가 하지 말아줘

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package app.liugch.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import sun.font.TrueTypeFont;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private long id;
    private String mail;
    private String pwd;
    private String name;
    private String toux;

    private Long utype; // 类型

    private int status;         //激活状态
    private String validateCode; //激活码

    private Date crateTime;
    private Date updateTime;


    private List<Relationship> relationships;
    private List<Relationship> relationships2;
    private List<Posts> postss;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true, length = 30)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(length = 30)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToux() {
        return toux;
    }

    public void setToux(String toux) {
        this.toux = toux;
    }

    public Long getUtype() {
        return utype;
    }

    public void setUtype(Long utype) {
        this.utype = utype;
    }

    @Column
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @OneToMany(mappedBy = "master")
    //@Fetch(FetchMode.JOIN)
    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }



    @OneToMany(mappedBy = "forlowed")
    public List<Relationship> getRelationships2() {
        return relationships2;
    }

    public void setRelationships2(List<Relationship> relationships2) {
        this.relationships2 = relationships2;
    }

    @OneToMany(mappedBy = "user")
    //@Fetch(FetchMode.JOIN)
    public List<Posts> getPostss() {
        return postss;
    }

    public void setPostss(List<Posts> postss) {
        this.postss = postss;
    }


}

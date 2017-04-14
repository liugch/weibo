package app.liugch.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2017/2/14.
 */
@Entity
public class Posts {
    private Long id;
    private String content;
    private String pic;
    private Date crateTime;
    private Date updateTime;

    private User user;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(columnDefinition ="TEXT")
    public  String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

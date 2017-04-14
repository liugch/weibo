package app.liugch.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * 之间的关系表
 */
@Entity
public class Relationship {

    private long id;
    private Date crateTime;
    private Date updateTime;
    // 关注与取消关注
    private int flag;


    //我
    private User master;

    // 关注的人
    private User forlowed;

    private UserGroup group;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name = "master_id")
    public User getMaster() {
        return master;
    }

    public void setMaster(User master) {
        this.master = master;
    }


    @ManyToOne
    @JoinColumn(name = "forlowed_id")
    public User getForlowed() {
        return forlowed;
    }

    public void setForlowed(User forlowed) {
        this.forlowed = forlowed;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    public UserGroup getGroup() {
        return group;
    }

    public void setGroup(UserGroup group) {
        this.group = group;
    }

}

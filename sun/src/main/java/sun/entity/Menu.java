package sun.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 菜单实体
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自增
    private Integer id;  // id
    private Integer pid; // 父节点id
    private String  text; // 节点名
    private String  attributes;// 跳转地址

    public Menu() {
    }

    public Menu(Integer pid, String text, String attributes) {
        this.pid = pid;
        this.text = text;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", pid=" + pid + ", text='" + text + '\'' + ", attributes='" + attributes + '\'' + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}

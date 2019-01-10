package sun.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

/**
 * 菜单实体类
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class Menu {
    // ID
    @Id// 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 自增
    private Integer id;
    // 菜单名
    private String  name;
    // 菜单等级
    private Integer levle;

    public Menu(Integer id, String name, Integer levle) {
        this.id = id;
        this.name = name;
        this.levle = levle;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", name='" + name + '\'' + ", levle=" + levle + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevle() {
        return levle;
    }

    public void setLevle(Integer levle) {
        this.levle = levle;
    }

}
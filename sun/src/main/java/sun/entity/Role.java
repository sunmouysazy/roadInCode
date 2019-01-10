package sun.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class Role {
    // ID
    @Id//主键
    @GeneratedValue(strategy= GenerationType.IDENTITY)//自增
    private Integer id;
    // 角色名
    private String name;
    // 菜单等级（外键）
    private Integer menuLevel;

    public Role(Integer id, String name, Integer menuLevel) {
        this.id = id;
        this.name = name;
        this.menuLevel = menuLevel;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name='" + name + '\'' + ", menuLevel=" + menuLevel + '}';
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

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }


}

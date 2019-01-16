package sun.entity;

import java.util.List;

/**
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class MtreeNode {
    private Integer id;
    private String value;
    private String text;
    private Integer pid;
    private List<MtreeNode> children;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getPid() {
        return pid;
    }
    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<MtreeNode> getChildren() {
        return children;
    }
    public void setChildren(List<MtreeNode> children) {
        this.children = children;
    }

}

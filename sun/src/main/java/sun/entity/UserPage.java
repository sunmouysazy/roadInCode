package sun.entity;

/**
 * 分页查询的实体
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
public class UserPage {
    // ID
    private Integer id;
    // 用户名
    private String  username;
    // 密码
    private String  password;
    // 角色ID
    private Integer roleId;
    // 当前页数
    private  Integer page;
    // 总条数
    private Integer TotalElements;
    // 总页数
    private Integer TotalPages;

    public UserPage(Integer id, String username, String password, Integer roleId, Integer page, Integer totalElements, Integer totalPages) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.page = page;
        TotalElements = totalElements;
        TotalPages = totalPages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalElements() {
        return TotalElements;
    }

    public void setTotalElements(Integer totalElements) {
        TotalElements = totalElements;
    }

    public Integer getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(Integer totalPages) {
        TotalPages = totalPages;
    }

    @Override
    public String toString() {
        return "UserPage{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", roleId=" + roleId + ", page=" + page + ", TotalElements=" + TotalElements + ", TotalPages=" + TotalPages + '}';
    }
}

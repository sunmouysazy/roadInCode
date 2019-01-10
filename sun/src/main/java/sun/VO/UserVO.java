package sun.VO;

import lombok.Data;

/**
 * user表及role表的实体类
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Data
public class UserVO {
    // ID
    private Integer id;
    // 用户名
    private String  username;
    // 密码
    private String  password;
    // 角色权限
    private String roleName;
}

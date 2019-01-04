package sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.dao.UserDao;
import sun.entity.User;
import sun.service.Exception.PasswordFormatException;
import sun.service.Exception.UsernameConfictException;
import sun.service.Exception.UsernameFormatException;

/**
 * 用户业务实现层
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Service
public class UserService {
    // 自动装配，导入持久层
    @Autowired
    private UserDao userDao;

    // 添加用户的方法
    public void add(User user) {
        // 获取用户名
        String username = user.getUsername();
        // 获取密码
        String password = user.getPassword();
        // 设置用户的角色为注册用户
        user.setRoleId(2);

        // 校验用户名
        if (6 > username.length() || username.length() > 16) {
            System.out.println("用户名验证失败");
            throw new UsernameFormatException("用户名格式不正确，请重新输入！");
        }

        // 检查用户名是否存在
        Integer id = userDao.getIdByUsername(username);
        if (id != null) {
            System.out.println("用户名已被占用！");
            throw new UsernameConfictException("用户名已被占用，请重新输入！");
        }

        // 校验密码
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        boolean check = password.matches(regex);
        if (!check) {
            System.out.println("密码验证失败！");
            throw new PasswordFormatException("密码格式不正确，请重新输入！");
        }
        userDao.save(user);
    }

    // 查询全部用户方法
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }
}

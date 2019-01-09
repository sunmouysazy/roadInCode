package sun.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sun.dao.UserDao;
import sun.entity.User;
import sun.service.Exception.DeleteManagerException;
import sun.service.Exception.NullOfIdForParamException;
import sun.service.Exception.PageIndexOfException;
import sun.service.Exception.PasswordFormatException;
import sun.service.Exception.PasswordWoringException;
import sun.service.Exception.RoleIdFormatException;
import sun.service.Exception.UpdatePasswordException;
import sun.service.Exception.UserNotFindException;
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
        checkUsername(username);
        // 检查用户是否存在
        Integer id = userDao.getUserIdByUsername(username);
        if (id != null) {
            System.out.println("用户名已被占用！");
            throw new UsernameConfictException("用户名" + username + "已被占用，请重新输入！");
        }
        // 校验密码
        checkPassword(password);
        // 调用持久层方法
        userDao.save(user);
    }

    // 用户登录校验方法
    public User Userlogin(User user) {
        System.out.println(user);
        // 获取用户输入的用户名及密码
        String username = user.getUsername();
        String inputPwd = user.getPassword();
        // 根据用户名查询用户信息
        User list = getUserByUsername(username);
        // 获取id
        // 获取查询出的用户密码
        String UserPwd = list.getPassword();
        // 对比密码
        if (inputPwd.equals(UserPwd)) {
            // 密码匹配
            System.out.println("登录成功！");
        } else {
            // 密码不匹配
            System.out.println("密码:" + inputPwd + "不正确！");
            throw new PasswordWoringException("密码不正确，请重新输入！");
        }
        return list;
    }

    // 用户修改密码的方法
    public void updatePwd(Integer id, String oldPwd, String newPwd) {
        // 校验新旧密码格式
        checkPassword(oldPwd);
        checkPassword(newPwd);
        // 根据id查询用户信息
        User user = userDao.getUserByUserId(id);
        if (user == null) {
            throw new UserNotFindException("尝试访问的用户数据不存在！可能已经被删除！");
        }
        // 检验原密码是否正确
        // 获取用户密码
        String userPwd = user.getPassword();
        // 用户密码与输入的原密码对比
        if (oldPwd.equals(userPwd)) {
            // 密码匹配
            // 调用持久层方法更新密码
            Integer row = userDao.updatePassword(id, newPwd);
            if (row != 1) {
                throw new UpdatePasswordException("修改密码时发生未知异常，请重试！");
            }
        } else {
            // 密码不匹配
            throw new PasswordWoringException("原密码输入错误，请重新输入！");
        }
    }

    // 分页查询的方法
    public List<User> pageFind(Integer page) {
        // 默认跳过页数page为1
        if (null == page) {
            page = 1;
        }
        // 创建list集合作为读取分页查询数据的容器
        List<User> list = new ArrayList<User>(5);
        // 创建pageable对象 设置每页数据5条
        Pageable pageable = PageRequest.of(page - 1, 5);
        // 分页查询所有用户数据
        Page<User> datas = userDao.findAll(pageable);
        System.out.println("总条数：" + datas.getTotalElements());
        System.out.println("总页数：" + datas.getTotalPages());
        // 循环将分页数据装入list集合
        for (User u : datas) {
            list.add(u);
        }
        if (page > datas.getTotalPages()) {
            throw new PageIndexOfException("页面超限！");
        }
        return list;
    }

    // 删除用户的方法(根据用户id删除)
    public void deleteUserById(Integer id) {
        // 调用持久层方法
        if (id != 1) {
            userDao.deleteUserById(id);
            System.out.println("用户" + id + "已被删除！");
            return;
        }
        throw new DeleteManagerException("权限不足,无法删除管理员！");
    }

    // 修改用户数据的方法(根据id修改)
    public void updateUserById(User user) {
        if (null == user.getId()) {
            // 未上传id 抛出异常
            throw new NullOfIdForParamException("修改用户数据异常！");
        }
        if (user.getUsername() != null) {
            checkUsername(user.getUsername());
        }
        if (user.getPassword() != null) {
            checkPassword(user.getPassword());
        }
        Integer roleId = user.getRoleId();
        // 2 管理员 3 用户
        if (roleId != null) {
            if (roleId != 2 && roleId != 3) {
                throw new RoleIdFormatException("请正确设置角色id！");
            }
        }
        // 调用持久层
        userDao.updateUserById(user);
        System.out.println("修改用户数据成功!");
    }

    // 查询用户信息的方法(根据username查询)
    public User getUserByUsername(String username) {
        User list = userDao.getUserByUsername(username);
        if (list == null) {
            System.out.println("用户不存在！");
            throw new UserNotFindException("用户名" + username + "不存在，请重新输入！");
        }
        // 返回用户信息
        return list;
    }

    // 查询用户信息的方法(根据id查询)
    public User getUserById(Integer id) {
        User list = userDao.getUserByUserId(id);
        if (list == null) {
            System.out.println("用户不存在！");
            throw new UserNotFindException("用户:" + id + "不存在，请重新输入！");
        }
        // 返回用户信息
        return list;
    }

    // 校验用户名的方法
    private void checkUsername(String username) {
        if (6 > username.length() || username.length() > 16) {
            System.out.println("用户名验证失败");
            throw new UsernameFormatException("用户名" + username + "格式不正确，请输入6-16位用户名！");
        }
    }

    // 校验密码格式的方法
    private void checkPassword(String password) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";
        boolean check = password.matches(regex);
        if (!check) {
            System.out.println("密码验证失败！");
            throw new PasswordFormatException("密码格式不正确，请重新输入6-16位由字母和数字构成的密码！");
        }
    }

    // 查询全部用户方法
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }
}

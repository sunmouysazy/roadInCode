package sun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sun.entity.ResponseResult;
import sun.entity.User;
import sun.service.UserService;
import sun.service.Exception.NoAccessInfoException;
import sun.service.Exception.UserNotFindException;

/**
 * 用户控制层
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    // 自动装配，导入业务层
    @Autowired
    private UserService userService;

    // 添加用户的方法
    @PostMapping("/add")
    public ResponseResult insert(User user) {
        // 调用业务层方法
        userService.add(user);
        return new ResponseResult();
    }

    // 用户登录的方法
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpSession session) {
        // 调用业务层方法
        User u = userService.Userlogin(user);
        // 获取登录用户的id
        Integer id = u.getId();
        // 将id封装到session中
        session.setAttribute("id", id);
        System.out.println("封装id：" + id);
        // 创建返回值对象
        return new ResponseResult();
    }

    // 用户修改密码的方法
    @RequestMapping("/update/password")
    public ResponseResult updatePwd(@RequestParam("old_password") String oldPwd, @RequestParam("new_password") String newPwd, HttpSession session) {
        // 通过session验证获取id
        Integer id = getIdfromSession(session);
        System.out.println("获取的Session id：" + id);
        System.out.println("旧密码：" + oldPwd + ",新密码：" + newPwd);
        // 调用业务层方法
        userService.updatePwd(id, oldPwd, newPwd);
        // 创建返回值对象
        return new ResponseResult();
    }

    // 修改用户数据的方法
    @RequestMapping("/update/user")
    public ResponseResult updateUser(User user) {
        // 调用业务层方法
        userService.updateUserById(user);
        return new ResponseResult();
    }

    // 分页查看用户的方法
    @RequestMapping("/pageFind")
    public ResponseResult pageFind(Integer page, HttpSession session) {
        // 通过session验证获取id
        Integer id = getIdfromSession(session);
        if (id != 1) {
            throw new NoAccessInfoException("您没有管理员权限，无法访问！");
        }
        System.out.println("Controller的page的值" + page);
        // 调用业务层方法
        List<User> list = userService.pageFind(page);
        System.out.println("从service出来list的值" + page);
        // 创建并返回对象
        ResponseResult result = new ResponseResult();
        result.setData(list);
        return result;
    }

    // 删除用户的方法
    @RequestMapping("/delete")
    public ResponseResult deleteUserById(Integer id, HttpSession session) {
        System.out.println("进入Delete方法！！！！");
        // 通过session验证获取id
        Integer findId = getIdfromSession(session);
        if (findId != 1) {
            throw new NoAccessInfoException("您没有管理员权限，无法访问！");
        }
        System.out.println("id值：" + id);
        // 调用业务层方法
        userService.deleteUserById(id);
        // 创建并返回
        return new ResponseResult();
    }

    // 查询单个用户方法
    @RequestMapping("/get")
    public ResponseResult getUserById(Integer id) {
        System.out.println("来了来了！！！");
        User user = userService.getUserById(id);
        ResponseResult result = new ResponseResult();
        result.setData(user);
        return result;
    }

    // 查询所有用户
    @RequestMapping("/find")
    public List<User> find() {
        // 调用业务层方法
        List<User> list = this.userService.findAll();
        if (list == null) {
            throw new UserNotFindException("用户不存在，请重新查询！");
        }
        return list;
    }

}

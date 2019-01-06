package sun.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sun.entity.ResponseResult;
import sun.entity.User;
import sun.service.UserService;
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
    @RequestMapping("/add")
    public ResponseResult insert(User user) {
        // 调用业务层方法
        userService.add(user);
        return new ResponseResult();
    }

    // 用户登录的方法
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpSession session) {
        // 调用业务层方法
       User u =  userService.Userlogin(user);
        // 获取登录用户的id
        Integer id = u.getId();
        // 将id封装到session中
        session.setAttribute("id", id);
        System.out.println("封装id："+id);
        // 创建返回值对象
        ResponseResult result = new ResponseResult();
        return result;
    }

    // 修改用户密码的方法
    @RequestMapping("/update/password")
    public ResponseResult updatePwd(@RequestParam("old_password") String oldPwd, @RequestParam("new_password") String newPwd, HttpSession session) {
        // 通过session验证获取id
        Integer id = getIdfromSession(session);
        System.out.println("获取的Session id："+id);
        System.out.println("旧密码："+oldPwd+",新密码："+newPwd);
        // 调用业务层方法
        userService.updatePwd(id,oldPwd,newPwd);
        // 创建返回值对象
        ResponseResult result = new ResponseResult();
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

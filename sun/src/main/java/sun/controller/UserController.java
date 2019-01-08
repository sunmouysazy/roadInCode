package sun.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sun.dao.UserDao;
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
    @Autowired
    private UserDao dao;

    // 添加用户的方法
    @PostMapping("/add")
    public ResponseResult insert(User user) {
        // 调用业务层方法
        userService.add(user);
        return new ResponseResult();
    }

    // 用户登录的方法d
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
        return new ResponseResult();
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
        return new ResponseResult();
    }

    // 分页查看用户的方法
    @RequestMapping("/pageFind")
        public ResponseResult pageFind(@RequestParam(value = "page",defaultValue = "1",required = false) Integer page, HttpSession session, HttpServletResponse response) throws IOException {
        // 通过session验证获取id
        Integer id = getIdfromSession(session);
        if (id != 1){
            throw new NoAccessInfoException("您没有管理员权限，无法访问！");
        }
        System.out.println("Controller的page的值"+page);
        List<User> list =  userService.pageFind(page);
        System.out.println("从service出来list的值"+page);
        ResponseResult result = new ResponseResult();
        result.setData(list);
        result.setState(200);
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

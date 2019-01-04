package sun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/find")
    public List<User> find() {
        List<User> list = this.userService.findAll();
        if (list == null) {
            throw new UserNotFindException("用户不存在，请重新查询！");
        }
        return list;
    }
    //添加用户的方法
    @RequestMapping("/add")
    public ResponseResult insert(User user) {
        // 调用业务层方法
        userService.add(user);
        return new ResponseResult();
    }
}

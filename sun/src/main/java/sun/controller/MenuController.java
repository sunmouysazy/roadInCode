package sun.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sun.entity.Menu;
import sun.entity.ResponseResult;
import sun.service.MenuService;

/**
 * 用户控制层
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class MenuController extends BaseController {
    // 自动装配，导入业务层
    @Autowired
    private MenuService menuService;

    // 增加菜单
    @RequestMapping("add/menu")
    public ResponseResult addMenu(Menu m) {
        menuService.add(m);
        return new ResponseResult();
    }

    // 修改菜单名
    @RequestMapping("/update/menu/name")
    public ResponseResult updateMenuName(Integer id, @Param("text") String text) {
        menuService.updateMenuText(id, text);
        return new ResponseResult();
    }

    // 获取单个菜单
    @RequestMapping("get/menu")
    public ResponseResult getMenu(Integer id) {
        ResponseResult result = new ResponseResult();
        result.setData(menuService.getMenu(id));
        return result;
    }

    // 删除单个菜单
    @RequestMapping("/delete/menu")
    public ResponseResult deleteMenu(Integer id) {
        menuService.deleteMenu(id);
        return new ResponseResult();
    }

    // 获取全部菜单
    @RequestMapping("/find/all/menu")
    public ResponseResult findAllMenu() {
        ResponseResult result = new ResponseResult();
        List<Menu> m = menuService.findAllMenu();
        result.setData(m);
        return result;
    }

    // 查询所有菜单
    @RequestMapping("/find/menu")
    public ResponseResult getNodesById(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("开始");
        String str = "";
        StringBuilder json = new StringBuilder();
        // 获得根节点
        Menu treeRoot = menuService.getNodeById(id);
        // 拼接根节点
        json.append("[");
        json.append("{\"id\":" + String.valueOf(treeRoot.getId()));
        json.append(",\"text\":\"" + treeRoot.getText() + "\"");
        json.append(",\"state\":\"open\"");
        // 获取根节点下的所有子节点
        List<Menu> treeList = menuService.findNodesByPid(id);
        // 遍历子节点下的子节点
        if (treeList != null && treeList.size() != 0) {
            json.append(",\"children\":[");
            for (Menu m : treeList) {
                json.append("{\"id\":" + Integer.valueOf(m.getId()));
                json.append(",\"text\":\"" + m.getText() + "\"");
                json.append(",\"state\":\"open\"");
                // 该节点有子节点
                // 设置为关闭状态,而从构造异步加载tree
                List<Menu> tList = menuService.findNodesByPid(m.getId());
                if (tList != null && tList.size() != 0) {// 存在子节点
                    json.append(",\"children\":[");
                    json.append(dealJsonFormat(tList));// 存在子节点的都放在一个工具类里面处理了
                    json.append("]");
                }
                json.append("},");
            }
            str = json.toString();
            str = str.substring(0, str.length() - 1);
            str += "]}];";
        }
        System.out.println("输出json数据" + str);
        ResponseResult result = new ResponseResult();
        result.setData(str);
        System.out.println(str);
        return result;
    }

    /**
     * 处理数据集合，将数据集合转为符合格式的json
     *
     * @param tList 参数
     * @return json字符串
     */
    public String dealJsonFormat(List<Menu> tList) {
        StringBuilder json = new StringBuilder();
        for (Menu tree : tList) {
            json.append("{\"id\":" + Integer.valueOf(tree.getId()));
            json.append(",\"text\":\"" + tree.getText() + "\"");
            json.append(",\"attributes\":{url: \"" + tree.getAttributes() + "\"},");
            json.append("},");
        }
        String str = json.toString();
        str = str.substring(0, str.length() - 1);
        return str;
    }
}

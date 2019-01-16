package sun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.dao.MenuDao;
import sun.entity.Menu;

/**
 * 用户业务实现层
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Service
public class MenuService {
    // 自动装配，导入持久层
    @Autowired
    private MenuDao menuDao;

    // 增加菜单
    public void add(Menu m) {
        menuDao.save(m);
    }

    // 获取单个菜单
    public Menu getMenu(Integer id) {
        System.out.println(menuDao.getMenuById(id));
        return menuDao.getMenuById(id);
    }

    // 获取全部菜单
    public List<Menu> findAllMenu() {
        return menuDao.findAll();
    }

    // 删除单个菜单
    public void deleteMenu(Integer id) {
        if (menuDao.deleteMenu(id) != 0) {
            System.out.println("删除菜单成功！");
        }
    }

    // 获取单个节点(根据id)
    public Menu getNodeById(Integer id) {
        return menuDao.getMenuById(id);
    }

    // 获取当前节点所有子节点(根据pid)
    public List<Menu> findNodesByPid(Integer pid) {
        return menuDao.findMenuByPId(pid);
    }

    // 修改菜单名
    public void updateMenuText(Integer id, String text) {
        if (menuDao.updateMenuText(id, text) != 0) {
            System.out.println("修改菜单名成功！");
        }
    }

}

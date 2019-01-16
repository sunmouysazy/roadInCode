package sun.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sun.entity.Menu;

/**
 * 菜单持久层接口
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Repository
public interface MenuDao extends JpaRepository<Menu, Integer> {
    // 查询菜单(根据id查询单个节点)
    @Query("select m from Menu m where m.id = ?1")
    Menu getMenuById(Integer id);

    // 查询子节点(根据PId查询所有子节点)
    @Query(value = "select * from Menu m where m.pid = ?1", nativeQuery = true)
    List<Menu> findMenuByPId(Integer pId);

    // 更改菜单名
    @Transactional
    @Modifying
    @Query("update Menu m set m.text=:text where m.id=:id")
    Integer updateMenuText(@Param("id") Integer id, @Param("text") String text);

    // 获取单个菜单(根据id)
    @Query("select m from Menu m where id = ?1")
    Menu getMenu(@Param("id") Integer id);

    // 删除单个菜单(根据id)
    @Transactional
    @Modifying
    @Query("delete from Menu where id=?1")
    Integer deleteMenu(Integer id);

}

package sun.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sun.entity.User;

/**
 * 用户持久层接口
 * ---------------------------------------------------------------------------------------------------------------------
 *
 * @author Administrator
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    // 查看用户是否存在(根据username查询id)
    @Query("select id from User where username=?1")
    Integer getIdByUsername(String username);
}

package sun.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    // 查询用户信息(根据username查询)
    @Query("select u from User u where username=?1")
    User getUserByUsername(String username);

    // 查询用户id(根据id查询)
    @Query("select u from User u  where id=?1")
    User getUserByUserId(Integer id);

    // 查询用户id(根据username查询)
    @Query("select id from User  where username=?1")
    Integer getUserIdByUsername(String username);

    // 修改密码(根据id修改)
    @Transactional
    @Modifying
    @Query("update User u set u.password=:password where u.id=:id")
    Integer updatePassword(@Param("id") Integer id, @Param("password") String password);


//     修改个人资料(根据id修改)
//    @Transactional
//    @Modifying
//    @Query("update User u set ")

}

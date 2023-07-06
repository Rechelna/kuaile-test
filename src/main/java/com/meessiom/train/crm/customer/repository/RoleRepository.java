package com.meessiom.train.crm.customer.repository;


import com.meessiom.train.crm.customer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Long>, JpaSpecificationExecutor {
    @Query(value = "select role_name from Role where id = ?",nativeQuery = true)
    public String getRoleNameByRoleId(long id);
//    @Query(value = "select * from customers where = null", )


//    public List<Role> findRoleByRoleNameLikeAndRoleStatusLike(@Param("name") String name , @Param("status") String status );

}

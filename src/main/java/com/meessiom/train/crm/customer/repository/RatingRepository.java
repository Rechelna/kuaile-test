package com.meessiom.train.crm.customer.repository;

import com.meessiom.train.crm.customer.model.Customer;
import com.meessiom.train.crm.customer.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long>,JpaSpecificationExecutor {

    @Query(value = "select rating_name from rating where id = ?",nativeQuery = true)
    public String getCustomerNameByCustomerId(long id);
//    @Query(value = "select * from customers where = null", )
//    public List<Customer> findCustomerByCustomerNameLikeAndCustomerPhoneLikeAndCustomerAddressLike(@Param("name") String name ,@Param("phone") String phone , @Param("address") String address );
}


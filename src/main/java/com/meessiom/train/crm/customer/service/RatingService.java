package com.meessiom.train.crm.customer.service;

import com.meessiom.train.crm.common.exception.ResourceNotFoundException;
import com.meessiom.train.crm.customer.model.Customer;
import com.meessiom.train.crm.customer.model.Rating;
import com.meessiom.train.crm.customer.repository.CustomerRepository;
import com.meessiom.train.crm.customer.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // 查询所有
    public List<Rating> getAllRating(){
        return ratingRepository.findAll();
    }

    // 添加
    public Rating createRating(Rating rating){

        return ratingRepository.save(rating);
    }

    // 通过id查找
    public Rating getRatingById(long id){
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating not exist with id" + id));
        return rating;
    }
    //    public List<Customer> findCustomerByNameLikeAndPhoneLikeAndAddressLike(String name,String phone,String address){
//        return customerRepository.findCustomerByNameLikeAndPhoneLikeAndAddressLike(name,phone,address);
//    }
//    public String getRatingNameByRatingId(long id){
//        String customerName = customerRepository.getCustomerNameByCustomerId(id);
//        return customerName;
//    }
    // rating更新。
    public Rating updateRating(long id, Rating ratingDetails){
        Rating updateRating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("rating not exist with id" + id));
        updateRating.setRatingName(ratingDetails.getRatingName());
        updateRating.setRatingNum(updateRating.getRatingNum());
        updateRating.setRatingPlan(updateRating.getRatingPlan());
        updateRating.setRatingStatus(updateRating.getRatingStatus());
        updateRating.setRatingRange(updateRating.getRatingRange());

        ratingRepository.save(ratingDetails);
        return ratingDetails;
    }

    // rating删除。若删除失败抛出异常信息
    public void deleteRating(long id){
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("rating not exist with id" + id));

        ratingRepository.delete(rating);
    }
}

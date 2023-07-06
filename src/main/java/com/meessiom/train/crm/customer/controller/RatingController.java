package com.meessiom.train.crm.customer.controller;

import com.meessiom.train.crm.customer.model.Customer;
import com.meessiom.train.crm.customer.model.Rating;
import com.meessiom.train.crm.customer.repository.CustomerRepository;
import com.meessiom.train.crm.customer.service.CustomerService;
import com.meessiom.train.crm.customer.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

//    @Autowired
//    private CustomerRepository customerRepository;

    // 查找所有
    @GetMapping
    public List<Rating> getAllRating(){
        return ratingService.getAllRating();
    }

    // 添加，包装的类不需要填写id值
    @PostMapping
    public Rating createRating( Rating rating){
        return ratingService.createRating(rating);
    }

    //根据id查找rating类
    @GetMapping("{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable long id){
        Rating rating = ratingService.getRatingById(id);
        return ResponseEntity.ok(rating);
    }
//    @GetMapping("/findByNameAndPhoneAndAddress/")
//    public List<Customer> findCustomerByNameLikeAndPhoneLikeAndAddressLike (@RequestParam("name") String name,@RequestParam("phone") String phone,@RequestParam("address")String address){
//        return customerRepository.findCustomerByCustomerNameLikeAndCustomerPhoneLikeAndCustomerAddressLike("%"+name+"%","%"+phone+"%","%"+address+"%");
//    }
//    @GetMapping("/getCustomerNameById/{id}")
//    public String getCustomerNameByCustomerId( @PathVariable long id){
//        String customerName = customerService.getCustomerNameByCustomerId(id);
//        return customerName;
//    }
    // 更新数据，没有回显功能
    @PutMapping("{id}")
    public ResponseEntity<Rating> deleteRating(@PathVariable long id, Rating ratingDetails){
        Rating updateRating = ratingService.updateRating(id,ratingDetails);

        return ResponseEntity.ok(updateRating);
    }

    // Build delete customer REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable long id){
        ratingService.deleteRating(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

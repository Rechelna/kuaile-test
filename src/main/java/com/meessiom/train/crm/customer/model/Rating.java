package com.meessiom.train.crm.customer.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rating_Name")
    private  String ratingName;

    @Column(name="rating_Range")
    private String ratingRange;

    @Column(name="rating_Num")
    private String ratingNum;

    @Column(name = "rating_Plan")
    private  int ratingPlan;

    @Column(name="rating_Status")
    private int ratingStatus;



}
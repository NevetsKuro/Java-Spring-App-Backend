package com.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    int id;
    private String name;
    private String rating;
    private String released;
    private String description;
    private Double Price;
    private String Quality;
    private String likes;
    private String coll_Type; //Collection Type
    private String discount;
    private int top_lists;

    private Date proddate;
    private int Stock;
    private int time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sid")
    private Supplier supplier;

    @Transient
    MultipartFile file;

    private String imgname;

    @Lob
    @Column(name = "movie_image", nullable = false, columnDefinition = "mediumblob")
    private Blob image;
    
    
    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getColl_Type() {
        return coll_Type;
    }

    public void setColl_Type(String coll_Type) {
        this.coll_Type = coll_Type;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getTop_lists() {
        return top_lists;
    }

    public void setTop_lists(int top_lists) {
        this.top_lists = top_lists;
    }
    
    public Blob getImage() {
        return  image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getQuality() {
        return Quality;
    }

    public void setQuality(String quality) {
        Quality = quality;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getProddate() {
        return proddate;
    }

    public void setProddate(Date proddate) {
        this.proddate = proddate;
    }
}

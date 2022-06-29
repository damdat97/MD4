package com.example.mini_thuenha.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @Min(value=1, message = "Không được nhập thấp hơn 1")
    @Max(value = 10, message = "Không được nhập quá 10")
    private int bedroom;

    @Min(value=1, message = "Không được nhập thấp hơn 1")
    @Max(value = 3, message = "Không được nhập quá 3")
    private int bathroom;

    private Double price;

    @Lob
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    public Home() {
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String file) {
        this.image = file;
    }
}

package com.work.bhaskar.myappretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostRegister {

   @SerializedName("name")
   // @Expose
    private String name;
  //  @SerializedName("mobile")
  //  @Expose
    private String mobile;
    @SerializedName("email")
  //  @Expose
    private String email;
   //@SerializedName("password")
  //  @Expose
    private String password;
    @SerializedName("id")
//    @Expose
    private Integer id = 1;

    private String gender;

    public PostRegister(String name, String mobile, String email, String password, Integer id, String gender) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.id = id;
        this.gender = gender;
    }
    public PostRegister(String name, String email, Integer id, String gender) {
        this.name = name;
        this.mobile = "1";
        this.email = email;
        this.password =  "1";
        this.id = id;
        this.gender = gender;
    }

    public String getName() {
        return name;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "name='" + name + '\'' +
                ", phone='" + mobile + '\'' +
                ", email=" + email +
                ", password=" + password +
                ", password=" + id +
                '}';
    }
}
package com.prdadmin;

/**
 * Created by Naenae XPS on 4/26/2018.
 */

public class UserList {

    String name, phone, address, image;

    public UserList(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserList(String name, String phone, String address, String image) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }
}

package com.prdadmin;

/**
 * Created by Naenae XPS on 4/26/2018.
 */

public class RequestList {

    String name, phone, address, amount;

    public RequestList(){

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

    public String getAmount() {

        return amount;
    }

    public void setAmount(String image) {

        this.amount = image;
    }

    public RequestList(String name, String phone, String address, String amount) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.amount = amount;
    }

}

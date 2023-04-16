// trainer1.java

package com.example.fitnezzgekzzp;

public class trainer1 {
    private String name;
    private String email;
    private int image;
    private String phoneNumber;

    public trainer1(String name, String email, int image, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.image = image;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getImage() {
        return image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

package com.example.fitnezzgekzzp;
public class User {
    private String name;
    private String mobile;
    private String email;
    private String imageUrl; // Add this new field

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String name, String mobile, String email, String imageUrl) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

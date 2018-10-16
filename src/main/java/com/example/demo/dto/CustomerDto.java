package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CustomerDto {

    @NotNull
    @Size(min=1)
    private String name;

    @NotNull
    @Email
    private String email;

    public CustomerDto(@NotNull @Size(min = 1) String name, @NotNull @Email String email) {
        this.name = name;
        this.email = email;
    }

    public CustomerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

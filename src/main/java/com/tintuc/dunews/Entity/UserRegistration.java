package com.tintuc.dunews.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

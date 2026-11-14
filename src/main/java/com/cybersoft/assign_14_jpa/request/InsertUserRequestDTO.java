package com.cybersoft.assign_14_jpa.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InsertUserRequestDTO {

    @NotBlank
    private String username;

    @Email
    private String email;

    @Size(min = 6)
    private String password;
}

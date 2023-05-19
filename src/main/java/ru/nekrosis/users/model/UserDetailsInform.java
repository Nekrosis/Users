package ru.nekrosis.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsInform {
    private String name;
    private String lastName;
    private String patronymic;
    private String email;
    private Long numberPhone;
}

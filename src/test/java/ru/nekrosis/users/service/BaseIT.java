package ru.nekrosis.users.service;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.nekrosis.users.model.User;
import ru.nekrosis.users.model.UserDetailsInform;
import ru.nekrosis.users.repository.UserRepository;

import java.time.LocalDate;

@SpringBootTest
public class BaseIT {
    final Long ID = 132L;
    User user;

    UserDetailsInform userDetailsInform;
    @Mock
    UserRepository repository;
    @InjectMocks
    UserService service;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(ID);
        user.setName("Maxim");
        user.setLastName("Petrov");
        user.setPatronymic("Michalovich");
        user.setBirthday(LocalDate.parse("2023-11-09"));
        user.setNumberPhone(8921432121L);
        user.setEmail("test@mail.ru");

        userDetailsInform = new UserDetailsInform();
        userDetailsInform.setNumberPhone(user.getNumberPhone());
        userDetailsInform.setEmail(user.getEmail());
        userDetailsInform.setName(user.getName());
        userDetailsInform.setLastName(user.getLastName());
        userDetailsInform.setPatronymic(user.getPatronymic());
    }
}

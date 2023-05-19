package ru.nekrosis.users.service;

import org.junit.jupiter.api.Test;
import ru.nekrosis.users.model.User;
import ru.nekrosis.users.model.UserDetailsInform;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class UserServiceTest extends BaseIT {
    @Test
    void testGetAllUsers() {
        List<User> expectedList = new ArrayList<>();
        User firstUser = new User();
        User secondUser = new User();
        expectedList.add(firstUser);
        expectedList.add(secondUser);
        when(repository.findAll()).thenReturn(expectedList);
        List<User> actualList = service.getAll();
        assertThat(actualList).isEqualTo(expectedList);
        verify(repository, times(1)).findAll();
    }

    @Test
    void testSaveUser() {
        when(repository.save(user)).thenReturn(user);
        service.save(user);
        verify(repository, times(1)).save(user);
    }

    @Test
    void testFindById() {
        User user1 = null;
        when(repository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        Optional<User> expectUser = service.info(user.getId());
        if (expectUser.isPresent()) {
            user1 = expectUser.get();
        }
        assertThat(user).isEqualTo(user1);
        verify(repository, times(1)).findById(user.getId());
    }

    @Test
    void testFindByContactInform() {
        when(repository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        UserDetailsInform expectUser = service.contactInfo(user.getId());
        assertThat(userDetailsInform).isEqualTo(expectUser);
        verify(repository, times(1)).findById(user.getId());
    }

    @Test
    void testDeleteById() {
        when(repository.getReferenceById(ID)).thenReturn(user);
        service.delete(ID);
        verify(repository, times(1)).deleteById(ID);
    }
}

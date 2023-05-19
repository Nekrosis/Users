package ru.nekrosis.users.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nekrosis.users.model.User;
import ru.nekrosis.users.model.UserDetailsInform;
import ru.nekrosis.users.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDetailsInform userDetailsInform = new UserDetailsInform();
    @Autowired
    private UserRepository repository;

    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Transactional
    public List<User> getAll() {
        return repository.findAll();
    }
//Details information for User
    @Transactional
    public Optional<User> info(Long id) {
        return repository.findById(id);
    }
//Contact information for User
 @Transactional
    public UserDetailsInform contactInfo(Long id) {
        Optional<User> user = repository.findById(id);
        userDetailsInform.setName(user.get().getName());
        userDetailsInform.setLastName(user.get().getLastName());
        userDetailsInform.setPatronymic(user.get().getPatronymic());
        userDetailsInform.setEmail(user.get().getEmail());
        userDetailsInform.setNumberPhone(user.get().getNumberPhone());
        return userDetailsInform;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}

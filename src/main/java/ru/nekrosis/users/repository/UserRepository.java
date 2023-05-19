package ru.nekrosis.users.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.nekrosis.users.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

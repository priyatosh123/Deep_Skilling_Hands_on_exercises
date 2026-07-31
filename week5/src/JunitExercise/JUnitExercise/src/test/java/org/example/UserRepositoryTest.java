package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        // Arrange
        User user = new User(10L, "David");
        userRepository.save(user);

        // Act
        List<User> results = userRepository.findByName("David");

        // Assert
        assertEquals(1, results.size());
        assertEquals("David", results.get(0).getName());
    }
}
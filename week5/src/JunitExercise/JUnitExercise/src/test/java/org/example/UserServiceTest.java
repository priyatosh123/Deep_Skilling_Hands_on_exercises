package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById(){
        User user=new User(1L,"Ananya");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User res=userService.getUserById(1L);

        assertNotNull(res);
        assertEquals("Ananya",res.getName());
        verify(userRepository).findById(1L);
    }

    @Test
    public void testGetUserByIdOrThrow_ThrowsException(){
        when(userRepository.findById(99l)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> {
            userService.getUserByIdOrThrow(99L);
        });
    }
}

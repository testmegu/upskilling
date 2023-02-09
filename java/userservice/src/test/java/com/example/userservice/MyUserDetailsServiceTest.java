package com.example.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MyUserDetailsService.class})
@ExtendWith(SpringExtension.class)
public class MyUserDetailsServiceTest {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testLoadUserByUsername() throws UsernameNotFoundException {
        UserModel userModel = new UserModel();
        userModel.setFirstName("asdfgj");
        userModel.setLastName("asdfgj");
        userModel.setActive(true);
        userModel.setPassword("asdfghj");
        userModel.setEmail("asdfgh@example.org");
        userModel.setRoles("Roles");
        userModel.setUsername("asdfghj");

        Optional<UserModel> ofResult = Optional.<UserModel>of(userModel);
        when(this.userRepository.findByUserName(anyString())).thenReturn(ofResult);
        UserDetails actualLoadUserByUsernameResult = this.myUserDetailsService.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertEquals("asdfghj", actualLoadUserByUsernameResult.getPassword());
        assertEquals("asdfghj", actualLoadUserByUsernameResult.getUsername());
        assertEquals("Roles",
                ((ArrayList<? extends GrantedAuthority>) actualLoadUserByUsernameResult.getAuthorities()).get(0)
                        .getAuthority());
        verify(this.userRepository).findByUserName(anyString());
    }

    @Test
    public void testLoadUserByUsername2() throws UsernameNotFoundException {
        UserModel userModel = new UserModel();
        userModel.setLastName("asdfghj");
        userModel.setActive(true);
        userModel.setPassword("asdfghj");
        userModel.setEmail("asdfghj@example.org");
        userModel.setRoles("");
        userModel.setUsername("asdfghj");
        userModel.setFirstName("asdfghj");
        Optional<UserModel> ofResult = Optional.<UserModel>of(userModel);
        when(this.userRepository.findByUserName(anyString())).thenReturn(ofResult);
        this.myUserDetailsService.loadUserByUsername("asdfghj");
        verify(this.userRepository).findByUserName(anyString());
    }

    @Test
    public void testLoadUserByUsername3() throws UsernameNotFoundException {
        when(this.userRepository.findByUserName(anyString())).thenReturn(Optional.<UserModel>empty());
        assertThrows(UsernameNotFoundException.class, () -> this.myUserDetailsService.loadUserByUsername("janedoe"));
        verify(this.userRepository).findByUserName(anyString());
    }
}


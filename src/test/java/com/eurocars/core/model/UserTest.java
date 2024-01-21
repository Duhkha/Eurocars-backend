package com.eurocars.core.model;

import com.eurocars.core.model.enums.UserType;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class UserTest {

    @Test
    void shouldCompareTwoUsers() {
        User user1 = new User();
        user1.setId("someId");
        user1.setUserType(UserType.ADMIN);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john@example.com");
        user1.setPassword("password123");
        user1.setPhone("1234567890");
        user1.setCreationDate(new Date());

        User user2 = new User();
        user2.setId("someId");
        user2.setUserType(UserType.ADMIN);
        user2.setFirstName("John");
        user2.setLastName("Doe");
        user2.setEmail("john@example.com");
        user2.setPassword("password123");
        user2.setPhone("1234567890");
        user2.setCreationDate(user1.getCreationDate());

        assertThat(user1)
                .usingRecursiveComparison()
                .isEqualTo(user2);
    }

    @Test
    void testUserIdGetterSetter() {
        User user = new User();
        String id = "12345";
        user.setId(id);
        assertEquals(id, user.getId());
    }

    @Test
    void testUserTypeGetterSetter() {
        User user = new User();
        UserType userType = UserType.ADMIN;
        user.setUserType(userType);
        assertEquals(userType, user.getUserType());
    }

    @Test
    void testFirstNameGetterSetter() {
        User user = new User();
        String firstName = "John";
        user.setFirstName(firstName);
        assertEquals(firstName, user.getFirstName());
    }

    @Test
    void testLastNameGetterSetter() {
        User user = new User();
        String lastName = "Doe";
        user.setLastName(lastName);
        assertEquals(lastName, user.getLastName());
    }

    @Test
    void testEmailGetterSetter() {
        User user = new User();
        String email = "john@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testPasswordGetterSetter() {
        User user = new User();
        String password = "password123";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPhoneGetterSetter() {
        User user = new User();
        String phone = "1234567890";
        user.setPhone(phone);
        assertEquals(phone, user.getPhone());
    }

    @Test
    void testCreationDateGetterSetter() {
        User user = new User();
        Date now = new Date();
        user.setCreationDate(now);
        assertEquals(now, user.getCreationDate());
    }

    @Test
    void testUserAuthorities() {
        User user = new User();
        user.setUserType(UserType.ADMIN);
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        assertTrue(authorities.stream().anyMatch(a -> a.getAuthority().equals("ADMIN")));
    }

    @Test
    void testIsAccountNonExpired() {
        User user = new User();
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        User user = new User();
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        User user = new User();
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        User user = new User();
        assertTrue(user.isEnabled());
    }
}

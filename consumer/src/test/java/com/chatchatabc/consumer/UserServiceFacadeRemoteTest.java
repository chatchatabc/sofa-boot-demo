package com.chatchatabc.consumer;

import com.chatchatabc.user.User;
import com.chatchatabc.user.UserServiceFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceFacadeRemoteTest extends SofaBootBaseTest {
    @Autowired
    private UserServiceFacade userServiceFacade;

    @Test
    public void testFindById() {
        final User user = userServiceFacade.findById(1L);
        assertThat(user).isNotNull();
    }
}

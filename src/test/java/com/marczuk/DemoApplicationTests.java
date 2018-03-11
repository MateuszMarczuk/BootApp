package com.marczuk;

import com.marczuk.entity.Task;
import com.marczuk.entity.User;
import com.marczuk.services.TaskService;
import com.marczuk.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskService taskService;


    @Before
    public void initDb(){
        {
            User newUser = new User("asdasd@gmail.com","nowyUser","123456");
            userService.createUser(newUser);
        }
        {
            User adminUser = new User("admin@gmail.com", "asdasd", "222222");
            userService.createAdmin(adminUser);
        }

        Task userTask = new Task("14/03/2018","00:11","12:00","description");
        User user = userService.findOneByEmail("asdasd@gmail.com");
        taskService.addTask(userTask,user);
    }

    @Test
    public void testUser(){
        User user = userService.findOneByEmail("asdasd@gmail.com");
        assertNotNull(user);
        User admin = userService.findOneByEmail("admin@gmail.com");
        assertEquals(admin.getEmail(),"admin@gmail.com" );
    }

    @Test
    public void testTask(){
        User user = userService.findOneByEmail("asdasd@gmail.com");
        List<Task> task = taskService.findUserTask(user);
        assertNotNull(task);
    }

}

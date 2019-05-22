package edu.sg.web.ecomm.repository;

import edu.sg.web.ecomm.domain.UserLogin;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.User;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = { "classpath:spring-config-test.xml" })
@Rollback
public class UserLoginRepositoryIT {

  @Autowired
  private UserLoginRepository repository;

  @Test
  public void test() {
    List<UserLogin> users = repository.findAll();
    for (UserLogin user : users) {
      System.out.println("username = " + user.getName());
    }
  }

  @Test
  public void test1() {
    Optional<UserLogin> user = repository.findByPassword("1234");
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
  }

  @Test
  public void test2() {
    Optional<UserLogin> user = repository.findByName("thi123");
    Assert.assertThat(user.isPresent(), CoreMatchers.is(true));
  }

}

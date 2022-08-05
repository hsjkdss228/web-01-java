package utils;

import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.UserRepository;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LoginFormCheckerTest {
  // 오류 케이스
  // - 모든 데이터를 입력하지 않았을 경우
  // - 사용자 아이디가 존재하지 않을 경우
  // - 비밂번호가 틀렸을 경우
  private UserRepository userRepository;

  @BeforeEach
  void initialize() {
    userRepository = new UserRepository();

    userRepository.addUser(
        new User("황인우", "hsjkdss228", "dlsdn12", "hsjkdss228@naver.com"));
    userRepository.addUser(
        new User("김인우", "dhkddlsgn228", "dlsdn12", "dhkddlsgn228@gmail.com"));
    userRepository.addUser(
        new User("이인우", "innu3368", "dlsdn12", "innu3368@instagram.com"));
  }

  @Test
  void checkNormalForm() {
    LoginFormChecker loginFormChecker
        = new LoginFormChecker(userRepository);

    Map<String, String> formData = new HashMap<>();
    formData.put("id", "hsjkdss228");
    formData.put("password", "dlsdn12");

    String status = loginFormChecker.check(formData);

    assertEquals(LoginFormChecker.ACCEPTED, status);
  }

  @Test
  void checkEmptyIdForm() {
    LoginFormChecker loginFormChecker
        = new LoginFormChecker(userRepository);

    Map<String, String> formData = new HashMap<>();
    formData.put("password", "dlsdn12");

    String status = loginFormChecker.check(formData);

    assertEquals(LoginFormChecker.INSUFFICIENT_LOGIN_INPUTS, status);
  }

  @Test
  void checkEmptyPasswordForm() {
    LoginFormChecker loginFormChecker
        = new LoginFormChecker(userRepository);

    Map<String, String> formData = new HashMap<>();
    formData.put("id", "hsjkdss228");

    String status = loginFormChecker.check(formData);

    assertEquals(LoginFormChecker.INSUFFICIENT_LOGIN_INPUTS, status);
  }

  @Test
  void notExistingId() {
    LoginFormChecker loginFormChecker
        = new LoginFormChecker(userRepository);

    Map<String, String> formData = new HashMap<>();
    formData.put("id", "chikorita");
    formData.put("password", "dlsdn12");

    String status = loginFormChecker.check(formData);

    assertEquals(LoginFormChecker.NOT_EXISTING_ID, status);
  }

  @Test
  void incorrectPassword() {
    LoginFormChecker loginFormChecker
        = new LoginFormChecker(userRepository);

    Map<String, String> formData = new HashMap<>();
    formData.put("id", "hsjkdss228");
    formData.put("password", "hwaseonggazua");

    String status = loginFormChecker.check(formData);

    assertEquals(LoginFormChecker.INCORRECT_PASSWORD, status);
  }
}

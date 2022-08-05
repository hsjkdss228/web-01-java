package pages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new RegistrationPageGenerator();

    String content = pageGenerator.content();

    assertTrue(
        content.contains("<h2>회원가입</h2>"),
        "회원가입 제목 오류\n" + content);
    assertTrue(
        content.contains("이름"),
        "이름 메세지 및 입력란 오류\n" + content);
    assertTrue(
        content.contains("아이디"),
        "아이디 메세지 및 입력란 오류\n" + content);
    assertTrue(
        content.contains("비밀번호"),
        "비밀번호 메세지 및 입력란 오류\n" + content);
    assertTrue(
        content.contains("비밀번호 재확인"),
        "비밀번호 재확인 메세지 및 입력란 오류\n" + content);
    assertTrue(
        content.contains("이메일"),
        "이메일 메세지 및 입력란 오류\n" + content);
    assertTrue(
        content.contains("<button type=\"submit\">회원가입"),
        "회원가입 버튼 오류\n" + content);
  }
}

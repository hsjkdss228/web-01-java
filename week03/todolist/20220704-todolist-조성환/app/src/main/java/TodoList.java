import repository.TasksRepository;

import javax.swing.*;
import java.awt.*;
public class TodoList {
  private JFrame frame;
  private JPanel mainPanel;
  private JPanel titlePanel;
  private JPanel contentPanel;
  private TasksRepository tasksRepository;
  private JTextField textField;

  public static void main(String[] args) {
    TodoList appliaction = new TodoList();
    appliaction.run();
  }

  private void run() {
    tasksRepository = new TasksRepository();
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(350, 500);

    initTitlePanel();
    initFormPanel();
    initContentPanel();

    frame.setVisible(true);
  }

  private void initTitlePanel() {
    titlePanel = new JPanel();
    JLabel titleLabel = new JLabel("할 일 목록");
    titlePanel.add(titleLabel, BorderLayout.PAGE_START);
    frame.add(titlePanel, BorderLayout.PAGE_START);
    titlePanel.setBackground(Color.pink);
  }

  private void initFormPanel() {
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    initMenuPanel();
    frame.add(mainPanel);
    mainPanel.setBackground(Color.blue);
  }

  private void initMenuPanel() {
    JPanel menuPanel = new JPanel();
    menuPanel.add(new JLabel("할 일"));

    textField = new JTextField(10);
    menuPanel.add(textField);

    menuPanel.add(createAddTodoButton());
    mainPanel.add(menuPanel, BorderLayout.PAGE_START);
    menuPanel.setBackground(Color.gray);
  }

  private JButton createAddTodoButton() {
    JButton button = new JButton("추가");
    button.addActionListener(event -> {
      tasksRepository.send(textField.getText());
      TodoPanel todoPanel = new TodoPanel(tasksRepository);
      showContentPanel(todoPanel);
    });
    return button;
  }

  private void showContentPanel(JPanel panel) {
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }

  private void initContentPanel() {
    contentPanel = new JPanel();
    contentPanel.setLayout(new GridLayout(tasksRepository.tasks(), 1));
    mainPanel.add(contentPanel);
    contentPanel.setBackground(Color.cyan);
  }
}

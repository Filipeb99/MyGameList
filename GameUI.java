import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class GameUI {
    private JFrame window = null;
    private JPanel panel = null;
    private JTextField nameField = null;
    private JTextField developerField = null;
    private JTextField statusField = null;
    private JToolBar toolbar = null;
    private JButton addButton = null;
    private JButton cancelButton = null;
    
    public GameUI() {
        this("Name", "Developer", "Status");
    }
    public GameUI(String name, String developer, String status) {
        window = new JFrame();
        
        panel = new JPanel();
        nameField = new JTextField(name);
        developerField = new JTextField(developer);
        statusField = new JTextField(status);
        
        panel.add(nameField);
        panel.add(developerField);
        panel.add(statusField);
        
        toolbar = new JToolBar();
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        
        toolbar.add(addButton);
        toolbar.add(Box.createGlue());
        toolbar.add(cancelButton);
        
        window.add(panel, BorderLayout.CENTER);
        window.add(toolbar, BorderLayout.SOUTH);
        
        window.pack();
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public String getName() {
        return nameField.getText();
    }
    public String getDeveloper() {
        return developerField.getText();
    }
    public String getStatus() {
        return statusField.getText();
    }
    public void setAddFunc(ActionListener addFunc) {
        addButton.addActionListener(addFunc);
    }
    public void setCancelFunc(ActionListener cancelFunc) {
        cancelButton.addActionListener(cancelFunc);
    }
    
    public void start() {
        window.setVisible(true);
    }
    public void stop() {
        window.dispose();
    }
}

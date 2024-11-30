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
    private GameList gameList = null;
    
    private JFrame window = null;
    private JPanel panel = null;
    private JTextField nameField = null;
    private JTextField developerField = null;
    private JTextField statusField = null;
    private JToolBar toolbar = null;
    private JButton addButton = null;
    private JButton cancelButton = null;
    
    public GameUI(GameList gameList) {
        this(gameList, "Name", "Developer", "Status");
    }
    public GameUI(GameList gameList, String name, String developer, String status) {
        this.gameList = gameList;
        
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
        
        setAddFunc();
        setCancelFunc();
        
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
    
    private void setAddFunc() {
        ActionListener addFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement add functionality
                window.dispose();
            }
        };
        addButton.addActionListener(addFunc);
    }
    private void setCancelFunc() {
        ActionListener cancelFunc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        };
        cancelButton.addActionListener(cancelFunc);
    }
    public void start() {
        window.setVisible(true);
    }
}

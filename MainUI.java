import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JButton;

public class MainUI {
    private JFrame window = null;
    private JTable table = null;
    private JScrollPane scrollPane = null;
    private JToolBar toolbar = null;
    private JButton addButton = null;
    private JButton saveButton = null;
    
    public MainUI(Object[][] data, String[] colNames, String title) {
        window = new JFrame(title);
        
        table = new JTable(data, colNames);
        scrollPane = new JScrollPane(table);
        
        toolbar = new JToolBar();
        addButton = new JButton("Add");
        saveButton = new JButton("Save");
        
        toolbar.add(addButton);
        toolbar.add(saveButton);
        
        window.add(scrollPane, BorderLayout.CENTER);
        window.add(toolbar, BorderLayout.SOUTH);
        
        window.pack();
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void run() {
        window.setVisible(true);
    }
}

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MainUI {
    private JFrame window = null;
    private JTable table = null;
    private JScrollPane container = null;
    
    public MainUI(Object[][] data, String[] colNames, String title) {
        window = new JFrame(title);
        
        table = new JTable(data, colNames);
        container = new JScrollPane(table);
        
        window.add(container);
        
        window.pack();
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void run() {
        window.setVisible(true);
    }
}

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MainUI {
    private JFrame window = null;
    private JScrollPane container = null;
    private JTable table = null;
    
    public MainUI(Object[][] data, String[] colNames, String title) {
        table = new JTable(data, colNames);
        container = new JScrollPane(table);
        window = new JFrame();
        window.setTitle(title);
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

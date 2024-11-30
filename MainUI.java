import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.AbstractTableModel;

public class MainUI {
    private JFrame window = null;
    private JScrollPane scrollPane = null;
    private JTable table = null;
    private JToolBar toolbar = null;
    private JButton newButton = null;
    private JButton saveButton = null;
    
    public MainUI(AbstractTableModel tableModel, String title) {
        window = new JFrame(title);
        
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        toolbar = new JToolBar();
        newButton = new JButton("New");
        saveButton = new JButton("Save");
        
        toolbar.add(newButton);
        toolbar.add(Box.createGlue());
        toolbar.add(saveButton);
        
        window.add(scrollPane, BorderLayout.CENTER);
        window.add(toolbar, BorderLayout.SOUTH);
        
        window.pack();
        window.setResizable(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void setNewFunc(ActionListener newFunc) {
        newButton.addActionListener(newFunc);
    }
    public void setSaveFunc(ActionListener saveFunc) {
        saveButton.addActionListener(saveFunc);
    }
    public void refreshTableData() {
        table.revalidate();
    }
    public void start() {
        window.setVisible(true);
    }
}

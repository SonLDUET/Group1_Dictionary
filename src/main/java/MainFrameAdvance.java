import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameAdvance extends JFrame {
    public static Dictionary dictionary = new Dictionary();
    public static DictionaryManagement dictionaryManagement = new DictionaryManagement(dictionary);

    public static boolean checkAdd = true;
    public static boolean emptyAdd = false;
    public static boolean removeCheck = false;
    public static boolean editCheck = false;

    private JPanel leftPanel = new JPanel();
    private JPanel rightPanel = new JPanel();
    public static JTextArea searchBox = new JTextArea("Search",3, 25);
    public static JTextArea searchResultBox = new JTextArea(25,25);



    private JTextField editBox1 = new JTextField(23);
    private JTextField editBox2 = new JTextField(23);
    private JTextField editBox3 = new JTextField(23);
    private JTextField addBox1 = new JTextField(23);
    private JTextField addBox2 = new JTextField(23);
    private JTextField removeBox = new JTextField(23);

    private JButton searchButton = new JButton("");
    private JButton addButton = new JButton("");
    private JButton editButton = new JButton("");
    private JButton saveButton = new JButton("");
    private JButton removeButton = new JButton("");

    private JLabel searchResultLabel = new JLabel("Result");
    private JLabel addLabel1 = new JLabel("ADD WORD");
    private JLabel addLabel2 = new JLabel("ADD MEAN");
    private JLabel editLabel1 = new JLabel("WORD EDIT");
    private JLabel editLabel2 = new JLabel("NEW EDIT");
    private JLabel editLabel3 = new JLabel("NEW MEAN");
    private JLabel removeLabel = new JLabel("WORD REMOVE");

    public MainFrameAdvance() {
        super("Group_1_Dictionary");
        ImageIcon image = new ImageIcon("images/logo.png");
        this.setIconImage(image.getImage());
        dictionaryManagement.insertFromFile();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800,600));
        this.setLayout(null);
        this.setResizable(false);
        ImageIcon loopicon = new ImageIcon("images/search.png");
        ImageIcon plusicon = new ImageIcon("images/plus.png");
        ImageIcon editicon = new ImageIcon("images/edit.png");
        ImageIcon trashicon = new ImageIcon("images/trash.png");
        ImageIcon saveicon = new ImageIcon("images/save.png");

        addButton.setBounds(30,20,40,40);
        addButton.setIcon (plusicon);
        editButton.setBounds(30,180,40,40);
        editButton.setIcon (editicon);
        saveButton.setBounds(290,20,40,40);
        saveButton.setIcon (saveicon);
        removeButton.setBounds(30,320,40,40);
        removeButton.setIcon (trashicon);
        searchButton.setBounds(250,20,40,40);
        searchButton.setIcon (loopicon);
        searchBox.setBounds(50,20,200,40);
        searchBox.setBackground(Color.WHITE);
        searchBox.setForeground(new Color(255, 124, 8));
        searchResultBox.setBounds(40,120,300,400);
        searchResultBox.setBackground(new Color (146,143,143));
        removeBox.setBounds(200,330,160,20);
        removeBox.setBackground(new Color(77,72,57));
        removeBox.setForeground(new Color(255, 124, 8));
        removeBox.setCaretColor(Color.ORANGE);
        editBox1.setBounds(200,160,160,20);
        editBox1.setForeground(new Color(255, 124, 8));
        editBox1.setBackground(new Color(77,72,57));
        editBox1.setCaretColor(Color.ORANGE);
        editBox2.setBounds(200,190,160,20);
        editBox2.setForeground(new Color(255, 124, 8));
        editBox2.setBackground(new Color(77,72,57));
        editBox2.setCaretColor(Color.ORANGE);
        editBox3.setBounds(200,220,160,20);
        editBox3.setBackground(new Color(77,72,57));
        editBox3.setForeground(new Color(255, 124, 8));
        editBox3.setCaretColor(Color.ORANGE);
        addBox1.setBounds(200,10,160,20);
        addBox1.setBackground(new Color(77,72,57));
        addBox1.setForeground(new Color(255, 124, 8));
        addBox1.setCaretColor(Color.ORANGE);
        addBox2.setBounds(200,50,160,20);
        addBox2.setBackground(new Color(77,72,57));
        addBox2.setForeground(new Color(255, 124, 8));
        addBox2.setCaretColor(Color.ORANGE);
        addLabel1.setBounds(100,10,70,20);
        addLabel1.setFont (new Font ("Arial", Font.PLAIN,12));
        addLabel1.setForeground(new Color(255, 124, 8));
        addLabel2.setBounds(100,50,70,20);
        addLabel2.setFont (new Font ("Arial", Font.PLAIN,12));
        addLabel2.setForeground(new Color(255, 124, 8));
        editLabel1.setBounds(100,160,70,20);
        editLabel1.setFont (new Font ("Arial", Font.PLAIN,12));
        editLabel1.setForeground(new Color(255, 124, 8));
        editLabel2.setBounds(100,190,70,20);
        editLabel2.setFont (new Font ("Arial", Font.PLAIN,12));
        editLabel2.setForeground(new Color(255, 124, 8));
        editLabel3.setBounds(100,220,120,20);
        editLabel3.setFont (new Font ("Arial", Font.PLAIN,12));
        editLabel3.setForeground(new Color(255, 124, 8));
        removeLabel.setBounds(100,330,120,20);
        removeLabel.setFont (new Font ("Arial", Font.PLAIN,12));
        removeLabel.setForeground(new Color(255, 124, 8));
        searchResultLabel.setBounds(150,90,70,20);
        searchResultLabel.setFont (new Font ("Arial", Font.PLAIN,20));
        searchResultLabel.setForeground(new Color (255, 124, 8));
        leftPanel.setBounds(0,0,390,600);
        leftPanel.setBackground(new Color(77,72,57));
        leftPanel.setLayout(null);
        leftPanel.add(searchBox);
        leftPanel.add(searchButton);
        leftPanel.add(searchResultBox);
        leftPanel.add(searchResultLabel);
        leftPanel.add(saveButton);

        rightPanel.setBounds(395,0,405,600);
        rightPanel.setBackground(new Color(77,72,57));
        rightPanel.setLayout(null);
        rightPanel.add(addButton);
        rightPanel.add(editButton);
        rightPanel.add(editBox1);
        rightPanel.add(editBox2);
        rightPanel.add(editBox3);
        rightPanel.add(addBox1);
        rightPanel.add(addBox2);
        rightPanel.add(removeButton);
        rightPanel.add(removeBox);
        rightPanel.add(addLabel1);
        rightPanel.add(addLabel2);
        rightPanel.add(editLabel1);
        rightPanel.add(editLabel2);
        rightPanel.add(editLabel3);
        rightPanel.add(removeLabel);

        this.add(leftPanel);
        this.add(rightPanel);

        this.setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!searchBox.getText().equals("")){
                    String result = dictionaryManagement.dictionarySearcher(searchBox.getText().trim());
                    searchResultBox.setText(result);
                    if(result.equals("")) {
                        searchResultBox.setText("Không có từ nào phù hợp! :))");
                    }
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Word wordAdded = new Word(addBox1.getText(), addBox2.getText());
                if(!addBox1.getText().trim().isEmpty() && !addBox2.getText().trim().isEmpty()) {
                    dictionaryManagement.dictionaryAddWord(wordAdded.getWord_target(), wordAdded.getWord_explain());
                    if(checkAdd) {
                        JOptionPane.showMessageDialog(addButton,"Thêm từ thành công!");
                    } else {
                        checkAdd = true;
                        JOptionPane.showMessageDialog(addButton, "Từ này đã có sẵn\nBạn có thể dùng tính năng Edit");
                    }
                } else JOptionPane.showMessageDialog(addButton, "Từ nhập vào không hợp lệ");
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dictionaryManagement.dictionaryExportToFile("dictionaries.txt");
                JOptionPane.showMessageDialog(saveButton,"Xuất thành công ra file dictionaries.txt!");
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (!removeBox.getText().equals("")) {
                        dictionaryManagement.dictionaryRemoveWord(removeBox.getText());
                        if (removeCheck) {
                            JOptionPane.showMessageDialog(removeButton,"Gỡ từ thành công :))");
                            removeCheck = false;
                        } else  JOptionPane.showMessageDialog(removeButton, "Không có từ nào hợp lệ!");
                    } else JOptionPane.showMessageDialog(removeButton,"Vui lòng nhập từ :))");

            }
        });
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!editBox1.getText().trim().isEmpty() && !editBox2.getText().trim().isEmpty() && !editBox3.getText().trim().isEmpty()) {
                    dictionaryManagement.dictionaryEditWord(editBox1.getText().trim(), editBox2.getText().trim(), editBox3.getText().trim());
                    if (editCheck) {
                        JOptionPane.showMessageDialog(editButton, "Edit thành công!!");
                        editCheck = false;
                    } else JOptionPane.showMessageDialog(editButton,"Không tìm thấy từ!");
                } else JOptionPane.showMessageDialog(editButton,"Vui lòng nhập từ hợp lệ!");
            }
        });
    }

    public static void main(String[] args) {
        new MainFrameAdvance();
    }


}

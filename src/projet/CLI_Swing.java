package projet;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class CLI_Swing {

    private static JFrame frame;
    private static JTextField K_field = new JTextField();
    private static JTextField A_field = new JTextField();
    private static JTextField E_field = new JTextField();
    private static JTextField result_field = new JTextField();
    private static Configuration configuration;

    public static void main(String args[]){
        initPageRank();

        frame = new JFrame("IHM pour CLI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout());

        setupUpBtn();
        setupMainPanel();
        setupBottomField();

        frame.setVisible(true);
        refresh();
    }

    private static void initPageRank() {
        configuration = PageRank.configuration("-K 10 -A .90 -K 20 -P -K 30 -C".split(" "));
    }

    private static void setupBottomField() {
        result_field.setEditable(false);
        frame.add(result_field, BorderLayout.SOUTH);
    }

    private static void setupMainPanel() {
        JPanel mainPanel = new JPanel(new GridLayout(3, 3));
        mainPanel.add(new JLabel("Valeur de l'indice (K)"));
        mainPanel.add(K_field);
        JButton k_plus = new JButton("+");
        k_plus.addActionListener(a -> add_k_value());
        mainPanel.add(k_plus);

        mainPanel.add(new JLabel("Valeur de l'indice (A)"));
        mainPanel.add(A_field);
        JButton a_plus = new JButton("+");
        a_plus.addActionListener(a -> add_a_value());
        mainPanel.add(a_plus);

        mainPanel.add(new JLabel("Valeur de l'indice (E)"));
        mainPanel.add(E_field);
        JButton e_plus = new JButton("+");
        e_plus.addActionListener(a -> add_e_value());
        mainPanel.add(e_plus);

        frame.add(mainPanel, BorderLayout.CENTER);
    }

    private static void add_e_value() {
        configuration.epsilon ++;
        refresh();
    }

    private static void add_a_value() {
        configuration.alpha ++;
        refresh();
    }

    private static void add_k_value() {
        configuration.indice ++;
        refresh();
    }

    private static void refresh() {
        K_field.setText(String.valueOf(configuration.indice));
        A_field.setText(String.valueOf(configuration.alpha));
        E_field.setText(String.valueOf(configuration.epsilon));
        result_field.setText(configuration.toString());
    }

    private static void setupUpBtn() {
        JPanel upPanel = new JPanel(new FlowLayout());
        Button creuse_btn = new Button("Creuse (C)");
        creuse_btn.addActionListener(a-> set_creuse_value());
        Button pleine_btn = new Button("Pleine (P)");
        pleine_btn.addActionListener(a-> set_pleine_value());
        upPanel.add(creuse_btn);
        upPanel.add(pleine_btn);
        frame.add(upPanel, BorderLayout.NORTH);
    }

    private static void set_creuse_value() {
        configuration.mode = Mode.CREUSE;
        refresh();
    }

    private static void set_pleine_value() {
        configuration.mode = Mode.PLEINE;
        refresh();
    }

}

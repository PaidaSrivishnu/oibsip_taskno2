import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Number_Guess_Game extends JFrame
{

    static String user_input;
    static int num;
    JLabel status_label = new JLabel();
    
    static Random r = new Random();
    static int rng;
    static int count = 0;

    public static void Num_Gen() 
    {
        rng = r.nextInt(1,101);
    }

    public static void gameLogic(JLabel j1) 
    {
        num = Integer.parseInt(user_input);

        if(num > rng) 
        {
            if(num - rng <= 15) 
            {
                j1.setText("A bit High. Try Again");
            }
            else 
            {
                j1.setText("Too High. Try Again");
            }
        }
        else if(num < rng) 
        {
            if(rng - num <= 15) 
            {
                j1.setText("A bit Low. Try Again");
            }
            else 
            {
                j1.setText("Too Low. Try Again");
            }
        }
        else if(num == rng) 
        {
            j1.setText("Correct Guess!");
        }
    }

    Number_Guess_Game() 
    {
        setTitle("Random Number Game");
        JLabel j2 = new JLabel("Enter User Guess: ");
        j2.setBounds(20, 50, 300, 20);

        JLabel j3 = new JLabel("Number Generated!");
        j3.setBounds(20, 200, 300, 20);

        JLabel j4 = new JLabel("Number of Tries : " + count);
        j4.setBounds(20, 20, 300, 20);
        
        status_label.setBounds(20, 80, 300, 20);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(140, 140, 100, 30);

        JButton restartButton = new JButton("New Game");
        restartButton.setBounds(20, 140, 100, 30);

        JTextField t1 = new JTextField();
        t1.setBounds(200, 50, 100, 20);

        setLayout(null);
        setLocationRelativeTo(null);
        setSize(400,400);
        add(j2); add(t1); add(status_label); add(submitButton); 
        add(restartButton); add(j4); add(j3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        Num_Gen();

        submitButton.addActionListener((ActionEvent e) -> 
        {
            user_input = t1.getText();
            gameLogic(status_label);
            count++;
            j4.setText("Number of Tries : " + count);
            j3.setVisible(false);
        });

        restartButton.addActionListener((ActionEvent e) ->
        {
            Num_Gen();
            j3.setVisible(true);
            status_label.setText("");
            count = 0;
            j4.setText("Number of Tries : " + count);
        });
    }

    public static void main(String[] args) 
    {
        Number_Guess_Game obj = new Number_Guess_Game();
    }
}
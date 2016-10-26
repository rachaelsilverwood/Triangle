/*
 *   Author: Rachael Silverwood
 *   Date: 10/25/2016
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *   This class displays a GUI and allows the user to input 3 potential sides of a triangle.
 *   It will display whether it's a valid triangle, and the type of triangle.
 *
 */
public class Triangle {

    private TriangleClassifier classifier;
    private JTextField fieldA;
    private JTextField fieldB;
    private JTextField fieldC;
    private int sideA;
    private int sideB;
    private int sideC;

    /*
     *   Constructor.
     *
     *   Creates and displays a JFrame with a JPanel containing the components
     */
    public Triangle(){
        classifier = new TriangleClassifier();
        JFrame frame = new JFrame("Triangles");
        frame.setSize(350, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        frame.add(panel);
        addComponents(panel);

        frame.setVisible(true);
    }



    /*
     *   Creates and adds the components to the JPanel
     *
     *   @param panel to add the components to
     *
     */
    private void addComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel labelA = new JLabel("Side a length:");
        labelA.setBounds(35, 20, 80, 25);
        panel.add(labelA);

        fieldA = new JTextField(10);
        fieldA.setBounds(135, 20, 160, 25);
        panel.add(fieldA);

        JLabel labelB = new JLabel("Side b length:");
        labelB.setBounds(35, 55, 80, 25);
        panel.add(labelB);

        fieldB = new JTextField(10);
        fieldB.setBounds(135, 55, 160, 25);
        panel.add(fieldB);

        JLabel labelC = new JLabel("Side c length:");
        labelC.setBounds(35, 90, 80, 25);
        panel.add(labelC);

        fieldC = new JTextField(10);
        fieldC.setBounds(135, 90, 160, 25);
        panel.add(fieldC);

        JButton go = new JButton("GO");
        go.setBounds(135, 130, 90,30);
        panel.add(go);

        JLabel output = new JLabel();
        output.setBounds(10, 150, 500, 50);
        panel.add(output);


        /*
         *   When the 'Go' button gets clicked, the input will be validated.
         *   If valid, it will convert them to ints and display the type of triangle.
         */
        go.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(validate()){
                    toInt();
                    String outputText = classifier.classify(sideA, sideB, sideC);
                    output.setText(outputText);
                }
                else{
                    output.setText("Invalid Inputs");
                }
            }
        });
    }



    /*
     *   Validate the input
     *
     *   @return true only if all inputs are positive integers
     */
    public boolean validate(){
        if(fieldA.getText().matches("\\d+") && fieldB.getText().matches("\\d+") && fieldC.getText().matches("\\d+")){
            return true;
        }
        else{
            return false;
        }
    }



    /*
     *   Takes the 3 input values and converts them from String to int
     */
    public void toInt(){
        sideA = Integer.parseInt(fieldA.getText());
        sideB = Integer.parseInt(fieldB.getText());
        sideC = Integer.parseInt(fieldC.getText());
    }


    public static void main(String[] args) {
        new Triangle();
    }

}
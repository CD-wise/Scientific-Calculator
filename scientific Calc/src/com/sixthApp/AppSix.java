package com.sixthApp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Pattern;

public class AppSix {
    private JPanel framePanel;
    private JLabel titleLabel;
    private JTextField answerTextField;
    private JRadioButton onRadioButton;
    private JRadioButton offRadioButton;
    private JButton clearAllButton;
    private JButton backSpaceButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton;
    private JButton divisionButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton multiplyButton;
    private JButton minusButton;
    private JButton threeButton;
    private JButton twoButton;
    private JButton oneButton;
    private JButton plusButton;
    private JButton equalButton;
    private JButton pointButton;
    private JButton zeroButton;

    private String operand;
    private double answer;

    public AppSix(){
        //on by default
        onRadioButton.setSelected(true);
        onRadioButton.setEnabled(false);


        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"0");
            }
        });

        oneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"1");
            }
        });

        twoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"2");
            }
        });

        threeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"3");
            }
        });

        fourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"4");
            }
        });

        fiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"5");
            }
        });

        sixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"6");
            }
        });

        sevenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"7");
            }
        });

        eightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"8");
            }
        });

        nineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+"9");
            }
        });

        pointButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText(answerTextField.getText()+".");
            }
        });

        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand = "addition";
                answerTextField.setText(answerTextField.getText()+"+");
            }
        });

        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand = "subtraction";
                answerTextField.setText(answerTextField.getText()+"-");
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand = "multiplication";
                answerTextField.setText(answerTextField.getText()+"*");
            }
        });

        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operand = "division";
                answerTextField.setText(answerTextField.getText()+"/");
            }
        });


        onRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                enable();
            }
        });

        offRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                disable();
                answerTextField.setText("");
            }
        });

        backSpaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = answerTextField.getText().length();
                int newLength = length - 1;


                if (length > 0) {
                    StringBuilder backspace = new StringBuilder(answerTextField.getText());
                    backspace.deleteCharAt(newLength);
                    //convert result to string and store in temp
                    String temp;
                    temp = backspace.toString();
                    answerTextField.setText(temp);
                }
            }
        });

        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answerTextField.setText("");//clear the text field
            }
        });


        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             arithmeticOperation();
            }
        });
    }//ends public AppSix

    // method to turn on calc

    private void enable(){
        onRadioButton.setEnabled(false);
        titleLabel.setEnabled(true);
        answerTextField.setEnabled(true);
        offRadioButton.setEnabled(true);
        backSpaceButton.setEnabled(true);
        clearAllButton.setEnabled(true);
        zeroButton.setEnabled(true);
        oneButton.setEnabled(true);
        twoButton.setEnabled(true);
        threeButton.setEnabled(true);
        fourButton.setEnabled(true);
        fiveButton.setEnabled(true);
        sixButton.setEnabled(true);
        sevenButton.setEnabled(true);
        eightButton.setEnabled(true);
        nineButton.setEnabled(true);
        plusButton.setEnabled(true);
        multiplyButton.setEnabled(true);
        minusButton.setEnabled(true);
        divisionButton.setEnabled(true);
        equalButton.setEnabled(true);
        pointButton.setEnabled(true);
    }

    //create method to disable when off is selected
    private void disable(){
        onRadioButton.setEnabled(true);// everything else false
        titleLabel.setEnabled(false);
        answerTextField.setEnabled(false);
        offRadioButton.setEnabled(false);
        backSpaceButton.setEnabled(false);
        clearAllButton.setEnabled(false);
        zeroButton.setEnabled(false);
        oneButton.setEnabled(false);
        twoButton.setEnabled(false);
        threeButton.setEnabled(false);
        fourButton.setEnabled(false);
        fiveButton.setEnabled(false);
        sixButton.setEnabled(false);
        sevenButton.setEnabled(false);
        eightButton.setEnabled(false);
        nineButton.setEnabled(false);
        plusButton.setEnabled(false);
        multiplyButton.setEnabled(false);
        minusButton.setEnabled(false);
        divisionButton.setEnabled(false);
        equalButton.setEnabled(false);
        pointButton.setEnabled(false);
    }

    private void arithmeticOperation(){
        /*we will need to split the number in the answer text field
        before performing an arithmetic operation.
        There are some characters with special functions in java
         that need to be escaped while splitting
         they include . + * () and many more
         you can escape those characters by introducing \\+ or pattern quote ("+") as shown below
         */
        try {
            String [] parts;
            String leftPart, rightPart;
            switch (operand){
                case "addition":
                    // to split firs store the string in a array and show character to split on
                    parts = answerTextField.getText().split("\\+");
                    //assign the string on each part of the character to the leftPart  and rightPart
                    leftPart = parts[0];
                    rightPart = parts[1];

                    //change both strings to double before performing the operation
                    answer =Double.parseDouble(leftPart) +Double.parseDouble(rightPart);
                    // now write to answer text field
                    answerTextField.setText(String.valueOf(answer));
                    break;

                case "subtraction":
                    parts = answerTextField.getText().split("-");
                    leftPart =parts[0];
                    rightPart =parts[1];
                    answer =Double.parseDouble(leftPart)-Double.parseDouble(rightPart);
                    answerTextField.setText(String.valueOf(answer));
                    break;

                case "multiplication":
                    parts = answerTextField.getText().split(Pattern.quote("*"));
                    leftPart =parts[0];
                    rightPart =parts[1];
                    answer =Double.parseDouble(leftPart)*Double.parseDouble(rightPart);
                    answerTextField.setText(String.valueOf(answer));
                    break;

                case "division":
                    parts = answerTextField.getText().split("/");
                    leftPart =parts[0];
                    rightPart =parts[1];
                    answer =Double.parseDouble(leftPart)/Double.parseDouble(rightPart);
                    answerTextField.setText(String.valueOf(answer));
                    break;

                default:
                    answerTextField.setText("");
                    break;
                }
            }catch (Exception g){
                g.getMessage();
            }
        }// arithmetic operation ends here


        public static void main(String[] args) {
        JFrame frame = new JFrame("Appsix");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new AppSix().framePanel);
        frame.setSize(260, 355);
    }
    }

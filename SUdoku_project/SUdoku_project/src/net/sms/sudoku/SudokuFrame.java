package net.sms.sudoku;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * This class holds and manages the main frame of the program.
 */
public class SudokuFrame {

    private final JFrame frame = new JFrame("Sudoku");
    private SudokuGrid grid;

    public SudokuFrame() {
        frame.getContentPane().add(grid = new SudokuGrid(9));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildMenu();
        frame.pack();
        frame.setResizable(false);
        centerView();
        frame.setVisible(true);
    }

    private void buildMenu() {
        JMenuBar bar = new JMenuBar();
        bar.setBackground(Color.lightGray);
        JMenu fileMenu = new JMenu("File");

        JMenuItem easy  = new JMenuItem("Easy");
        JMenuItem medium = new JMenuItem("Medium");
        JMenuItem hard = new JMenuItem("Hard");

        JMenuItem how_to_play = new JMenuItem("How To Play");
        JMenuItem about = new JMenuItem("About");

        fileMenu.addSeparator();
        fileMenu.add(easy);
        fileMenu.add(medium);
        fileMenu.add(hard);
        fileMenu.addSeparator();
        fileMenu.add(how_to_play);
        fileMenu.add(about);

        bar.add(fileMenu);


        easy.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(grid = new SudokuGrid(4));
            frame.pack();
            centerView();
        });

        medium.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(grid = new SudokuGrid(9));
            frame.pack();
            centerView();
        });

        hard.addActionListener((ActionEvent e) -> {
            frame.getContentPane().removeAll();
            frame.getContentPane().add(grid = new SudokuGrid(16));
            frame.pack();
            centerView();
        });

        how_to_play.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(
                    null,
                    "Right click to choose values in each block.\n" +
                            "Every row and every column must contain every values.\n" +
                            "Every block must contain every values(As described below).\n" +
                            "For easy values between 1-4.\n" +
                            "For medium values between 1-9.\n" +
                            "For hard values between 1-16.\n" +
                            "Make sure that no value is repeated in any row,column and block.",
                    "How To Play",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        about.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(
                    null,
                    "A Project By:-\n" +
                            "Satvik Gupta(BC/21/100)\n" +
                            "SCHOOL OF MANAGEMENT SCIENCES\n"+
                            "(BCA:2018-2021) Major Project",
                    "About", 
                    JOptionPane.INFORMATION_MESSAGE);
        });

        frame.setJMenuBar(bar);
    }

    private void centerView() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = frame.getSize();

        frame.setLocation((screen.width - frameSize.width) >> 1,
                          (screen.height - frameSize.height) >> 1);
    }
}

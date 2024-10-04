import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        MorseTree morseTree = new MorseTree();


        JFrame frame = new JFrame("Árvore Morse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);


        TreePanel treePanel = new TreePanel(morseTree.getRoot());
        frame.add(treePanel, BorderLayout.CENTER);


        frame.setVisible(true);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código Morse para decodificar (use '.' para ponto e '-' para traço e ' ' para separar as letras):");
        String morseCode = scanner.nextLine();

        String[] morseLetters = morseCode.split(" ");
        StringBuilder decodedWord = new StringBuilder();

        for (String morseLetter : morseLetters) {
            char decodedChar = morseTree.decode(morseLetter);
            decodedWord.append(decodedChar);
        }

        System.out.println("Palavra decodificada: " + decodedWord.toString());
    }
}

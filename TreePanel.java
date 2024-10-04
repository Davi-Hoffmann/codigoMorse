import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private MorseTree.Node root;

    public TreePanel(MorseTree.Node root) {
        this.root = root;
        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawNode(g, root, getWidth() / 2, 50, getWidth() / 4);
    }


    private void drawNode(Graphics g, MorseTree.Node node, int x, int y, int offsetX) {
        if (node == null) {
            return;
        }


        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30); // Círculo representando o nó
        g.setColor(Color.WHITE);
        g.drawString(Character.toString(node.letter), x - 5, y + 5); // Letra no centro


        if (node.dot != null) {
            g.setColor(Color.BLUE);
            g.drawLine(x, y, x - offsetX, y + 70); // Linha para o nó da esquerda
            drawNode(g, node.dot, x - offsetX, y + 70, offsetX / 2); // Chamada recursiva para desenhar o nó ponto
        }


        if (node.dash != null) {
            g.setColor(Color.RED);
            g.drawLine(x, y, x + offsetX, y + 70); // Linha para o nó da direita
            drawNode(g, node.dash, x + offsetX, y + 70, offsetX / 2); // Chamada recursiva para desenhar o nó traço
        }
    }
}

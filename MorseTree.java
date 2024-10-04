public class MorseTree {
    class Node {
        char letter;
        Node dot;
        Node dash;

        public Node(char letter) {
            this.letter = letter;
            this.dot = null;
            this.dash = null;
        }
    }

    private Node root;

    public MorseTree() {
        root = new Node('\0');
        buildTree();
    }


    private void buildTree() {

        root.dot = new Node('E');
        root.dash = new Node('T');


        root.dot.dot = new Node('I');
        root.dot.dash = new Node('A');
        root.dash.dot = new Node('N');
        root.dash.dash = new Node('M');


        root.dot.dot.dot = new Node('S');
        root.dot.dot.dash = new Node('U');
        root.dot.dash.dot = new Node('R');
        root.dot.dash.dash = new Node('W');
        root.dash.dot.dot = new Node('D');
        root.dash.dot.dash = new Node('K');
        root.dash.dash.dot = new Node('G');
        root.dash.dash.dash = new Node('O');


        root.dot.dot.dot.dot = new Node('H');
        root.dot.dot.dot.dash = new Node('V');
        root.dot.dot.dash.dot = new Node('F');
        root.dot.dash.dot.dot = new Node('L');
        root.dot.dash.dash.dot = new Node('P');
        root.dot.dash.dash.dash = new Node('J');
        root.dash.dot.dot.dot = new Node('B');
        root.dash.dot.dot.dash = new Node('X');
        root.dash.dot.dash.dot = new Node('C');
        root.dash.dot.dash.dash = new Node('Y');
        root.dash.dash.dot.dot = new Node('Z');
        root.dash.dash.dot.dash = new Node('Q');

    }


    public char decode(String morseCode) {
        Node current = root;


        for (int i = 0; i < morseCode.length(); i++) {
            char signal = morseCode.charAt(i);

            if (signal == '.') {
                if (current.dot != null) {
                    current = current.dot;
                } else {
                    return '?';
                }
            } else if (signal == '-') {
                if (current.dash != null) {
                    current = current.dash;
                } else {
                    return '?';
                }
            } else {
                return '?';
            }
        }

        return current.letter;
    }


    public Node getRoot() {
        return root;
    }
}

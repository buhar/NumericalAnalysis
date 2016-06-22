import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) 
    {
    	JFrame frame = new Frame();
    	frame.setTitle("Disco!");
    	frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

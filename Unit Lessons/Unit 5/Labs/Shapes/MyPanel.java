import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    public MyPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.setSize(500, 500);
    }

    public void paint(Graphics g) {
        // Adds shapes to an ArrayList, converting them all to Polygons
        ArrayList<Shape> polygons = new ArrayList<Shape>();
        polygons.add(new Rectangle(125, 125, 250, 250));
        polygons.add(new Circle(125, 125, 250));
        polygons.add(new Rectangle(175, 175, 150, 150));
        polygons.add(new Circle(175, 175, 150));


        // Draws all the shapes in the ArrayList using that shape's draw method
        for (Shape p : polygons) {
            p.draw(g);
        }


    }


}

package flyweight;

import java.awt.*;

public class BlackChessPiece implements ChessPiece {
    @Override
    public void downPiece(Graphics g, Point p) {
        g.setColor(Color.BLACK);
        g.fillOval(p.x, p.y, 30, 30);
    }
}

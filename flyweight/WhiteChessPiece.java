package flyweight;

import java.awt.*;

public class WhiteChessPiece implements ChessPiece {
    @Override
    public void downPiece(Graphics g, Point p) {
        g.setColor(Color.WHITE);
        g.fillOval(p.x, p.y, 30, 30);
    }
}

package flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessBoard extends MouseAdapter {

    JFrame frame;
    Graphics g;
    JRadioButton wp;
    JRadioButton bp;

    private final int x = 50;
    private final int y = 50;
    private final int w = 40;
    private final int rw = 400;

    /**
     * {@inheritDoc}
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = new Point(e.getX() - 15, e.getY() - 15);
        if (wp.isSelected()) {
            ChessPiecesFactory.getChessPiece(ChessType.WHITE).downPiece(g, p);
        } else {
            ChessPiecesFactory.getChessPiece(ChessType.BLACK).downPiece(g, p);
        }
    }

    public ChessBoard() {
        frame = new JFrame("Five Chess");
        frame.setBounds(100, 100, 500, 550);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jPanel = new JPanel();
        frame.add("South", jPanel);
        wp = new JRadioButton("白子");
        bp = new JRadioButton("黑子", true);
        ButtonGroup bg = new ButtonGroup();
        bg.add(wp);
        bg.add(bp);
        jPanel.add(wp);
        jPanel.add(bp);
        JPanel center = new JPanel();
        center.setLayout(null);
        center.setSize(500, 500);
        center.addMouseListener(this);
        frame.add("Center", center);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        g = center.getGraphics();
        g.setColor(Color.BLUE);
        g.drawRect(x, y, rw, rw);
        for (int i = 1; i < 10; i++) {
            g.drawLine(x + (i * w), y, x + (i * w), y + rw);
            g.drawLine(x, y + (i * w), x + rw, y + (i * w));
        }
    }
}

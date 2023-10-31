import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends JComponent {

    private final Rect rectA, recta, rect0, rectSP, button, copyButton, closeButton;
    private final Font font = new Font("Imprint MT Shadow", Font.PLAIN, 20);
    private final BasicStroke stroke = new BasicStroke(2);

    public boolean isA, isa = true, is0, isSp;
    GradientPaint gp = new GradientPaint(0, 0, Color.GREEN, 240, 120, Color.ORANGE);
    GradientPaint gpCopy = new GradientPaint(20, 188, Color.decode("#1A2980"), 240, 220, Color.decode("#26d0ce"));
    GradientPaint gpCheck = new GradientPaint(0, 0, Color.BLUE, 240, 120, Color.YELLOW);

    public Button(OnClick onClick) {
        rectA = new Rect(20, 20, 110, 60);
        recta = new Rect(130, 20, 220, 60);

        rect0 = new Rect(20, 80, 110, 120);
        rectSP = new Rect(130, 80, 220, 120);


        button = new Rect(10, 140, 230, 170);
        closeButton = new Rect(180, 188, 212, 220);
        copyButton = new Rect(20, 188, 160, 220);


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (button.contains(e.getX(), e.getY())) {
                    onClick.onClick();
                    return;
                }
                if (rect0.contains(e.getX(), e.getY())) is0 = !is0;
                if (recta.contains(e.getX(), e.getY())) isa = !isa;
                if (rectA.contains(e.getX(), e.getY())) isA = !isA;
                if (rectSP.contains(e.getX(), e.getY())) isSp = !isSp;

                if (copyButton.contains(e.getX(), e.getY())) onClick.onCopy();
                if (closeButton.contains(e.getX(), e.getY())) onClick.onClose();


                repaint();
            }
        });

    }

    @Override
    public void paint(Graphics _g) {
        Graphics2D g = (Graphics2D) _g.create();
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setPaint(gpCheck);
        g.setStroke(stroke);
        g.fillRoundRect(rect0.left, rect0.top, rect0.width(), rect0.height(), 20, 20);
        g.fillRoundRect(rectSP.left, rectSP.top, rectSP.width(), rectSP.height(), 20, 20);
        g.fillRoundRect(rectA.left, rectA.top, rectA.width(), rectA.height(), 20, 20);
        g.fillRoundRect(recta.left, recta.top, recta.width(), recta.height(), 20, 20);


        g.setPaint(null);
        g.setColor(Color.BLACK);
        g.drawOval(28, 30, 20, 20);
        g.drawOval(140, 30, 20, 20);
        g.drawOval(28, 90, 20, 20);
        g.drawOval(140, 90, 20, 20);


        if (isA)
            g.fillOval(28, 30, 20, 20);
        if (isa)
            g.fillOval(140, 30, 20, 20);
        if (is0)
            g.fillOval(28, 90, 20, 20);
        if (isSp)
            g.fillOval(140, 90, 20, 20);

        g.setFont(font);


        g.drawString("A-Z", 60, 47);
        g.drawString("a-z", 170, 45);
        g.drawString("0-9", 60, 107);
        g.drawString("SP", 170, 105);

        g.setPaint(gp);
        g.fillRoundRect(button.left, button.top, button.width(), button.height(), 20, 20);
        g.setPaint(null);


        g.setColor(Color.BLACK);
        g.drawString("GENERATE", 62, 162);

        //close button
        g.setColor(Color.RED);
        g.fillOval(180, 188, 32, 32);


        g.setPaint(gpCopy);
        g.fillRoundRect(copyButton.left, copyButton.top, copyButton.width(), copyButton.height(), 32, 32);
        g.setColor(Color.WHITE);
        g.drawString("COPY", 64, copyButton.bottom - 10);

        g.drawLine(190, 198, 202, 210);
        g.drawLine(202, 198, 190, 210);
    }

    public interface OnClick {
        void onClick();

        void onClose();

        void onCopy();
    }

}

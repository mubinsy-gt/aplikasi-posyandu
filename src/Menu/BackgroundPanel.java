package Menu;

import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {

    private Image bg;

    public BackgroundPanel() {
        try {
            // Pastikan bg3.png ada di folder: src/images/bg3.png
            bg = new ImageIcon(getClass().getResource("/image/bg3.png")).getImage();
        } catch (Exception e) {
            System.out.println("Gagal memuat background: " + e.getMessage());
        }
        setLayout(null); // Untuk bebas meletakkan komponen
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (bg != null) {
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

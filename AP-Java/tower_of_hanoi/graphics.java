package tower_of_hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;


class Graphics extends JFrame {
    JPanel panel = new JPanel();

    Theme theme = new Theme();

    public void init() {
        // Sets the title of the app
        setTitle("Tower of Hanoi");

        // Creates a background for the app
        panel.setBackground(theme.color_primary);

        add(panel);

        setIcon("C:/Users/marku/Desktop/AP Java/tower_of_hanoi/src/imgs/icon.jpg");

    }

    private void setIcon(String path) {
        BufferedImage iconImage = null;
        try {
            iconImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (iconImage != null) {
            // Set the image as the icon
            setIconImage(iconImage);
        }
    }

    public void finalize() {
        Theme theme = new Theme();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int) (theme.screenWidth * 0.75), (int) (theme.screenHeight * 0.75));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class Primitaves {
        Runnable clear = () -> {
            panel.removeAll();
            panel.revalidate();
            panel.repaint();
        };

        private class CustomButton extends JButton {
            private Color bgColor;
            private Color textColor;

            private CustomButton(String text, Color bgColor, Color textColor) {
                super(text);
                this.bgColor = bgColor;
                this.textColor = textColor;

                setOpaque(false);
                setContentAreaFilled(false);
                setBorderPainted(false);

                setMargin(new Insets(10, 20, 10, 20));

            }

            @Override
            protected void paintComponent(java.awt.Graphics g) {
                // Paint the custom background
                g.setColor(bgColor);
                g.fillRect(0, 0, getWidth(), getHeight());

                // Paint the text
                g.setColor(textColor);
                g.setFont(getFont());
                g.drawString(getText(), (getWidth() - g.getFontMetrics().stringWidth(getText())) / 2,
                        (getHeight() + g.getFontMetrics().getHeight()) / 2);
            }
        }

        protected CustomButton write_button(String txt, int width, int height, Runnable function) {
            CustomButton button = new CustomButton(txt, theme.color_tertiary, theme.color_primary);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    function.run();
                }
            });

            return button;
        }

        protected JLabel text_title(String txt, Color color) {
            JLabel label = new JLabel(txt);
            label.setFont(theme.text_title);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            label.setForeground(color);

            return label;
        }

        protected JLabel text_subtitle(String txt, Color color) {
            JLabel label = new JLabel(txt);
            label.setFont(theme.text_subtitle);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            label.setForeground(color);

            return label;
        }

        protected JLabel text_para(String txt, Color color, Color bg) {
            JLabel para = new JLabel("<html><div style='margin: \" + theme.screenWidth/16 + \"px; text-align: center;'>"
                    + txt + "</div><html>");
            para.setFont(theme.text_para);
            para.setAlignmentX(Component.CENTER_ALIGNMENT);

            para.setForeground(color);

            para.setBackground(bg);

            return para;
        }

    }

    public class Pages {
        Primitaves primitaves = new Primitaves();
        Theme theme = new Theme();

        private Runnable home = () -> {
            home();
        };

        public void home() {
            primitaves.clear.run();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.setAlignmentY(Component.CENTER_ALIGNMENT);
            EmptyBorder marginBorder = new EmptyBorder(theme.screenHeight / 16, theme.screenWidth / 16,
                    theme.screenWidth / 16, theme.screenWidth / 16);

            panel.setBorder(marginBorder);

            panel.add(primitaves.text_title("The Tower of ", theme.color_secondary));
            panel.add(primitaves.text_title("Hanoi", theme.color_tertiary));
            panel.add(Box.createVerticalStrut(theme.screenHeight / 40));
            panel.add(primitaves.text_subtitle("By: Daniel Markusson", theme.color_secondary));

            panel.add(Box.createVerticalStrut(theme.screenHeight / 5));

            panel.add(Box.createVerticalGlue());
            panel.add(primitaves.write_button("Play", theme.button_width, theme.button_height, game));
            panel.add(Box.createVerticalStrut(30));
            panel.add(Box.createVerticalGlue());
            panel.add(Box.createVerticalGlue());
            panel.add(primitaves.write_button("How to Play", theme.button_width, theme.button_height, how_to_play));
        };

        public Runnable game = () -> {
            primitaves.clear.run();

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.setAlignmentY(Component.CENTER_ALIGNMENT);

            Primitaves.CustomButton backButton = primitaves.write_button("Back", theme.button_width,
                    theme.button_height,
                    home);

            JPanel leftPanel = new JPanel();
            // leftPanel.setBackground(theme.color_primary);
            leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
            leftPanel.add(backButton);
            leftPanel.setBackground(theme.color_primary);
            leftPanel.add(Box.createHorizontalGlue());
            panel.add(leftPanel);

            panel.add(primitaves.text_title("The Tower of ", theme.color_secondary));
            panel.add(primitaves.text_title("Hanoi", theme.color_tertiary));

            panel.add(Box.createVerticalStrut(theme.screenHeight / 16));

            Game game = new Game();

            Game.GamePanel gamePanel = game.new GamePanel();

            gamePanel.setBackground(theme.color_secondary);

            EmptyBorder marginBorder = new EmptyBorder(theme.screenHeight / 16, theme.screenWidth / 16,
                    theme.screenWidth / 16, theme.screenWidth / 16);
            panel.setBorder(marginBorder);

            panel.add(gamePanel);

        };

        public Runnable how_to_play = () -> {
            primitaves.clear.run();

            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.setAlignmentY(Component.CENTER_ALIGNMENT);
            EmptyBorder marginBorder = new EmptyBorder(theme.screenHeight / 16, theme.screenWidth / 16,
                    theme.screenWidth / 16, theme.screenWidth / 16);
            panel.setBorder(marginBorder);

            Primitaves.CustomButton backButton = primitaves.write_button("Back", theme.button_width,
                    theme.button_height,
                    home);

            JPanel leftPanel = new JPanel();
            // leftPanel.setBackground(theme.color_primary);
            leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
            leftPanel.add(backButton);
            leftPanel.setBackground(theme.color_primary);
            leftPanel.add(Box.createHorizontalGlue());
            panel.add(leftPanel);

            panel.add(primitaves.text_subtitle("How to Play:", theme.color_secondary));
            panel.add(Box.createVerticalStrut(theme.screenHeight / 25));

            String howToPlay = "'The Tower of Hanoi' is a mathematical puzzle that involves three pegs and a set of disks of varying sizes. The objective of the game is to move the entire stack of disks from one peg to another, following two simple rules: <br><br>1. Only one disk can be moved at a time. <br>2. A disk can only be placed on top of a larger disk or an empty peg. <br><br>The game starts with the disks stacked in decreasing size on one peg, in ascending order from top to bottom.";

            panel.add(primitaves.text_para(howToPlay, theme.color_compliment, theme.color_primary));
        };
    }

    private class Game {
        Theme theme = new Theme();

        Block block = new Block();

        protected class GamePanel extends JPanel {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);

                int panelWidth = getWidth();
                int panelHeight = getHeight();
                int numShapes = 3;

                int shapeWidth = (panelWidth / numShapes) - panelWidth / 16;
                int shapeHeight = (int) (panelHeight * 0.85);
                int lineThickness = panelHeight / 15;

                drawShape(g, panelWidth / 6 - shapeWidth / 2, shapeHeight, shapeWidth, shapeHeight, lineThickness);
                drawShape(g, panelWidth / 2 - shapeWidth / 2, shapeHeight, shapeWidth, shapeHeight, lineThickness);
                drawShape(g, panelWidth - (panelWidth / 6 - shapeWidth / 2) - shapeWidth, shapeHeight, shapeWidth,
                        shapeHeight, lineThickness);

                block.draw(g);
            }

            private void drawShape(java.awt.Graphics g, int x, int y, int width, int height, int line_thickness) {
                g.setColor(theme.color_compliment);
                g.fillRect(x, y, width, line_thickness);
                g.fillRect(x + (width / 2) - (line_thickness / 2), y - (int) (height * 0.65) - line_thickness,
                        line_thickness, (int) (height * 0.75));

            }

            private GamePanel() {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        int mouseX = e.getX();
                        int mouseY = e.getY();

                        if (mouseX >= block.x && mouseX <= block.x + block.width &&
                                mouseY >= block.y && mouseY <= block.y + block.height) {
                            block.isDragging = true;
                        }
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        block.isDragging = false;
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        if (block.isDragging) {
                            System.out.println(e.getX() + "," + e.getY() + " | " + getX() + "," + (getY() - panel.getHeight()/2 + 9));
                            if (!((e.getX() < getX()) && e.getY() > (getY() - panel.getHeight()/2)))
                                block.x = e.getX() - block.width / 2;
                                block.y = e.getY() - block.height / 2;
                                repaint();
                        }
                    }
                });
            }

        }

        private class Block {
            public Color color = theme.color_tertiary;

            public int width = panel.getWidth()/5;
            public int height = panel.getHeight()/15;
            public int x = 50;
            public int y = 50;

            public boolean isDragging = false;

            public void draw(java.awt.Graphics g) {
                g.setColor(color);
                g.fillRect(x, y, width, height);
            }
        }
    }

    private class Theme {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        int screenHeight = toolkit.getScreenSize().height;
        int screenWidth = toolkit.getScreenSize().width;

        int button_width = 700;
        int button_height = 700;

        Color color_primary = new Color(4, 13, 18);
        Color color_secondary = new Color(24, 61, 61);
        Color color_tertiary = new Color(92, 131, 116);
        Color color_compliment = new Color(147, 177, 166);

        Font text_title = new Font(Font.SANS_SERIF, Font.BOLD, Math.min(screenHeight / 15, screenWidth / 15));
        Font text_subtitle = new Font(Font.SANS_SERIF, Font.PLAIN, Math.min(screenHeight / 25, screenWidth / 25));
        Font text_para = new Font(Font.SANS_SERIF, Font.PLAIN, Math.min(screenHeight / 40, screenWidth / 40));
    }
}


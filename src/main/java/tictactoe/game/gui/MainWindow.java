package tictactoe.game.gui;


import tictactoe.game.field.Board;
import tictactoe.game.piece.Piece;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import static javax.swing.SwingUtilities.isLeftMouseButton;

public class MainWindow {

    private JFrame gameWindow;
    private static final Dimension DIMENSION_OF_WINDOW = new Dimension(510,510);
    private static final Dimension DIMENSION_OF_TILE =
            new Dimension(DIMENSION_OF_WINDOW.width/3, DIMENSION_OF_WINDOW.height/3);

    public MainWindow() {
        this.gameWindow = new JFrame("tic-tac-toe");
        this.gameWindow.setLayout(new BorderLayout());
        this.gameWindow.setVisible(true);
        this.gameWindow.setSize(DIMENSION_OF_WINDOW);
        Board board = new Board();
        FieldOfTiles fieldOfTiles = new FieldOfTiles(board.getGameConfig());
        this.gameWindow.add(fieldOfTiles);
    }

    public static class FieldOfTiles extends JPanel {

        private Map<Integer, Piece> gameBoard;

        FieldOfTiles(Map<Integer, Piece> gameBoard) {
            super(new GridLayout(3,3));
            this.gameBoard = gameBoard;
            drawField();
        }

        public void drawField() {
            for(int i = 0; i < 9; i++) {
                TilePanel tilePanel = new TilePanel(this.gameBoard,i);
                add(tilePanel);
            }
        }

        @Override
        public void paint(Graphics g) {
            int width = DIMENSION_OF_WINDOW.width;
            int height = DIMENSION_OF_WINDOW.height-35;
            int tileWidth = width/3;
            int tileHeight = height/3;
            for(int i = 1; i < 3; i++) {
                g.drawLine(tileWidth*i, 0, tileWidth*i, tileHeight*3);
                g.drawLine(0,tileHeight*i,tileWidth*3,tileHeight*i);
            }
        }
    }

    public static class TilePanel extends JPanel {
        private final int tileId;
        private final Map<Integer, Piece> contMap;
        private Piece.PieceType moveMaker = Piece.PieceType.TIC;


        TilePanel(Map<Integer,Piece> contMap, int tileId) {
            super(new GridBagLayout());
            this.contMap = contMap;
            this.tileId = tileId;
            this.setPreferredSize(DIMENSION_OF_TILE);
            listener();
            System.out.println(contMap);
        }

        public void listener() {
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(isLeftMouseButton(e)) {
                        if(contMap.get(tileId) == null) {
                            System.out.println(tileId);
                            Piece piece = new Piece(moveMaker);
                            try {
                                BufferedImage image = ImageIO.read(new File(piece.getUrl()));
                                ImageIcon imageIcon = new ImageIcon(image);
                                add(new JLabel(imageIcon));
                                contMap.replace(tileId, piece);
                                setMoveMaker(piece.getPieceType());
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                            validate();
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }

        public Piece.PieceType setMoveMaker(Piece.PieceType moveMaker) {
            return moveMaker == Piece.PieceType.TIC ? Piece.PieceType.TACTOE : Piece.PieceType.TIC;
        }
    }
}

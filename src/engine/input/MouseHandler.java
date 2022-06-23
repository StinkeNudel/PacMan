package engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Handles MouseInput
 * use getClickX() getClickY() to get the click position
 */

public class MouseHandler implements MouseListener {
    private static int clickX, clickY;

    /**
     * @return X Pos of mouse click
     */
    public static int getClickX() {
        return clickX;
    }

    /**
     * @return Y Pos of mouse click
     */
    public static int getClickY() {
        return clickY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        clickX = e.getX();
        clickY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * resets the mouse positions
     */
    public void mouseReleased(MouseEvent e) {
        clickX = -1;
        clickY = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

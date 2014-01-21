
package org.tomcurran.controlpad.controllers;


/**
 * Data structure describing state of generic compatible game controller.
 * 
 * @author lord
 */
public class GameControllerState
{
    // buttons with pictures
    protected boolean square;
    protected boolean cross;
    protected boolean circle;
    protected boolean triangle;

    // Front-side buttons
    protected boolean L1;
    protected boolean R1;
    protected boolean L2;
    protected boolean R2;

    // square small "select" button
    protected boolean select;
    // triangular small "start" button
    protected boolean start;

    // Pressing on joysticks (button)
    protected boolean leftJoystickPress;
    protected boolean rightJoystickPress;

    // PS3 button (sometimes labeled as Home on 3rd party models)
    protected boolean home;

    // Direction pad
    protected boolean dpadUp;
    protected boolean dpadDown;
    protected boolean dpadRight;
    protected boolean dpadLeft;

    // Analog joysticks
    protected int     leftJoystickX;
    protected int     leftJoystickY;
    protected int     rightJoystickX;
    protected int     rightJoystickY;

    // Accelerometer orientation
    protected int     orientationX;
    protected int     orientationY;
    protected int     orientationZ;

	public GameControllerState(boolean square, boolean cross, boolean circle, boolean triangle,
			boolean dpadUp, boolean dpadDown, boolean dpadLeft, boolean dpadRight,
			boolean l1, boolean r1, boolean l2, boolean r2,
			boolean select, boolean start, boolean home,
			boolean leftJoystickPress, boolean rightJoystickPress,
			int leftJoystickX, int leftJoystickY, int rightJoystickX, int rightJoystickY,
			int orientationX, int orientationY, int orientationZ)
    {
        this.square = square;
        this.cross = cross;
        this.circle = circle;
        this.triangle = triangle;
        L1 = l1;
        R1 = r1;
        L2 = l2;
        R2 = r2;
        this.select = select;
        this.start = start;
        this.leftJoystickPress = leftJoystickPress;
        this.rightJoystickPress = rightJoystickPress;
        this.home = home;
        this.leftJoystickX = leftJoystickX;
        this.leftJoystickY = leftJoystickY;
        this.rightJoystickX = rightJoystickX;
        this.rightJoystickY = rightJoystickY;
        this.dpadUp = dpadUp;
        this.dpadDown = dpadDown;
        this.dpadLeft = dpadLeft;
        this.dpadRight = dpadRight;
        this.orientationX = orientationX;
        this.orientationY = orientationY;
        this.orientationZ = orientationZ;
    }

    public GameControllerState(GameControllerState o)
    {
        this.square = o.square;
        this.cross = o.cross;
        this.circle = o.circle;
        this.triangle = o.triangle;
        L1 = o.L1;
        R1 = o.R1;
        L2 = o.L2;
        R2 = o.R2;
        this.select = o.select;
        this.start = o.start;
        this.leftJoystickPress = o.leftJoystickPress;
        this.rightJoystickPress = o.rightJoystickPress;
        this.home = o.home;
        this.leftJoystickX = o.leftJoystickX;
        this.leftJoystickY = o.leftJoystickY;
        this.rightJoystickX = o.rightJoystickX;
        this.rightJoystickY = o.rightJoystickY;
        this.dpadUp = o.dpadUp;
        this.dpadDown = o.dpadDown;
        this.dpadLeft = o.dpadLeft;
        this.dpadRight = o.dpadRight;
        this.orientationX = o.orientationX;
        this.orientationY = o.orientationY;
        this.orientationZ = o.orientationZ;
    }

    public GameControllerState()
    {
    }

    public int getLeftJoystickX()
    {
        return leftJoystickX;
    }

    public int getLeftJoystickY()
    {
        return leftJoystickY;
    }

    public int getRightJoystickX()
    {
        return rightJoystickX;
    }

    public int getRightJoystickY()
    {
        return rightJoystickY;
    }

    public int getOrientationX()
    {
        return orientationX;
    }

    public int getOrientationY()
    {
        return orientationY;
    }

    public int getOrientationZ()
    {
        return orientationZ;
    }

    public boolean isCircle()
    {
        return circle;
    }

    public boolean isCross()
    {
        return cross;
    }

    public boolean isL1()
    {
        return L1;
    }

    public boolean isL2()
    {
        return L2;
    }

    public boolean isLeftJoystickPress()
    {
        return leftJoystickPress;
    }

    public boolean isPS()
    {
        return home;
    }

    public boolean isR1()
    {
        return R1;
    }

    public boolean isR2()
    {
        return R2;
    }

    public boolean isRightJoystickPress()
    {
        return rightJoystickPress;
    }

    public boolean isSelect()
    {
        return select;
    }

    public boolean isSquare()
    {
        return square;
    }

    public boolean isStart()
    {
        return start;
    }

    public boolean isTriangle()
    {
        return triangle;
    }

    public boolean isDpadUp()
    {
        return dpadUp;
    }

    public boolean isDpadDown()
    {
        return dpadDown;
    }

    public boolean isDpadLeft()
    {
        return dpadLeft;
    }

    public boolean isDpadRight()
    {
        return dpadRight;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("GameControllerState [square=");
        builder.append(square);
        builder.append(", cross=");
        builder.append(cross);
        builder.append(", circle=");
        builder.append(circle);
        builder.append(", triangle=");
        builder.append(triangle);
        builder.append(", L1=");
        builder.append(L1);
        builder.append(", R1=");
        builder.append(R1);
        builder.append(", L2=");
        builder.append(L2);
        builder.append(", R2=");
        builder.append(R2);
        builder.append(", select=");
        builder.append(select);
        builder.append(", start=");
        builder.append(start);
        builder.append(", rightJoystickPress=");
        builder.append(rightJoystickPress);
        builder.append(", leftJoystickPress=");
        builder.append(leftJoystickPress);
        builder.append(", home=");
        builder.append(home);
        builder.append(", dpadUp=");
        builder.append(dpadUp);
        builder.append(", dpadDown=");
        builder.append(dpadDown);
        builder.append(", dpadLeft=");
        builder.append(dpadLeft);
        builder.append(", dpadRight=");
        builder.append(dpadRight);
        builder.append(", leftJoystickX=");
        builder.append(leftJoystickX);
        builder.append(", leftJoystickY=");
        builder.append(leftJoystickY);
        builder.append(", rightJoystickX=");
        builder.append(rightJoystickX);
        builder.append(", rightJoystickY=");
        builder.append(rightJoystickY);
        builder.append(", orientationX=");
        builder.append(orientationX);
        builder.append(", orientationY=");
        builder.append(orientationY);
        builder.append(", orientationZ=");
        builder.append(orientationZ);
        builder.append("]");
        return builder.toString();
    }

}

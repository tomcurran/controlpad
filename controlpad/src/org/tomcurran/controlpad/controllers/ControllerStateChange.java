
package org.tomcurran.controlpad.controllers;

public class ControllerStateChange extends GameControllerState
{
    protected boolean squareChanged;
    protected boolean crossChanged;
    protected boolean circleChanged;
    protected boolean triangleChanged;
    protected boolean L1Changed;
    protected boolean R1Changed;
    protected boolean L2Changed;
    protected boolean R2Changed;
    protected boolean selectChanged;
    protected boolean startChanged;
    protected boolean leftJoystickPressChanged;
    protected boolean rightJoystickPressChanged;
    protected boolean homeChanged;
    protected boolean dpadUpChanged;
    protected boolean dpadDownChanged;
    protected boolean dpadLeftChanged;
    protected boolean dpadRightChanged;
    protected int     leftJoystickXChange;
    protected int     leftJoystickYChange;
    protected int     rightJoystickXChange;
    protected int     rightJoystickYChange;
    protected int     orientationXChange;
    protected int     orientationYChange;
    protected int     orientationZChange;

    // composite change flags
    private boolean   buttonStateChanged;
    private boolean   leftJoystickChanged;
    private boolean   rightJoystickChanged;
    private boolean   joysticksChanged;
    private boolean   dpadChanged;
    private boolean   orientationChanged;
    private boolean   changed;

    /**
     * 
     * @param o Old state
     * @param n New state
     */
    public ControllerStateChange(GameControllerState o, GameControllerState n)
    {
        super(n);

        if(o==null)
            o=n;
        
        squareChanged = o.square != n.square;
        crossChanged = o.cross != n.cross;
        circleChanged = o.circle != n.circle;
        triangleChanged = o.triangle != n.triangle;
        L1Changed = o.L1 != n.L1;
        R1Changed = o.R1 != n.R1;
        L2Changed = o.L2 != n.L2;
        R2Changed = o.R2 != n.R2;
        selectChanged = o.select != n.select;
        startChanged = o.start != n.start;
        leftJoystickPressChanged = o.leftJoystickPress != n.leftJoystickPress;
        rightJoystickPressChanged = o.rightJoystickPress != n.rightJoystickPress;
        homeChanged = o.home != n.home;

        leftJoystickXChange = n.leftJoystickX - o.leftJoystickX;
        leftJoystickYChange = n.leftJoystickY - o.leftJoystickY;
        rightJoystickXChange = n.rightJoystickX - o.rightJoystickX;
        rightJoystickYChange = n.rightJoystickY - o.rightJoystickY;

        orientationXChange = n.orientationX - o.orientationX;
        orientationYChange = n.orientationY - o.orientationY;
        orientationZChange = n.orientationZ - o.orientationZ;

        dpadUpChanged = n.dpadUp != o.dpadUp;
        dpadDownChanged = n.dpadDown != o.dpadDown;
        dpadLeftChanged = n.dpadLeft != o.dpadLeft;
        dpadRightChanged = n.dpadRight != o.dpadRight;

        buttonStateChanged = squareChanged || crossChanged || circleChanged || triangleChanged || L1Changed
                || R1Changed || L2Changed || R2Changed || selectChanged || startChanged || leftJoystickPressChanged
                || rightJoystickPressChanged || homeChanged || dpadUpChanged || dpadDownChanged || dpadLeftChanged || dpadRightChanged;

        leftJoystickChanged = leftJoystickXChange != 0 || leftJoystickYChange != 0;
        rightJoystickChanged = rightJoystickXChange != 0 || rightJoystickYChange != 0;

        joysticksChanged = leftJoystickChanged || rightJoystickChanged;

        dpadChanged = dpadUpChanged || dpadDownChanged || dpadLeftChanged || dpadRightChanged;

        orientationChanged = orientationXChange != 0 || orientationYChange != 0 || orientationZChange != 0;

        changed = joysticksChanged || buttonStateChanged || dpadChanged || orientationChanged;

    }

    public int getLeftJoystickXChange()
    {
        return leftJoystickXChange;
    }

    public int getLeftJoystickYChange()
    {
        return leftJoystickYChange;
    }

    public int getRightJoystickXChange()
    {
        return rightJoystickXChange;
    }

    public int getRightJoystickYChange()
    {
        return rightJoystickYChange;
    }

    public boolean isButtonStateChanged()
    {
        return buttonStateChanged;
    }

    public boolean isChanged()
    {
        return changed;
    }

    public boolean isCircleChanged()
    {
        return circleChanged;
    }

    public boolean isCrossChanged()
    {
        return crossChanged;
    }

    public boolean isJoysticksChanged()
    {
        return joysticksChanged;
    }

    public boolean isL1Changed()
    {
        return L1Changed;
    }

    public boolean isL2Changed()
    {
        return L2Changed;
    }

    public boolean isLeftJoystickChanged()
    {
        return leftJoystickChanged;
    }

    public boolean isLeftJoystickPressChanged()
    {
        return leftJoystickPressChanged;
    }

    public boolean isHomeChanged()
    {
        return homeChanged;
    }

    public boolean isR1Changed()
    {
        return R1Changed;
    }

    public boolean isR2Changed()
    {
        return R2Changed;
    }

    public boolean isRightJoystickChanged()
    {
        return rightJoystickChanged;
    }

    public boolean isRightJoystickPressChanged()
    {
        return rightJoystickPressChanged;
    }

    public boolean isSelectChanged()
    {
        return selectChanged;
    }

    public boolean isSquareChanged()
    {
        return squareChanged;
    }

    public boolean isStartChanged()
    {
        return startChanged;
    }

    public boolean isTriangleChanged()
    {
        return triangleChanged;
    }

    public boolean isDpadUpChanged()
    {
        return dpadUpChanged;
    }

    public boolean isDpadDownChanged()
    {
        return dpadDownChanged;
    }

    public boolean isDpadRightChanged()
    {
        return dpadRightChanged;
    }

    public boolean isDpadLeftChanged()
    {
        return dpadLeftChanged;
    }

    public boolean isDpadChanged()
    {
        return dpadChanged;
    }

    public boolean isOrientationChanged()
    {
        return orientationChanged;
    }

    public int getOrientationXChanged()
    {
        return orientationXChange;
    }

    public int getOrientationYChanged()
    {
        return orientationYChange;
    }

    public int getOrientationZChanged()
    {
        return orientationZChange;
    }

}


package org.tomcurran.controlpad.controllers.decoders;

import java.io.IOException;
import java.util.BitSet;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.GameControllerState;

/**
 * "Afterglow" controller for PS3 state decodder
 * 
 * @author lord
 * 
 */
public class AfterGlowControllerDecoder implements ControllerStateDecoder
{
  
    private int joystickCoordConv(byte b)
    {
        int v = b < 0 ? b + 256 : b;
        return v - 128;
    }

    @Override
    public GameControllerState decodeState(ControllerData data) throws IOException
    {
        byte[] buf = data.getBuffer();

        BitSet bs = new BitSet(13);
        for(int i = 0; i < 8; i++)
        {
            if((1 & (buf[0] >> i)) == 1)
                bs.set(i);
        }
        for(int i = 0; i < 5; i++)
        {
            if((1 & (buf[1] >> i)) == 1)
                bs.set(8 + i);
        }

        int i = 0;
        boolean square = bs.get(i++);
        boolean cross = bs.get(i++);
        boolean circle = bs.get(i++);
        boolean triangle = bs.get(i++);
        boolean L1 = bs.get(i++);
        boolean R1 = bs.get(i++);
        boolean L2 = bs.get(i++);
        boolean R2 = bs.get(i++);
        boolean select = bs.get(i++);
        boolean start = bs.get(i++);
        boolean leftJoystickPress = bs.get(i++);
        boolean rightJoystickPress = bs.get(i++);
        boolean PS = bs.get(i++);

        int leftJoystickX = joystickCoordConv(buf[3]);
        int leftJoystickY = joystickCoordConv(buf[4]);
        int rightJoystickX = joystickCoordConv(buf[5]);
        int rightJoystickY = joystickCoordConv(buf[6]);
        
        boolean dpadUp = false;
        boolean dpadDown = false;
        boolean dpadRight = false;
        boolean dpadLeft = false;

        int orientationX = 0;
        int orientationY = 0;
        int orientationZ = 0;

        GameControllerState res = new GameControllerState(
        		square, cross, circle, triangle,
        		dpadUp, dpadDown, dpadLeft, dpadRight,
        		L1, R1, L2, R2,
        		select, start, PS,
                leftJoystickPress, rightJoystickPress,
                leftJoystickX, leftJoystickY, rightJoystickX, rightJoystickY,
                orientationX, orientationY, orientationZ);

        return res;
    }
}

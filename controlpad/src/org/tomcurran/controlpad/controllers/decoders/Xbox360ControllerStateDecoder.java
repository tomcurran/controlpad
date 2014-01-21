package org.tomcurran.controlpad.controllers.decoders;

import java.io.IOException;
import java.util.BitSet;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.GameControllerState;

public class Xbox360ControllerStateDecoder implements ControllerStateDecoder {

    private int triggerCoordConv(byte b)
    {
    	return b & 0xFF;
    }

    public GameControllerState decodeState(ControllerData data) throws IOException {
        
        byte[] buf = data.getBuffer();
        
        BitSet bs = new BitSet(24);
        for(int i = 0; i < 8; i++)
        {
            if((1 & (buf[2] >> i)) == 1)
                bs.set(i);
        }
        for(int i = 0; i < 8; i++)
        {
            if((1 & (buf[3] >> i)) == 1)
                bs.set(8 + i);
        }

        int i = 0;
        boolean dpadUp = bs.get(i++);
        boolean dpadDown = bs.get(i++);
        boolean dpadLeft = bs.get(i++);
        boolean dpadRight = bs.get(i++);
        boolean start = bs.get(i++);
        boolean select = bs.get(i++);
        boolean leftJoystickPress = bs.get(i++);
        boolean rightJoystickPress = bs.get(i++);
        boolean L1 = bs.get(i++);
        boolean R1 = bs.get(i++);
        boolean home = bs.get(i++);
        @SuppressWarnings("unused")
		boolean sync = bs.get(i++);
        boolean cross = bs.get(i++);    // a
        boolean circle = bs.get(i++);   // b
        boolean square = bs.get(i++);   // x
        boolean triangle = bs.get(i++); // y

        int leftTrigger = triggerCoordConv(buf[4]);
        int rightTrigger = triggerCoordConv(buf[5]);

        boolean L2 = leftTrigger > 0;
        boolean R2 = rightTrigger > 0; 

        int leftJoystickX = buf[7];
        int leftJoystickY = buf[9];
        int rightJoystickX = buf[11];
        int rightJoystickY = buf[13];

        int orientationX = 0;
        int orientationY = 0;
        int orientationZ = 0;

        GameControllerState res = new GameControllerState(
        		square, cross, circle, triangle,
        		dpadUp, dpadDown, dpadLeft, dpadRight,
        		L1, R1, L2, R2,
        		select, start, home,
                leftJoystickPress, rightJoystickPress,
                leftJoystickX, leftJoystickY, rightJoystickX, rightJoystickY,
                orientationX, orientationY, orientationZ);
        
        return res;
    }

}

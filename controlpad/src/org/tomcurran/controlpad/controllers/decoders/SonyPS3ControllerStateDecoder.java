package org.tomcurran.controlpad.controllers.decoders;

import java.io.IOException;
import java.util.BitSet;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.GameControllerState;

public class SonyPS3ControllerStateDecoder implements ControllerStateDecoder {
    
    private int joystickCoordConv(byte b)
    {
        int v = b < 0 ? b + 256 : b;
        return(v - 128);
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
        for(int i = 0; i < 8; i++)
        {
            if((1 & (buf[4] >> i)) == 1)
                bs.set(16 + i);
        }

        int i = 0;
        boolean select = bs.get(i++);
        boolean leftJoystickPress = bs.get(i++);
        boolean rightJoystickPress = bs.get(i++);
        boolean start = bs.get(i++);
        boolean dpadUp = bs.get(i++);
        boolean dpadRight = bs.get(i++);
        boolean dpadDown = bs.get(i++);
        boolean dpadLeft = bs.get(i++);
        boolean L2 = bs.get(i++);
        boolean R2 = bs.get(i++);
        boolean L1 = bs.get(i++);
        boolean R1 = bs.get(i++);
        boolean triangle = bs.get(i++);
        boolean circle = bs.get(i++);
        boolean cross = bs.get(i++);
        boolean square = bs.get(i++);
        boolean PS = bs.get(i++);

        int leftJoystickX = joystickCoordConv(buf[6]);
        int leftJoystickY = joystickCoordConv(buf[7]);
        int rightJoystickX = joystickCoordConv(buf[8]);
        int rightJoystickY = joystickCoordConv(buf[9]);
 
		int orientationX = buf[42];
        int orientationY = buf[44];
        int orientationZ = buf[46];

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

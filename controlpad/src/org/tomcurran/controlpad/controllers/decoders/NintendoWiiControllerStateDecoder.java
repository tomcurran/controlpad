package org.tomcurran.controlpad.controllers.decoders;

import java.io.IOException;
import java.util.BitSet;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.GameControllerState;

public class NintendoWiiControllerStateDecoder implements ControllerStateDecoder {

	public GameControllerState decodeState(ControllerData data) throws IOException {
        
        byte[] buf = data.getBuffer();
        
        BitSet bs = new BitSet(24);
        for(int i = 0; i < 8; i++) {
            if((1 & (buf[1] >> i)) == 1)
                bs.set(i);
        }
        for(int i = 0; i < 8; i++) {
            if((1 & (buf[2] >> i)) == 1)
                bs.set(8 + i);
        }

        int i = 0;
        boolean dpadLeft = bs.get(i++);
        boolean dpadRight = bs.get(i++);
        boolean dpadDown = bs.get(i++);
        boolean dpadUp = bs.get(i++);
        boolean plus = bs.get(i++);		// +
        i++;
        i++;
        i++;							// unknown
        boolean two = bs.get(i++);		// 2
        boolean one = bs.get(i++);		// 1
        boolean circle = bs.get(i++);	// B
        boolean cross = bs.get(i++);	// A
        boolean minus = bs.get(i++);	// -
        i++;
        i++;
        boolean home = bs.get(i++);

        // not implements
        boolean select = false;
        boolean leftJoystickPress = false;
        boolean rightJoystickPress = false;
        boolean start = false;
        boolean L2 = false;
        boolean R2 = false;
        boolean L1 = false;
        boolean R1 = false;
        boolean triangle = false;
        boolean square = false;

        int leftJoystickX = 0;
        int leftJoystickY = 0;
        int rightJoystickX = 0;
        int rightJoystickY = 0;

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

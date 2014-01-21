package org.tomcurran.controlpad.controllers.decoders;

import java.io.IOException;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.GameControllerState;

public interface ControllerStateDecoder {
    
    public GameControllerState decodeState(ControllerData data) throws IOException;
}

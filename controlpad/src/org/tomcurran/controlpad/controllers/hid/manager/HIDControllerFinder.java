package org.tomcurran.controlpad.controllers.hid.manager;

import java.io.IOException;

import org.tomcurran.controlpad.controllers.Controller;
import org.tomcurran.controlpad.controllers.hid.HIDAPIAfterGlowController;
import org.tomcurran.controlpad.controllers.hid.HIDAPIMotioninJoyVirtualController;
import org.tomcurran.controlpad.controllers.hid.HIDAPINintendoWiiController;
import org.tomcurran.controlpad.controllers.hid.HIDAPISonyPS3Controller;
import org.tomcurran.controlpad.controllers.hid.HIDAPIXbox360Controller;

import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDManager;

public class HIDControllerFinder {
    
    public static Controller findController() throws IOException
    {

        HIDDeviceInfo[] devs = HIDManager.getInstance().listDevices();
        if (null != devs) {
            for(int i = 0; i < devs.length; i++)
            {
                if(HIDAPINintendoWiiController.isA(devs[i]))
                    return new HIDAPINintendoWiiController(devs[i]);
                if(HIDAPIXbox360Controller.isA(devs[i]))
                    return new HIDAPIXbox360Controller(devs[i]);
                if(HIDAPISonyPS3Controller.isA(devs[i]))
                    return new HIDAPISonyPS3Controller(devs[i]);
                if(HIDAPIAfterGlowController.isA(devs[i]))
                    return new HIDAPIAfterGlowController(devs[i]);
                if(HIDAPIMotioninJoyVirtualController.isA(devs[i]))
                    return new HIDAPIMotioninJoyVirtualController(devs[i]);
            }
        }
        return null;
    }
}

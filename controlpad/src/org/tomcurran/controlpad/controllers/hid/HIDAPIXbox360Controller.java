
package org.tomcurran.controlpad.controllers.hid;

import java.io.IOException;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.decoders.Xbox360ControllerStateDecoder;

import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDDeviceNotFoundException;

public class HIDAPIXbox360Controller extends HIDAPIController
{
    private static final int VENDOR_ID          = 1118;
    private static final int PRODUCT_ID         = 654;

    private static final int BUFSIZE            = 28;
    private static final int EXPECTED_BUFSIZE   = 14;
    private static final int EXPECTED_BUFSIZE_2 = 20;

    static final Xbox360ControllerStateDecoder decoder = new Xbox360ControllerStateDecoder();
    
    public HIDAPIXbox360Controller() throws HIDDeviceNotFoundException, IOException
    {
        super(VENDOR_ID, PRODUCT_ID, decoder, BUFSIZE);
    }

    public HIDAPIXbox360Controller(HIDDeviceInfo hidDeviceInfo) throws IOException
    {
        super(decoder, BUFSIZE, hidDeviceInfo);
    }

    @Override
    public String getName() {
        return "HID API connected Xbox360Controller";
    }

    @Override
    public boolean isValid(ControllerData data) throws IOException {
        if(data.getActualBufferDataLength() != EXPECTED_BUFSIZE && data.getActualBufferDataLength() != EXPECTED_BUFSIZE_2)
        {
            throw new IOException("Received packed with unexpected size " + data.getActualBufferDataLength());
        }
        return true;
    }
    
    public static boolean isA(HIDDeviceInfo hidDeviceInfo) {
        return VENDOR_ID == hidDeviceInfo.getVendor_id() &&  PRODUCT_ID == hidDeviceInfo.getProduct_id();
    }
}

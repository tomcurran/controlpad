
package org.tomcurran.controlpad.controllers.hid;

import java.io.IOException;

import org.tomcurran.controlpad.controllers.ControllerData;
import org.tomcurran.controlpad.controllers.decoders.NintendoWiiControllerStateDecoder;

import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDDeviceNotFoundException;

public class HIDAPINintendoWiiController extends HIDAPIController
{
    private static final int VENDOR_ID          = 1406;
    private static final int PRODUCT_ID         = 774;

    private static final int BUFSIZE            = 32;
    private static final int EXPECTED_BUFSIZE   = 3;
    private static final int EXPECTED_BUFSIZE_2 = 7;

    static final NintendoWiiControllerStateDecoder decoder = new NintendoWiiControllerStateDecoder();
    
    public HIDAPINintendoWiiController() throws HIDDeviceNotFoundException, IOException
    {
        super(VENDOR_ID, PRODUCT_ID, decoder, BUFSIZE);
    }

    public HIDAPINintendoWiiController(HIDDeviceInfo hidDeviceInfo) throws IOException
    {
        super(decoder, BUFSIZE, hidDeviceInfo);
    }

    @Override
    public String getName() {
        return "HID API connected NintendoWiiController";
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

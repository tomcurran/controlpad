
package org.tomcurran.controlpad.tools;

import java.io.IOException;

import org.tomcurran.controlpad.controllers.Controller;
import org.tomcurran.controlpad.controllers.ControllerStateChange;
import org.tomcurran.controlpad.controllers.GameControllerState;
import org.tomcurran.controlpad.controllers.hid.manager.HIDControllerFinder;

import com.codeminders.hidapi.ClassPathLibraryLoader;

public class ControllerTest
{
    private static final long READ_UPDATE_DELAY_MS = 30L;

    static
    {
        ClassPathLibraryLoader.loadNativeHIDLibrary();
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            Controller c = findController();
            if(c == null)
            {
                System.err.println("Controller not found");
                System.exit(1);
            } else
            {
                System.err.println("Controller found "+c);
            }
            try
            {
            	GameControllerState oldX = null;
                while(true)
                {
                	GameControllerState x = c.read();
                    ControllerStateChange x_change = new ControllerStateChange(oldX, x);
                    if (x_change.isChanged()) {
                    	System.err.println(x);
                    }
                	oldX = x;
                    try
                    {
                        Thread.sleep(READ_UPDATE_DELAY_MS);
                    } catch(InterruptedException e)
                    {
                        // Ignore
                    }
                }
            } finally
            {
                c.close();
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    private static Controller findController() throws IOException
    {
        return HIDControllerFinder.findController();
    }

}

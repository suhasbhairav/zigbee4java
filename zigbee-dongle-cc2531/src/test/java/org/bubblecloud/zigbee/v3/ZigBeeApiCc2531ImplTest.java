

package org.bubblecloud.zigbee.v3;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Test class for local ZigBee API.
 */
public class ZigBeeApiCc2531ImplTest {
    /**
     * The LOGGER.
     */
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ZigBeeApiCc2531ImplTest.class);


    /**
     * Tests local ZigBee API.
     */
    @Test
    @Ignore
    public void testZigBeeApiLocal() {
        final SerialPort port = null;// = new SerialPortImpl("COM5");
        final ZigBeeTransport dongle = new ZigBeeDongleTiCc2531Impl(port, 4951, 11, null, false);

//        final ZigBeeApiDongleImpl api = new ZigBeeApiDongleImpl(dongle, false);
        ZigBeeNetworkManager networkManager = new ZigBeeNetworkManager(dongle, false);

        networkManager.getNetworkState().addNetworkListener(new ZigBeeNetworkStateListener() {
            @Override
            public void deviceAdded(ZigBeeDevice device) {
                LOGGER.info("Device added: " + device);
            }

            @Override
            public void deviceUpdated(ZigBeeDevice device) {
                LOGGER.info("Device updated: " + device);
            }

            @Override
            public void deviceRemoved(ZigBeeDevice device) {
                LOGGER.info("Device removed: " + device);
            }

            @Override
            public void nodeAdded(ZigBeeNode node) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void nodeUpdated(ZigBeeNode node) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void nodeRemoved(ZigBeeNode node) {
                // TODO Auto-generated method stub
                
            }
        });

        networkManager.startup();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        final List<ZigBeeDevice> devices = networkManager.getNetworkState().getDevices();
        for (final ZigBeeDevice device : devices) {
            LOGGER.info(device.toString());
        }

        networkManager.shutdown();
        port.close();
    }

}

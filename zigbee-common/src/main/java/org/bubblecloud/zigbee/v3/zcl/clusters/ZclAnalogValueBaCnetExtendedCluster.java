package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeDeviceAddress;
import org.bubblecloud.zigbee.v3.ZigBeeNetworkManager;
import org.bubblecloud.zigbee.v3.zcl.ZclAttribute;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>Analog Value (BACnet Extended)</b> cluster implementation (<i>Cluster ID 0x0607</i>).
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclAnalogValueBaCnetExtendedCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0607;

    // Cluster Name
    public static final String CLUSTER_NAME = "Analog Value (BACnet Extended)";

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(0);


        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclAnalogValueBaCnetExtendedCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }


}

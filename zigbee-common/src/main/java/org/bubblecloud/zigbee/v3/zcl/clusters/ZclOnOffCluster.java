package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeDeviceAddress;
import org.bubblecloud.zigbee.v3.ZigBeeNetworkManager;
import org.bubblecloud.zigbee.v3.zcl.ZclAttribute;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.onoff.OffCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.onoff.OnCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.onoff.ToggleCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>On/Off</b> cluster implementation (<i>Cluster ID 0x0006</i>).
 * <p>
 * Attributes and commands for switching devices between ‘On’ and ‘Off’ states.
 * </p>
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclOnOffCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0006;

    // Cluster Name
    public static final String CLUSTER_NAME = "On/Off";

    // Attribute constants
    private final int ATTR_ONOFF = 0x0000;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(1);

        attributeMap.put(ATTR_ONOFF, new ZclAttribute(0, "OnOff", ZclDataType.BOOLEAN, true, true, false, true));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclOnOffCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }



    /**
     * Get the <i>OnOff</i> attribute
     * <p>
     * The OnOff attribute has the following values: 0 = Off, 1 = On
     * </p>
     * The attribute is of type {@link Boolean}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getOnOff() {
        return read(ATTR_ONOFF);
    }


    /**
     * Configure reporting for the <i>OnOff</i> attribute
     * <p>
     * The OnOff attribute has the following values: 0 = Off, 1 = On
     * </p>
     * The attribute is of type {@link Boolean}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configOnOffReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_ONOFF, minInterval, maxInterval, reportableChange);
    }


    /**
     * The Off Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> offCommand() {
        return send(new OffCommand());
    }


    /**
     * The On Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> onCommand() {
        return send(new OnCommand());
    }


    /**
     * The Toggle Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> toggleCommand() {
        return send(new ToggleCommand());
    }


    /**
     * Add a binding for this cluster to the local node
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> bind() {
        return bind();
    }

}

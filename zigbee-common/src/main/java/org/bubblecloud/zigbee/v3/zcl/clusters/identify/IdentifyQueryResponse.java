package org.bubblecloud.zigbee.v3.zcl.clusters.identify;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;


/**
 *  Identify Query Response value object class.
 * 
 * The identify query response command is generated in response to receiving an
 * Identify Query command in the case that the device is currently identifying itself.
 * 
 * Cluster: Identify
 * Attributes and commands to put a device into an Identification mode (e.g. flashing
 * a light), that indicates to an observer – e.g. an installer - which of several devices
 * it is, also to request any device that is identifying itself to respond to the initiator.
 * <br>
 * Note that this cluster cannot be disabled, and remains functional regardless of the
 * setting of the DeviceEnable attribute in the Basic cluster.
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class IdentifyQueryResponse extends ZclCommand {
    /**
     * Identify Time command message field.
     */
    private Integer identifyTime;

    /**
     * Default constructor setting the command type field.
     */
    public IdentifyQueryResponse() {
        setType(ZclCommandType.IDENTIFY_QUERY_RESPONSE);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public IdentifyQueryResponse(final ZclCommandMessage message) {
        super(message);
        this.identifyTime = (Integer) message.getFields().get(ZclFieldType.IDENTIFY_QUERY_RESPONSE_IDENTIFY_TIME);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.IDENTIFY_QUERY_RESPONSE_IDENTIFY_TIME,identifyTime);
        return message;
    }

    /**
     * Gets Identify Time.
     * @return the Identify Time
     */
    public Integer getIdentifyTime() {
        return identifyTime;
    }

    /**
     * Sets Identify Time.
     * @param identifyTime the Identify Time
     */
    public void setIdentifyTime(final Integer identifyTime) {
        this.identifyTime = identifyTime;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("identifyTime");
        builder.append('=');
        builder.append(identifyTime);
        return builder.toString();
    }

}
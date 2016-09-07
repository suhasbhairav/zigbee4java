package org.bubblecloud.zigbee.v3.zcl.clusters.general;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;
import org.bubblecloud.zigbee.v3.zcl.field.*;

import java.util.List;

/**
 *  Write Attributes Response value object class.
 * 
 * The write attributes response command is generated in response to a write
 * attributes command.
 * 
 * Cluster: General
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class WriteAttributesResponse extends ZclCommand {
    /**
     * Records command message field.
     */
    private List<WriteAttributeStatusRecord> records;

    /**
     * Default constructor setting the command type field.
     */
    public WriteAttributesResponse() {
        setType(ZclCommandType.WRITE_ATTRIBUTES_RESPONSE);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public WriteAttributesResponse(final ZclCommandMessage message) {
        super(message);
        this.records = (List<WriteAttributeStatusRecord>) message.getFields().get(ZclFieldType.WRITE_ATTRIBUTES_RESPONSE_RECORDS);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.WRITE_ATTRIBUTES_RESPONSE_RECORDS,records);
        return message;
    }

    /**
     * Gets Records.
     * @return the Records
     */
    public List<WriteAttributeStatusRecord> getRecords() {
        return records;
    }

    /**
     * Sets Records.
     * @param records the Records
     */
    public void setRecords(final List<WriteAttributeStatusRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("records");
        builder.append('=');
        builder.append(records);
        return builder.toString();
    }

}

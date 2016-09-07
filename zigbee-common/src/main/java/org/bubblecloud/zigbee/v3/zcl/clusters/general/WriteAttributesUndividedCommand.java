package org.bubblecloud.zigbee.v3.zcl.clusters.general;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;
import org.bubblecloud.zigbee.v3.zcl.field.*;

import java.util.List;

/**
 * Write Attributes Undivided Command value object class.
 * 
 * The write attributes undivided command is generated when a device wishes to
 * change the values of one or more attributes located on another device, in such a
 * way that if any attribute cannot be written (e.g. if an attribute is not implemented
 * on the device, or a value to be written is outside its valid range), no attribute
 * values are changed.
 * <br>
 * In all other respects, including generation of a write attributes response command,
 * the format and operation of the command is the same as that of the write attributes
 * command, except that the command identifier field shall be set to indicate the
 * write attributes undivided command.
 * 
 * Cluster: General
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class WriteAttributesUndividedCommand extends ZclCommand {
    /**
     * Records command message field.
     */
    private List<WriteAttributeRecord> records;

    /**
     * Default constructor setting the command type field.
     */
    public WriteAttributesUndividedCommand() {
        setType(ZclCommandType.WRITE_ATTRIBUTES_UNDIVIDED_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public WriteAttributesUndividedCommand(final ZclCommandMessage message) {
        super(message);
        this.records = (List<WriteAttributeRecord>) message.getFields().get(ZclFieldType.WRITE_ATTRIBUTES_UNDIVIDED_COMMAND_RECORDS);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.WRITE_ATTRIBUTES_UNDIVIDED_COMMAND_RECORDS,records);
        return message;
    }

    /**
     * Gets Records.
     * @return the Records
     */
    public List<WriteAttributeRecord> getRecords() {
        return records;
    }

    /**
     * Sets Records.
     * @param records the Records
     */
    public void setRecords(final List<WriteAttributeRecord> records) {
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

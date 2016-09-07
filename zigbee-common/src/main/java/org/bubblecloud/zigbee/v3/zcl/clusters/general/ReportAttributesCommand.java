package org.bubblecloud.zigbee.v3.zcl.clusters.general;

import org.bubblecloud.zigbee.v3.zcl.ZclCommandMessage;
import org.bubblecloud.zigbee.v3.zcl.ZclCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclCommandType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;
import org.bubblecloud.zigbee.v3.zcl.field.*;

import java.util.List;

/**
 * Report Attributes Command value object class.
 * 
 * The report attributes command is used by a device to report the values of one or
 * more of its attributes to another device, bound a priori. Individual clusters, defined
 * elsewhere in the ZCL, define which attributes are to be reported and at what
 * interval.
 * 
 * Cluster: General
 * 
 * Code is autogenerated. Modifications may be overwritten!
 */
public class ReportAttributesCommand extends ZclCommand {
    /**
     * Reports command message field.
     */
    private List<AttributeReport> reports;

    /**
     * Default constructor setting the command type field.
     */
    public ReportAttributesCommand() {
        setType(ZclCommandType.REPORT_ATTRIBUTES_COMMAND);
    }

    /**
     * Constructor copying field values from command message.
     * @param message the command message
     */
    public ReportAttributesCommand(final ZclCommandMessage message) {
        super(message);
        this.reports = (List<AttributeReport>) message.getFields().get(ZclFieldType.REPORT_ATTRIBUTES_COMMAND_REPORTS);
    }

    @Override
    public ZclCommandMessage toCommandMessage() {
        final ZclCommandMessage message = super.toCommandMessage();
        message.getFields().put(ZclFieldType.REPORT_ATTRIBUTES_COMMAND_REPORTS,reports);
        return message;
    }

    /**
     * Gets Reports.
     * @return the Reports
     */
    public List<AttributeReport> getReports() {
        return reports;
    }

    /**
     * Sets Reports.
     * @param reports the Reports
     */
    public void setReports(final List<AttributeReport> reports) {
        this.reports = reports;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(", ");
        builder.append("reports");
        builder.append('=');
        builder.append(reports);
        return builder.toString();
    }

}

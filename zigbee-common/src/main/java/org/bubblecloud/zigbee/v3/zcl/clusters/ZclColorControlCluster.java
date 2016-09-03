package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeApi;
import org.bubblecloud.zigbee.v3.ZigBeeDevice;
import org.bubblecloud.zigbee.v3.zcl.ZclAttribute;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveColorCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveHueCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveSaturationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveToColorCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveToColorTemperatureCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveToHueAndSaturationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveToHueCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.MoveToSaturationCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.StepColorCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.StepHueCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.colorcontrol.StepSaturationCommand;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>Color control</b> cluster implementation (<i>Cluster ID 0x0300</i>).
 * <p>
 * This cluster provides an interface for changing the color of a light. Color is
 * specified according to the Commission Internationale de l'Éclairage (CIE)
 * specification CIE 1931 Color Space, [B4]. Color control is carried out in terms of
 * x,y values, as defined by this specification.
 * </p>
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclColorControlCluster extends ZclCluster {
    // Cluster ID
    private static final int CLUSTER_ID = 0x0300;

    // Attribute constants
    private final int ATTR_CURRENTHUE = 0x0000;
    private final int ATTR_CURRENTSATURATION = 0x0001;
    private final int ATTR_REMAININGTIME = 0x0002;
    private final int ATTR_CURRENTX = 0x0003;
    private final int ATTR_CURRENTY = 0x0004;
    private final int ATTR_DRIFTCOMPENSATION = 0x0005;
    private final int ATTR_COMPENSATIONTEXT = 0x0006;
    private final int ATTR_COLORTEMPERATURE = 0x0007;
    private final int ATTR_COLORMODE = 0x0008;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(9);

        attributeMap.put(ATTR_CURRENTHUE, new ZclAttribute(0, ZclDataType.UNSIGNED_8_BIT_INTEGER, 
                false, true, false, true));
        attributeMap.put(ATTR_CURRENTSATURATION, new ZclAttribute(1, ZclDataType.UNSIGNED_8_BIT_INTEGER, 
                false, true, false, true));
        attributeMap.put(ATTR_REMAININGTIME, new ZclAttribute(2, ZclDataType.UNSIGNED_16_BIT_INTEGER, 
                false, true, false, false));
        attributeMap.put(ATTR_CURRENTX, new ZclAttribute(3, ZclDataType.UNSIGNED_16_BIT_INTEGER, 
                true, true, false, true));
        attributeMap.put(ATTR_CURRENTY, new ZclAttribute(4, ZclDataType.UNSIGNED_16_BIT_INTEGER, 
                true, true, false, true));
        attributeMap.put(ATTR_DRIFTCOMPENSATION, new ZclAttribute(5, ZclDataType.ENUMERATION_8_BIT, 
                false, true, false, false));
        attributeMap.put(ATTR_COMPENSATIONTEXT, new ZclAttribute(6, ZclDataType.CHARACTER_STRING, 
                false, true, false, false));
        attributeMap.put(ATTR_COLORTEMPERATURE, new ZclAttribute(7, ZclDataType.UNSIGNED_16_BIT_INTEGER, 
                false, true, false, true));
        attributeMap.put(ATTR_COLORMODE, new ZclAttribute(8, ZclDataType.ENUMERATION_8_BIT, 
                false, true, false, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclColorControlCluster(final ZigBeeApi zigbeeApi, final ZigBeeDevice zigbeeDevice) {
        super(zigbeeApi, zigbeeDevice, CLUSTER_ID);
    }



    /**
     * Get the <i>CurrentHue</i> attribute
     * <p>
     * The CurrentHue attribute contains the current hue value of the light. It is updated
     * as fast as practical during commands that change the hue.
     * <br>
     * The hue in degrees shall be related to the CurrentHue attribute by the relationship
     * Hue = CurrentHue x 360 / 254 (CurrentHue in the range 0 - 254 inclusive)
     * <br>
     * If this attribute is implemented then the CurrentSaturation and ColorMode
     * attributes shall also be implemented.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentHue() {
        return read(ATTR_CURRENTHUE);
    }


    /**
     * Configure reporting for the <i>CurrentHue</i> attribute
     * <p>
     * The CurrentHue attribute contains the current hue value of the light. It is updated
     * as fast as practical during commands that change the hue.
     * <br>
     * The hue in degrees shall be related to the CurrentHue attribute by the relationship
     * Hue = CurrentHue x 360 / 254 (CurrentHue in the range 0 - 254 inclusive)
     * <br>
     * If this attribute is implemented then the CurrentSaturation and ColorMode
     * attributes shall also be implemented.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configCurrentHueReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_CURRENTHUE, minInterval, maxInterval, reportableChange);
    }


    /**
     * Get the <i>CurrentSaturation</i> attribute
     * <p>
     * <br>
     * The CurrentSaturation attribute holds the current saturation value of the light. It is
     * updated as fast as practical during commands that change the saturation.
     * The saturation shall be related to the CurrentSaturation attribute by the
     * relationship
     * Saturation = CurrentSaturation/254 (CurrentSaturation in the range 0 - 254 inclusive)
     * If this attribute is implemented then the CurrentHue and ColorMode attributes
     * shall also be implemented.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentSaturation() {
        return read(ATTR_CURRENTSATURATION);
    }


    /**
     * Configure reporting for the <i>CurrentSaturation</i> attribute
     * <p>
     * <br>
     * The CurrentSaturation attribute holds the current saturation value of the light. It is
     * updated as fast as practical during commands that change the saturation.
     * The saturation shall be related to the CurrentSaturation attribute by the
     * relationship
     * Saturation = CurrentSaturation/254 (CurrentSaturation in the range 0 - 254 inclusive)
     * If this attribute is implemented then the CurrentHue and ColorMode attributes
     * shall also be implemented.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configCurrentSaturationReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_CURRENTSATURATION, minInterval, maxInterval, reportableChange);
    }


    /**
     * Get the <i>RemainingTime</i> attribute
     * <p>
     * <br>
     * The RemainingTime attribute holds the time remaining, in 1/10ths of a second,
     * until the currently active command will be complete.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getRemainingTime() {
        return read(ATTR_REMAININGTIME);
    }


    /**
     * Get the <i>CurrentX</i> attribute
     * <p>
     * <br>
     * The CurrentX attribute contains the current value of the normalized chromaticity
     * value x, as defined in the CIE xyY Color Space. It is updated as fast as practical
     * during commands that change the color.
     * <br>
     * The value of x shall be related to the CurrentX attribute by the relationship
     * <br>
     * x = CurrentX / 65535 (CurrentX in the range 0 to 65279 inclusive)
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentX() {
        return read(ATTR_CURRENTX);
    }


    /**
     * Configure reporting for the <i>CurrentX</i> attribute
     * <p>
     * <br>
     * The CurrentX attribute contains the current value of the normalized chromaticity
     * value x, as defined in the CIE xyY Color Space. It is updated as fast as practical
     * during commands that change the color.
     * <br>
     * The value of x shall be related to the CurrentX attribute by the relationship
     * <br>
     * x = CurrentX / 65535 (CurrentX in the range 0 to 65279 inclusive)
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configCurrentXReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_CURRENTX, minInterval, maxInterval, reportableChange);
    }


    /**
     * Get the <i>CurrentY</i> attribute
     * <p>
     * <br>
     * The CurrentY attribute contains the current value of the normalized chromaticity
     * value y, as defined in the CIE xyY Color Space. It is updated as fast as practical
     * during commands that change the color.
     * <br>
     * The value of y shall be related to the CurrentY attribute by the relationship
     * <br>
     * y = CurrentY / 65535 (CurrentY in the range 0 to 65279 inclusive)
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentY() {
        return read(ATTR_CURRENTY);
    }


    /**
     * Configure reporting for the <i>CurrentY</i> attribute
     * <p>
     * <br>
     * The CurrentY attribute contains the current value of the normalized chromaticity
     * value y, as defined in the CIE xyY Color Space. It is updated as fast as practical
     * during commands that change the color.
     * <br>
     * The value of y shall be related to the CurrentY attribute by the relationship
     * <br>
     * y = CurrentY / 65535 (CurrentY in the range 0 to 65279 inclusive)
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configCurrentYReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_CURRENTY, minInterval, maxInterval, reportableChange);
    }


    /**
     * Get the <i>DriftCompensation</i> attribute
     * <p>
     * <br>
     * The DriftCompensation attribute indicates what mechanism, if any, is in use for
     * compensation for color/intensity drift over time.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getDriftCompensation() {
        return read(ATTR_DRIFTCOMPENSATION);
    }


    /**
     * Get the <i>CompensationText</i> attribute
     * <p>
     * <br>
     * The CompensationText attribute holds a textual indication of what mechanism, if
     * any, is in use to compensate for color/intensity drift over time.
     * </p>
     * The attribute is of type {@link String}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCompensationText() {
        return read(ATTR_COMPENSATIONTEXT);
    }


    /**
     * Get the <i>ColorTemperature</i> attribute
     * <p>
     * <br>
     * The ColorTemperature attribute contains a scaled inverse of the current value of
     * the color temperature. It is updated as fast as practical during commands that
     * change the color.
     * <br>
     * The color temperature value in Kelvins shall be related to the ColorTemperature
     * attribute by the relationship
     * <br>
     * Color temperature = 1,000,000 / ColorTemperature (ColorTemperature in the
     * range 1 to 65279 inclusive, giving a color temperature range from 1,000,000
     * Kelvins to 15.32 Kelvins).
     * <br>
     * The value ColorTemperature = 0 indicates an undefined value. The value
     * ColorTemperature = 65535 indicates an invalid value.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getColorTemperature() {
        return read(ATTR_COLORTEMPERATURE);
    }


    /**
     * Configure reporting for the <i>ColorTemperature</i> attribute
     * <p>
     * <br>
     * The ColorTemperature attribute contains a scaled inverse of the current value of
     * the color temperature. It is updated as fast as practical during commands that
     * change the color.
     * <br>
     * The color temperature value in Kelvins shall be related to the ColorTemperature
     * attribute by the relationship
     * <br>
     * Color temperature = 1,000,000 / ColorTemperature (ColorTemperature in the
     * range 1 to 65279 inclusive, giving a color temperature range from 1,000,000
     * Kelvins to 15.32 Kelvins).
     * <br>
     * The value ColorTemperature = 0 indicates an undefined value. The value
     * ColorTemperature = 65535 indicates an invalid value.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param minInterval {@link int} minimum reporting period
     * @param maxInterval {@link int} maximum reporting period
     * @param reportableChange {@link Object} delta required to trigger report
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> configColorTemperatureReporting(final int minInterval, final int maxInterval, final Object reportableChange) {
        return report(ATTR_COLORTEMPERATURE, minInterval, maxInterval, reportableChange);
    }


    /**
     * Get the <i>ColorMode</i> attribute
     * <p>
     * <br>
     * The ColorMode attribute indicates which attributes are currently determining the
     * color of the device
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getColorMode() {
        return read(ATTR_COLORMODE);
    }


    /**
     * The Move to Hue Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveToHueCommand() {
        return send(new MoveToHueCommand());
    }


    /**
     * The Move Hue Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveHueCommand() {
        return send(new MoveHueCommand());
    }


    /**
     * The Step Hue Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> stepHueCommand() {
        return send(new StepHueCommand());
    }


    /**
     * The Move to Saturation Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveToSaturationCommand() {
        return send(new MoveToSaturationCommand());
    }


    /**
     * The Move Saturation Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveSaturationCommand() {
        return send(new MoveSaturationCommand());
    }


    /**
     * The Step Saturation Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> stepSaturationCommand() {
        return send(new StepSaturationCommand());
    }


    /**
     * The Move to Hue and Saturation Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveToHueAndSaturationCommand() {
        return send(new MoveToHueAndSaturationCommand());
    }


    /**
     * The Move to Color Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveToColorCommand() {
        return send(new MoveToColorCommand());
    }


    /**
     * The Move Color Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveColorCommand() {
        return send(new MoveColorCommand());
    }


    /**
     * The Step Color Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> stepColorCommand() {
        return send(new StepColorCommand());
    }


    /**
     * The Move to Color Temperature Command
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> moveToColorTemperatureCommand() {
        return send(new MoveToColorTemperatureCommand());
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

package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeDeviceAddress;
import org.bubblecloud.zigbee.v3.ZigBeeNetworkManager;
import org.bubblecloud.zigbee.v3.zcl.ZclAttribute;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.ResetStartupParametersCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.ResetStartupParametersResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.RestartDeviceCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.RestartDeviceResponseResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.RestoreStartupParametersCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.RestoreStartupParametersResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.SaveStartupParametersCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.commissioning.SaveStartupParametersResponse;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclFieldType;

/**
 * <b>Commissioning</b> cluster implementation (<i>Cluster ID 0x0015</i>).
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclCommissioningCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0015;

    // Cluster Name
    public static final String CLUSTER_NAME = "Commissioning";

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(0);


        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclCommissioningCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }



    /**
     * The Restart Device Command
     *
     * @param option {@link Integer} Option
     * @param delay {@link Integer} Delay
     * @param jitter {@link Integer} Jitter
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> restartDeviceCommand(Integer option, Integer delay, Integer jitter) {
        RestartDeviceCommand command = new RestartDeviceCommand();

        // Set the fields
        command.setOption(option);
        command.setDelay(delay);
        command.setJitter(jitter);

        return send(command);
    }


    /**
     * The Save Startup Parameters Command
     *
     * @param option {@link Integer} Option
     * @param index {@link Integer} Index
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> saveStartupParametersCommand(Integer option, Integer index) {
        SaveStartupParametersCommand command = new SaveStartupParametersCommand();

        // Set the fields
        command.setOption(option);
        command.setIndex(index);

        return send(command);
    }


    /**
     * The Restore Startup Parameters Command
     *
     * @param option {@link Integer} Option
     * @param index {@link Integer} Index
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> restoreStartupParametersCommand(Integer option, Integer index) {
        RestoreStartupParametersCommand command = new RestoreStartupParametersCommand();

        // Set the fields
        command.setOption(option);
        command.setIndex(index);

        return send(command);
    }


    /**
     * The Reset Startup Parameters Command
     *
     * @param option {@link Integer} Option
     * @param index {@link Integer} Index
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> resetStartupParametersCommand(Integer option, Integer index) {
        ResetStartupParametersCommand command = new ResetStartupParametersCommand();

        // Set the fields
        command.setOption(option);
        command.setIndex(index);

        return send(command);
    }


    /**
     * The  Restart Device Response Response
     *
     * @param status {@link Integer} Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> restartDeviceResponseResponse(Integer status) {
        RestartDeviceResponseResponse command = new RestartDeviceResponseResponse();

        // Set the fields
        command.setStatus(status);

        return send(command);
    }


    /**
     * The  Save Startup Parameters Response
     *
     * @param status {@link Integer} Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> saveStartupParametersResponse(Integer status) {
        SaveStartupParametersResponse command = new SaveStartupParametersResponse();

        // Set the fields
        command.setStatus(status);

        return send(command);
    }


    /**
     * The  Restore Startup Parameters Response
     *
     * @param status {@link Integer} Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> restoreStartupParametersResponse(Integer status) {
        RestoreStartupParametersResponse command = new RestoreStartupParametersResponse();

        // Set the fields
        command.setStatus(status);

        return send(command);
    }


    /**
     * The  Reset Startup Parameters Response
     *
     * @param status {@link Integer} Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> resetStartupParametersResponse(Integer status) {
        ResetStartupParametersResponse command = new ResetStartupParametersResponse();

        // Set the fields
        command.setStatus(status);

        return send(command);
    }

}

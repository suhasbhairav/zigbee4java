package org.bubblecloud.zigbee.v3.zcl.clusters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.bubblecloud.zigbee.v3.CommandResult;
import org.bubblecloud.zigbee.v3.ZigBeeDeviceAddress;
import org.bubblecloud.zigbee.v3.ZigBeeNetworkManager;
import org.bubblecloud.zigbee.v3.zcl.ZclAttribute;
import org.bubblecloud.zigbee.v3.zcl.ZclCluster;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.AddSceneCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.AddSceneResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.GetSceneMembershipCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.GetSceneMembershipResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.RecallSceneCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.RemoveAllScenesCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.RemoveAllScenesResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.RemoveSceneCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.RemoveSceneResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.StoreSceneCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.StoreSceneResponse;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.ViewSceneCommand;
import org.bubblecloud.zigbee.v3.zcl.clusters.scenes.ViewSceneResponse;
import org.bubblecloud.zigbee.v3.zcl.protocol.ZclDataType;

/**
 * <b>Scenes</b> cluster implementation (<i>Cluster ID 0x0005</i>).
 * <p>
 * The scenes cluster provides attributes and commands for setting up and recalling
 * scenes. Each scene corresponds to a set of stored values of specified attributes for
 * one or more clusters on the same end point as the scenes cluster.
 * <br>
 * In most cases scenes are associated with a particular group ID. Scenes may also
 * exist without a group, in which case the value 0x0000 replaces the group ID. Note
 * that extra care is required in these cases to avoid a scene ID collision, and that
 * commands related to scenes without a group may only be unicast, i.e.: they may
 * not be multicast or broadcast.
 * </p>
 * This code is autogenerated. Modifications may be overwritten!
 */
public class ZclScenesCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0005;

    // Cluster Name
    public static final String CLUSTER_NAME = "Scenes";

    // Attribute constants
    private final int ATTR_SCENECOUNT = 0x0000;
    private final int ATTR_CURRENTSCENE = 0x0001;
    private final int ATTR_CURRENTGROUP = 0x0002;
    private final int ATTR_SCENEVALID = 0x0003;
    private final int ATTR_NAMESUPPORT = 0x0004;
    private final int ATTR_LASTCONFIGUREDBY = 0x0005;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new HashMap<Integer, ZclAttribute>(6);

        attributeMap.put(ATTR_SCENECOUNT, new ZclAttribute(0, "SceneCount", ZclDataType.UNSIGNED_8_BIT_INTEGER, true, true, false, false));
        attributeMap.put(ATTR_CURRENTSCENE, new ZclAttribute(1, "CurrentScene", ZclDataType.UNSIGNED_8_BIT_INTEGER, true, true, false, false));
        attributeMap.put(ATTR_CURRENTGROUP, new ZclAttribute(2, "CurrentGroup", ZclDataType.UNSIGNED_16_BIT_INTEGER, true, true, false, false));
        attributeMap.put(ATTR_SCENEVALID, new ZclAttribute(3, "SceneValid", ZclDataType.BOOLEAN, true, true, false, false));
        attributeMap.put(ATTR_NAMESUPPORT, new ZclAttribute(4, "NameSupport", ZclDataType.BITMAP_8_BIT, true, true, false, false));
        attributeMap.put(ATTR_LASTCONFIGUREDBY, new ZclAttribute(5, "LastConfiguredBy", ZclDataType.IEEE_ADDRESS, false, true, false, false));

        return attributeMap;
    }

    /**
     * Default constructor.
     */
    public ZclScenesCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeDeviceAddress zigbeeAddress) {
        super(zigbeeManager, zigbeeAddress, CLUSTER_ID, CLUSTER_NAME);
    }



    /**
     * Get the <i>SceneCount</i> attribute
     * <p>
     * The SceneCount attribute specifies the number of scenes currently in the device's
     * scene table.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getSceneCount() {
        return read(ATTR_SCENECOUNT);
    }


    /**
     * Get the <i>CurrentScene</i> attribute
     * <p>
     * <br>
     * The CurrentScene attribute holds the Scene ID of the scene last invoked.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentScene() {
        return read(ATTR_CURRENTSCENE);
    }


    /**
     * Get the <i>CurrentGroup</i> attribute
     * <p>
     * <br>
     * The CurrentGroup attribute holds the Group ID of the scene last invoked, or
     * 0x0000 if the scene last invoked is not associated with a group.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentGroup() {
        return read(ATTR_CURRENTGROUP);
    }


    /**
     * Get the <i>SceneValid</i> attribute
     * <p>
     * <br>
     * The SceneValid attribute indicates whether the state of the device corresponds to
     * that associated with the CurrentScene and CurrentGroup attributes. TRUE
     * indicates that these attributes are valid, FALSE indicates that they are not valid.
     * <br>
     * Before a scene has been stored or recalled, this attribute is set to FALSE. After a
     * successful Store Scene or Recall Scene command it is set to TRUE. If, after a
     * scene is stored or recalled, the state of the device is modified, this attribute is set to
     * FALSE.
     * </p>
     * The attribute is of type {@link Boolean}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getSceneValid() {
        return read(ATTR_SCENEVALID);
    }


    /**
     * Get the <i>NameSupport</i> attribute
     * <p>
     * <br>
     * The most significant bit of the NameSupport attribute indicates whether or not
     * scene names are supported. A value of 1 indicates that they are supported, and a
     * value of 0 indicates that they are not supported.
     * </p>
     * The attribute is of type {@link Integer}<br>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getNameSupport() {
        return read(ATTR_NAMESUPPORT);
    }


    /**
     * Get the <i>LastConfiguredBy</i> attribute
     * <p>
     * <br>
     * The LastConfiguredBy attribute is 64-bits in length and specifies the IEEE address
     * of the device that last configured the scene table.
     * <br>
     * The value 0xffffffffffffffff indicates that the device has not been configured, or
     * that the address of the device that last configured the scenes cluster is not known.
     * </p>
     * The attribute is of type {@link Long}<br>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getLastConfiguredBy() {
        return read(ATTR_LASTCONFIGUREDBY);
    }


    /**
     * The Add Scene Command
     * <p>
     * The Add Scene command shall be addressed to a single device (not a group).
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> addSceneCommand() {
        return send(new AddSceneCommand());
    }


    /**
     * The View Scene Command
     * <p>
     * The View Scene command shall be addressed to a single device (not a group).
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> viewSceneCommand() {
        return send(new ViewSceneCommand());
    }


    /**
     * The Remove Scene Command
     * <p>
     * The Remove All Scenes may be addressed to a single device or to a group.
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> removeSceneCommand() {
        return send(new RemoveSceneCommand());
    }


    /**
     * The Remove All Scenes Command
     * <p>
     * The Remove All Scenes may be addressed to a single device or to a group.
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> removeAllScenesCommand() {
        return send(new RemoveAllScenesCommand());
    }


    /**
     * The Store Scene Command
     * <p>
     * The Store Scene command may be addressed to a single device or to a group.
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> storeSceneCommand() {
        return send(new StoreSceneCommand());
    }


    /**
     * The Recall Scene Command
     * <p>
     * The Recall Scene command may be addressed to a single device or to a group.
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> recallSceneCommand() {
        return send(new RecallSceneCommand());
    }


    /**
     * The Get Scene Membership Command
     * <p>
     * The Get Scene Membership command can be used to find an unused scene
     * number within the group when no commissioning tool is in the network, or for a
     * commissioning tool to get used scenes for a group on a single device or on all
     * devices in the group.
     * </p>
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getSceneMembershipCommand() {
        return send(new GetSceneMembershipCommand());
    }


    /**
     * The  Add Scene Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> addSceneResponse() {
        return send(new AddSceneResponse());
    }


    /**
     * The  View Scene Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> viewSceneResponse() {
        return send(new ViewSceneResponse());
    }


    /**
     * The  Remove Scene Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> removeSceneResponse() {
        return send(new RemoveSceneResponse());
    }


    /**
     * The  Remove All Scenes Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> removeAllScenesResponse() {
        return send(new RemoveAllScenesResponse());
    }


    /**
     * The  Store Scene Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> storeSceneResponse() {
        return send(new StoreSceneResponse());
    }


    /**
     * The  Get Scene Membership Response
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getSceneMembershipResponse() {
        return send(new GetSceneMembershipResponse());
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

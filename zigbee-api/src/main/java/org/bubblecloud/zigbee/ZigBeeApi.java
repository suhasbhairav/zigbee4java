/**
 * Copyright 2013 Tommi S.E. Laukkanen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.bubblecloud.zigbee;

import org.bubblecloud.zigbee.network.EndpointListener;
import org.bubblecloud.zigbee.network.ZigBeeEndpoint;
import org.bubblecloud.zigbee.network.discovery.ZigBeeDiscoveryManager;
import org.bubblecloud.zigbee.network.impl.NetworkStateSerializer;
import org.bubblecloud.zigbee.network.impl.ZigBeeNetwork;
import org.bubblecloud.zigbee.network.model.DiscoveryMode;
import org.bubblecloud.zigbee.network.model.DriverStatus;
import org.bubblecloud.zigbee.network.model.NetworkMode;
import org.bubblecloud.zigbee.network.packet.ZToolAddress16;
import org.bubblecloud.zigbee.network.packet.zdo.ZDO_MGMT_PERMIT_JOIN_REQ;
import org.bubblecloud.zigbee.network.packet.zdo.ZDO_MGMT_PERMIT_JOIN_RSP;
import org.bubblecloud.zigbee.api.Device;
import org.bubblecloud.zigbee.api.DeviceListener;
import org.bubblecloud.zigbee.network.impl.ApplicationFrameworkLayer;
import org.bubblecloud.zigbee.api.*;
import org.bubblecloud.zigbee.api.device.generic.*;
import org.bubblecloud.zigbee.api.device.hvac.Pump;
import org.bubblecloud.zigbee.api.device.hvac.ThermostatControl;
import org.bubblecloud.zigbee.api.device.hvac.TemperatureSensor;
import org.bubblecloud.zigbee.api.device.lighting.*;
import org.bubblecloud.zigbee.api.device.security_safety.IASAncillaryControlEquipment;
import org.bubblecloud.zigbee.api.device.security_safety.IASControlAndIndicatingEquipment;
import org.bubblecloud.zigbee.api.device.security_safety.IAS_Warning;
import org.bubblecloud.zigbee.api.device.security_safety.IAS_Zone;
import org.bubblecloud.zigbee.api.device.impl.*;
import org.bubblecloud.zigbee.api.DeviceBase;
import org.bubblecloud.zigbee.network.port.ZigBeeNetworkManagerImpl;
import org.bubblecloud.zigbee.network.port.ZigBeePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * ZigBee Application Interface.
 * @author <a href="mailto:tommi.s.e.laukkanen@gmail.com">Tommi S.E. Laukkanen</a>
 * @author <a href="mailto:christopherhattonuk@gmail.com">Chris Hatton</a>
 */
public class ZigBeeApi implements EndpointListener, DeviceListener {
    /**
     * The logger.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ZigBeeApi.class);
    /**
     * The ZigBee network manager.
     */
    private final ZigBeeNetworkManagerImpl networkManager;
    /**
     * The ZigBee discovery manager.
     */
    private final ZigBeeDiscoveryManager discoveryManager;
    /**
     * The ZigBee context.
     */
    private ZigBeeApiContext context;
    /**
     * The zigbee network.
     */
    private ZigBeeNetwork network;
    /**
     * Flag to reset the network on startup
     */
	private boolean resetNetwork = false;

    /**
     * Constructor to configure the port interface.
     *
     * @param port           the ZigBee interface port (reference implementation provided by the zigbee4java-serialPort module)
     * @param pan            the pan
     * @param channel        the channel
     * @param discoveryModes the discovery modes
     * @param resetNetwork   the flag indicating network reset on startup
     */
    public ZigBeeApi(final ZigBeePort port, final int pan, final int channel,
            final EnumSet<DiscoveryMode> discoveryModes, final boolean resetNetwork) {
    	this.resetNetwork = resetNetwork;

        networkManager = new ZigBeeNetworkManagerImpl(port,
                NetworkMode.Coordinator, pan, channel, 2500L);

        discoveryManager = new ZigBeeDiscoveryManager(networkManager, discoveryModes);
    }

    /**
     * Constructor to configure the port interface.
     *
     * @param port           the ZigBee interface port (reference implementation provided by the zigbee4java-serialPort module)
     * @param pan            the pan
     * @param channel        the channel
     * @param discoveryModes the discovery modes
     */
    public ZigBeeApi(final ZigBeePort port, final int pan, final int channel, final EnumSet<DiscoveryMode> discoveryModes) {
        networkManager = new ZigBeeNetworkManagerImpl(port,
                NetworkMode.Coordinator, pan, channel, 2500L);

        discoveryManager = new ZigBeeDiscoveryManager(networkManager, discoveryModes);
    }

    /**
     * Constructor to configure the port interface.
     *
     * @param port           the ZigBee interface port (reference implementation provided by the zigbee4java-serialPort module)
     * @param pan            the pan
     * @param channel        the channel
     * @param resetNetwork   the flag indicating network reset on startup
     */
    public ZigBeeApi(final ZigBeePort port, final int pan, final int channel,
                     final boolean resetNetwork, final EnumSet<DiscoveryMode> discoveryModes) {
    	this.resetNetwork = resetNetwork;

        networkManager = new ZigBeeNetworkManagerImpl(port, NetworkMode.Coordinator, pan, channel, 2500L);
        discoveryManager = new ZigBeeDiscoveryManager(networkManager, discoveryModes);
        network = ApplicationFrameworkLayer.getAFLayer(networkManager).getZigBeeNetwork();

        network.addEndpointListenerListener(this);

        context = new ZigBeeApiContext();

        final ClusterFactory clusterFactory = new ClusterFactoryImpl(context);
        context.setClusterFactory(clusterFactory);

        try {
	        context.getDeviceFactories().put(ColorDimmableLight.DEVICE_ID, new DeviceFactoryImpl(context, ColorDimmableLight.class, ColorDimmableLightDevice.class));
	        context.getDeviceFactories().put(DimmableLight.DEVICE_ID, new DeviceFactoryImpl(context, DimmableLight.class, DimmableLightDevice.class));
	        context.getDeviceFactories().put(IAS_Zone.DEVICE_ID, new DeviceFactoryImpl(context, IAS_Zone.class, IAS_ZoneDevice.class));
	        context.getDeviceFactories().put(IASAncillaryControlEquipment.DEVICE_ID, new DeviceFactoryImpl(context, IASAncillaryControlEquipment.class, IASAncillaryControlEquipmentDevice.class));
	        context.getDeviceFactories().put(IASControlAndIndicatingEquipment.DEVICE_ID, new DeviceFactoryImpl(context, IASControlAndIndicatingEquipment.class, IASControlAndIndicatingEquipmentDevice.class));
	        context.getDeviceFactories().put(LevelControlSwitch.DEVICE_ID, new DeviceFactoryImpl(context, LevelControlSwitch.class, LevelControlSwitchDevice.class));
	        context.getDeviceFactories().put(LightSensor.DEVICE_ID, new DeviceFactoryImpl(context, LightSensor.class, LightSensorDevice.class));
	        context.getDeviceFactories().put(MainsPowerOutlet.DEVICE_ID, new DeviceFactoryImpl(context, MainsPowerOutlet.class, MainsPowerOutletDevice.class));
	        context.getDeviceFactories().put(OccupancySensor.DEVICE_ID, new DeviceFactoryImpl(context, OccupancySensor.class, OccupancySensorDevice.class));
	        context.getDeviceFactories().put(OnOffLight.DEVICE_ID, new DeviceFactoryImpl(context, OnOffLight.class, OnOffLightDevice.class));
	        context.getDeviceFactories().put(OnOffLightSwitch.DEVICE_ID, new DeviceFactoryImpl(context, OnOffLightSwitch.class, OnOffLightSwitchDevice.class));
	        context.getDeviceFactories().put(OnOffOutput.DEVICE_ID, new DeviceFactoryImpl(context, OnOffOutput.class, OnOffOutputDevice.class));
	        context.getDeviceFactories().put(OnOffSwitch.DEVICE_ID, new DeviceFactoryImpl(context, OnOffSwitch.class, OnOffSwitchDevice.class));
	        context.getDeviceFactories().put(OnOffLight.DEVICE_ID, new DeviceFactoryImpl(context, OnOffLight.class, OnOffLightDevice.class));
	        context.getDeviceFactories().put(Pump.DEVICE_ID, new DeviceFactoryImpl(context, Pump.class, PumpDevice.class));
	        context.getDeviceFactories().put(ThermostatControl.DEVICE_ID, new DeviceFactoryImpl(context, ThermostatControl.class, ThermostatControlDevice.class));
	        context.getDeviceFactories().put(TemperatureSensor.DEVICE_ID, new DeviceFactoryImpl(context, TemperatureSensor.class, TemperatureSensorDevice.class));
	        context.getDeviceFactories().put(IAS_Warning.DEVICE_ID, new DeviceFactoryImpl(context, IAS_Warning.class, IAS_Warning_Device.class));
	        context.getDeviceFactories().put(SimpleSensorDevice.DEVICE_ID, new DeviceFactoryImpl(context, SimpleSensor.class, SimpleSensorDevice.class));
	    } catch (Exception ex) {
	        LOGGER.error("Failed to register DeviceFactoryImpl ", ex);
	    }
    }

    /**
     * Starts up network manager, network, context and discovery manager.
     *
     * @return true if startup was success.
     */
    public boolean startup() {
        networkManager.startup();

        return initializeNetwork(this.resetNetwork);
    }

    /**
     * Initialize the zigbee hardware
     */
    public boolean initializeHardware() {
        return networkManager.startup();    	
    }

    /**
     * Initializes the zigbee network.
     * This is only required if the port is opened using initializeHardware
     * @param resetNetwork true to reset the network to the current panid and channel
     * @return
     */
    public boolean initializeNetwork(boolean resetNetwork) {
        context.addDeviceListener(this);
        networkManager.initializeZigBeeNetwork(resetNetwork);

        while (true) {
            if (networkManager.getDriverStatus() == DriverStatus.NETWORK_READY) {
                break;
            }
            if (networkManager.getDriverStatus() == DriverStatus.CLOSED) {
                return false;
            }
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                return false;
            }
        }

        ApplicationFrameworkLayer.getAFLayer(networkManager).createDefaultSendingEndPoint();

        /* disable permit join by default */
        permitJoin(false);

        discoveryManager.startup();

        return true;
    }

    /**
     * Return true if initial networking browsing based on associations is complete.
     *
     * @return true if initial network browsing is complete.
     */
    public boolean isInitialBrowsingComplete() {
        return discoveryManager.isInitialNetworkBrowsingComplete();
    }


    /**
     * Shuts down network manager, network, context and discovery manager.
     */
    public void shutdown() {
        context.removeDeviceListener(this);
        network.removeEndpointListener(this);
        discoveryManager.shutdown();
        networkManager.shutdown();
    }

    /**
     * Changes the permit join state.
     *
     * @param joinState boolean join state, true for enabled indefinitely, false for disabled
     *
     * @return true if success
     */
    public boolean permitJoin(boolean joinState) {
        if (joinState) {
            return sendPermitJoin((byte)0xFF);
        } else {
            return sendPermitJoin((byte)0);
        }
    }

    /**
     * Changes the permit join state with a timeout duration.
     *
     * @param durationSeconds join duration in seconds, from 1-254
     *
     * @return true if success
     */
    public boolean permitJoin(int durationSeconds) {
        if (durationSeconds < 1 || durationSeconds > 254) {
            LOGGER.error("permitJoin durationSeconds out of range: {}", durationSeconds);
            return false;
        }
        return sendPermitJoin((byte)durationSeconds);
    }

    /**
     * Sends the permit join state to routers and coordinators.
     *
     * @param data the data in the permit join request
     *
     * @return true if success
     */
    private boolean sendPermitJoin(byte data) {
        ZDO_MGMT_PERMIT_JOIN_RSP result;
        final byte AddrBroadcast = 0x0F;
        final byte AddrUnicast = 0x02;

        LOGGER.debug("Sending permit join with data: {}", data);

        /* Notify routers of permit join change; don't check result because they're not obligated to respond */
        result = networkManager.sendPermitJoinRequest(new ZDO_MGMT_PERMIT_JOIN_REQ(AddrBroadcast, ZToolAddress16.ZCZR_BROADCAST, data, 1), false);

        /* Notify coordinator of permit join change */
        result = networkManager.sendPermitJoinRequest(new ZDO_MGMT_PERMIT_JOIN_REQ(AddrUnicast, new ZToolAddress16(0, 0), data, 1), true);

        if (result == null || result.Status != 0) {
            LOGGER.error("Error sending ZDO_MGMT_PERMIT_JOIN_REQ");
            return false;
        }

        return true;
    }

    /**
     * Serializes network state.
     * @return the network state
     */
    public String serializeNetworkState() {
        final NetworkStateSerializer networkStateSerializer = new NetworkStateSerializer();
        return networkStateSerializer.serialize(network);
    }

    /**
     * Deserialize network state.
     * @param networkState the network state
     */
    public void deserializeNetworkState(final String networkState) {
        final NetworkStateSerializer networkStateSerializer = new NetworkStateSerializer();
        networkStateSerializer.deserialize(networkManager, network, networkState);
    }


    /**
     * Gets ZigBee network manager.
     *
     * @return the ZigBee network manager.
     */
    public ZigBeeNetworkManagerImpl getZigBeeNetworkManager() {
        return networkManager;
    }

    /**
     * Gets ZigBee discovery manager.
     *
     * @return the ZigBee discovery manager.
     */
    public ZigBeeDiscoveryManager getZigBeeDiscoveryManager() {
        return discoveryManager;
    }

    /**
     * Gets ZigBee proxy context.
     *
     * @return the ZigBee proxy context.
     */
    public ZigBeeApiContext getZigBeeApiContext() {
        return context;
    }

    /**
     * Gets ZigBee network.
     *
     * @return the ZigBee network.
     */
    public ZigBeeNetwork getZigBeeNetwork() {
        return network;
    }

    public Device getDevice(String endPointId) {
        return context.getDevice(endPointId);
    }

    public List<Device> getDevices() {
        return context.getDevices();
    }

    public void addDeviceListener(DeviceListener deviceListener) {
        context.addDeviceListener(deviceListener);
    }

    public void removeDeviceListener(DeviceListener deviceListener) {
        context.removeDeviceListener(deviceListener);
    }

    @Override
    public void endpointAdded(final ZigBeeEndpoint endpoint) {
        final DeviceFactory factory = context.getBestDeviceProxyFactory(endpoint);
        if (factory == null) { // pending services
            LOGGER.warn("No proxy for ZigBee device type {} found with endpoint {}.",
            		endpoint.getDeviceTypeId(), endpoint.getEndpointId());
            return;
        }

        final DeviceBase haDevice = factory.getInstance(endpoint);
        context.addDevice(haDevice);
        LOGGER.trace("Endpoint added: " + endpoint.getEndpointId());
    }

    @Override
    public void endpointUpdated(final ZigBeeEndpoint endpoint) {
        LOGGER.trace("Endpoint updated: " + endpoint.getEndpointId());
        final Device device = context.getDevice(endpoint.getEndpointId());
        if (device != null) {
            context.updateDevice(device);
        }
    }

    @Override
    public void endpointRemoved(final ZigBeeEndpoint endpoint) {
        LOGGER.trace("Endpoint removed: " + endpoint.getEndpointId());
        final Device device = context.getDevice(endpoint.getEndpointId());
        if (device != null) {
            context.removeDevice(device);
        }
    }

    @Override
    public void deviceAdded(final Device device) {
        LOGGER.debug(device.getClass().getSimpleName() +
                " added: " + device.getEndpoint().getEndpointId());
    }

    @Override
    public void deviceUpdated(final Device device) {
        LOGGER.trace(device.getClass().getSimpleName() +
                " updated: " + device.getEndpoint().getEndpointId());
    }

    @Override
    public void deviceRemoved(final Device device) {
        LOGGER.debug(device.getClass().getSimpleName() +
                " removed: " + device.getEndpoint().getEndpointId());
    }
}

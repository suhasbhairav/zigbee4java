/*
   Copyright 2012-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies
   of the Italian National Research Council


   See the NOTICE file distributed with this work for additional
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.proxy.device.api.lighting;

import org.bubblecloud.zigbee.proxy.DeviceProxy;
import org.bubblecloud.zigbee.proxy.ProxyConstants;
import org.bubblecloud.zigbee.proxy.cluster.glue.general.Groups;
import org.bubblecloud.zigbee.proxy.cluster.glue.measureament_sensing.IlluminanceMeasurement;
import org.bubblecloud.zigbee.util.ArraysUtil;

/**
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 *
 */
public interface LightSensor extends DeviceProxy {

    public static final int DEVICE_ID = 0x0106;
    public static final String NAME = "Light Sensor";
    public static final int[] MANDATORY = ArraysUtil.append(DeviceProxy.MANDATORY, new int[]{
            ProxyConstants.ILLUMINANCE_MEASUREMENT
    });
    public static final int[] OPTIONAL = ArraysUtil.append(DeviceProxy.OPTIONAL, new int[]{
            ProxyConstants.GROUPS
    });
    public static final int[] STANDARD = ArraysUtil.append(MANDATORY, OPTIONAL);
    public static final int[] CUSTOM = {};

    public IlluminanceMeasurement getIlluminanceMeasurement();

    public Groups getGroups();
}
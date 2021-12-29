/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ACTUATOR_OUTPUT_STATUS PACKING
package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;

/**
 * The raw values of the actuator outputs (e.g. on Pixhawk, from MAIN, AUX ports). This message supersedes SERVO_OUTPUT_RAW.
 */
public class msg_actuator_output_status extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_ACTUATOR_OUTPUT_STATUS = 375;
    public static final int MAVLINK_MSG_LENGTH = 140;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ACTUATOR_OUTPUT_STATUS;


    /**
     * Timestamp (since system boot).
     */
    public long time_usec;

    /**
     * Active outputs
     */
    public long active;

    /**
     * Servo / motor output array values. Zero values indicate unused channels.
     */
    public float actuator[] = new float[32];


    /**
     * Generates the payload for a mavlink message for a message of this type
     *
     * @return
     */
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_ACTUATOR_OUTPUT_STATUS;

        packet.payload.putUnsignedLong(time_usec);

        packet.payload.putUnsignedInt(active);


        for (int i = 0; i < actuator.length; i++) {
            packet.payload.putFloat(actuator[i]);
        }


        return packet;
    }

    /**
     * Decode a actuator_output_status message into this class fields
     *
     * @param payload The message to decode
     */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_usec = payload.getUnsignedLong();

        this.active = payload.getUnsignedInt();


        for (int i = 0; i < this.actuator.length; i++) {
            this.actuator[i] = payload.getFloat();
        }


    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_actuator_output_status() {
        msgid = MAVLINK_MSG_ID_ACTUATOR_OUTPUT_STATUS;
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     */
    public msg_actuator_output_status(MAVLinkPacket mavLinkPacket) {
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_ACTUATOR_OUTPUT_STATUS;
        unpack(mavLinkPacket.payload);
    }


    /**
     * Returns a string with the MSG name and data
     */
    public String toString() {
        return "MAVLINK_MSG_ID_ACTUATOR_OUTPUT_STATUS - sysid:" + sysid + " compid:" + compid + " time_usec:" + time_usec + " active:" + active + " actuator:" + actuator + "";
    }
}
        
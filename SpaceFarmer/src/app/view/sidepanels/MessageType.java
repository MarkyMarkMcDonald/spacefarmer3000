/*This file holds the enum MessageType, which 
 * represents the different qualities of messages.
 */
package app.view.sidepanels;

/**
 * Bad = something happened, but it wasn't beneficial to the player Error =
 * nothing happened because of user fault
 * 
 * User: mark.mcdonald Date: 11/9/12 Time: 1:21 PM To change this template use
 * File | Settings | File Templates.
 */
public enum MessageType {
	GOOD, BAD, ERROR, CRITICAL
}
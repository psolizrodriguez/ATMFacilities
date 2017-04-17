package com.facilities.client.bridge;

/** "Abstraction" */
public abstract class Message {
	protected FormatMessage formatMessage;

	protected Message(final FormatMessage formatMessage) {
		this.formatMessage = formatMessage;
	}

	public abstract void format();
}

package com.alecarballo.exception;

import java.util.Date;

public class ExceptionResponse {

	public ExceptionResponse(Date timestamp, String message, String detalle) {
		this.timestamp = timestamp;
		this.message = message;
		this.detalle = detalle;
	}

	private Date timestamp;
	private String message;
	private String detalle;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}

package com.booking.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class BookingDetailsVO {

	private Long bookingId;

	private String bookedBy;

	private Date bookedAt;

}

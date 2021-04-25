/**
 * 
 */
package com.booking.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Alexandre Fernandes
 *
 */

@Entity
@Table(name = "BT_PHONE_BOOKING_DETAILS")

public class BookingDetails {

	@Id
	@GeneratedValue( strategy= GenerationType.AUTO ) 	
	@Column(name = "BOOKING_ID")
	private Long bookingId;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PHONE_ID")
	private PhoneMasterDetails phoneMaster;

	@Column(name = "LAST_BOOKED_BY")
	private String bookedBy;
	
	@Column(name = "LAST_BOOKED_AT")
	private Date bookedAt;
	


}

/**
 * 
 */
package com.booking.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alexandre Fernandes
 *
 */

@Entity
@Table(name = "BT_PHONE_MASTER_DETAILS")
@Setter
@Getter
public class PhoneMasterDetails {

	@Id
	@Column(name = "PHONE_ID")
	private Long phoneId;
	
	@Column(name = "PHONE_NAME")
	private String phoneName;
	
	@Column(name = "IS_AVAILABLE")
	private String isAvailable;
	
	
	@OneToMany(mappedBy = "phoneMaster",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<BookingDetails> bookingDetails = new ArrayList<>();
	
	
	
}

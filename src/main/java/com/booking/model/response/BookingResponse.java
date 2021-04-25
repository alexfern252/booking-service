/**
 * 
 */
package com.booking.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexandre Fernandes
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

	private Long phoneId;
	private String phoneName;
	private String isAvailable;

}

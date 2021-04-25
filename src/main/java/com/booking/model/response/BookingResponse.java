/**
 * 
 */
package com.booking.model.response;

import java.util.ArrayList;
import java.util.List;

import com.booking.model.vo.BookingDetailsVO;

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
	
	private List<BookingDetailsVO> bookingDetails = new ArrayList<>();
	
	// fonoapi output object
	
	private FonoAPIResponse fonoApiResponse;

}

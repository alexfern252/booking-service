/**
 * 
 */
package com.booking.model.response;

import java.util.List;

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
public class MasterDataResponse {

	List<BookingResponse> phoneList;
	
	
}

/**
 * 
 */
package com.booking.service;

import com.booking.exception.AppException;
import com.booking.model.response.MasterDataResponse;

/**
 * @author Alexandre Fernandes
 *
 */
public interface BookingService {

	MasterDataResponse getAllPhones() throws AppException;
}

/**
 * 
 */
package com.booking.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.exception.AppException;
import com.booking.model.entity.PhoneMasterDetails;
import com.booking.model.response.MasterDataResponse;
import com.booking.repository.BookingRepository;
import com.booking.service.BookingService;

/**
 * @author Alexandre Fernandes
 *
 */
@Service
@Transactional(Transactional.TxType.SUPPORTS)
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;


	@Override
	public MasterDataResponse getAllPhones() throws AppException {
		List<PhoneMasterDetails> phoneList = bookingRepository.findAllByBookingUsers();
		
		return new MasterDataResponse(phoneList);
	}

}

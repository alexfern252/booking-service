/**
 * 
 */
package com.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.exception.AppException;
import com.booking.model.entity.BookingDetails;
import com.booking.model.entity.PhoneMasterDetails;
import com.booking.model.response.BookingResponse;
import com.booking.model.response.MasterDataResponse;
import com.booking.model.vo.BookingDetailsVO;
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
		BookingResponse res = null;
		List<BookingDetailsVO> voList = null;
		BookingDetailsVO vo = null;
		List<BookingResponse> respList = new ArrayList<>();

		// copy source to dest object
		for (PhoneMasterDetails phone : phoneList) {
			res = new BookingResponse();
			voList = new ArrayList<>();
			res.setPhoneId(phone.getPhoneId());
			res.setPhoneName(phone.getPhoneName());
			res.setIsAvailable(phone.getIsAvailable());
				for(BookingDetails det : phone.getBookingDetails()) {
					vo = new BookingDetailsVO();
					vo.setBookingId(det.getBookingId());
					vo.setBookedAt(det.getBookedAt());
					vo.setBookedBy(det.getBookedBy());
					voList.add(vo);
				}
			res.setBookingDetails(voList);
			respList.add(res);

		}

		return new MasterDataResponse(respList);
	}

}

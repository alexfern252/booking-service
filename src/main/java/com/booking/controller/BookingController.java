/**
 * 
 */
package com.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.exception.AppException;
import com.booking.model.response.MasterDataResponse;
import com.booking.service.BookingService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Alexandre Fernandes
 *
 */
@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookingController { 

	@Autowired
	private BookingService bookingService;

	@GetMapping(path = "/book-phones")
	@ApiOperation(value = "This service is used to list all the mobile phones to be booked/returned")
	public ResponseEntity<MasterDataResponse> getListPhones() throws AppException {
		return new ResponseEntity<MasterDataResponse>(bookingService.getAllPhones(), HttpStatus.OK); // 200OK // OK
	}

}

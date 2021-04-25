/**
 * 
 */
package com.booking.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandre Fernandes
 *
 */
@RestController
public class HealthController {

	/**
	 * Ping me.
	 *
	 * @return the string
	 */
	@GetMapping(path = "/healthz", produces = MediaType.TEXT_PLAIN_VALUE)
	public String health() {
		return "UP";
	}
}

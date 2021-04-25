package com.booking.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FonoAPIResponse {
	
	private String technology;
	private String twoGBands;
	private String threeGBands;
	private String fourGBands;

}

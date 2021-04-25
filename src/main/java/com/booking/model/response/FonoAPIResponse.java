package com.booking.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FonoAPIResponse {
	
	@JsonProperty(value = "technology")
	private String technology;
	@JsonProperty(value = "_2g_bands")
	private String twoGBands;
	@JsonProperty(value = "_3g_bands")
	private String threeGBands;
	@JsonProperty(value = "_4g_bands")
	private String fourGBands;

}

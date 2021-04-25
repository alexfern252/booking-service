package com.booking.restTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booking.exception.AppException;
import com.booking.model.response.FonoAPIResponse;

@Service
public class APICall {

	@Value("${fonoapi.url}")
	private String url;

	private RestTemplate restTemplate;

	public APICall(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public FonoAPIResponse callFonoAPI(String phoneName) throws AppException {

		ResponseEntity<FonoAPIResponse> responseEntity = null;
		FonoAPIResponse resp = null;
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Object> entity = new HttpEntity<>(null, headers);
			responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, FonoAPIResponse.class);

			resp = responseEntity.getBody();

		} catch (Exception e) {
			throw new AppException("Error Calling FONO API ", e);
		}

		return resp;

	}

}

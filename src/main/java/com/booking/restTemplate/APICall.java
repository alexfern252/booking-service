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

	@Value("${fonoapi.baseurl}")
	private String baseurl;

	@Value("${fonoapi.getdevice}")
	private String deviceendpoint;

	@Value("${fonoapi.token.url}")
	private String tokenUrl;

	private RestTemplate restTemplate;

	public APICall(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public FonoAPIResponse callFonoAPI(String phoneName) throws AppException {

		ResponseEntity<FonoAPIResponse> responseEntity = null;
		FonoAPIResponse resp = null;
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.add("TOKEN", getFonoApiToken());
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Object> entity = new HttpEntity<>(null, headers);
			StringBuilder url = new StringBuilder();
			url.append(baseurl).append(deviceendpoint);
			responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, FonoAPIResponse.class);

			resp = responseEntity.getBody();

		} catch (Exception e) {
			throw new AppException("Error Calling FONO API ", e);
		}

		return resp;

	}

	private String getFonoApiToken() throws AppException {
		ResponseEntity<String> responseEntity = null;
		String resp = null;
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Object> entity = new HttpEntity<>(null, headers);
			StringBuilder tokenUrl = new StringBuilder();
			tokenUrl.append(baseurl).append(tokenUrl);
			responseEntity = restTemplate.exchange(tokenUrl.toString(), HttpMethod.GET, entity, String.class);

			resp = responseEntity.getBody();

		} catch (Exception e) {
			throw new AppException("Error Calling Token API ", e);
		}

		return resp;

	}

}

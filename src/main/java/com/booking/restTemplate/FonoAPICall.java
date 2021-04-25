package com.booking.restTemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.booking.exception.AppException;
import com.booking.model.response.FonoAPIResponse;

@Service
public class FonoAPICall {

	@Value("${fonoapi.baseurl}")
	private String baseurl;

	@Value("${fonoapi.getdevice}")
	private String deviceendpoint;

	@Value("${fonoapi.token.url}")
	private String tokenUrl;

	private RestTemplate restTemplate;

	public FonoAPICall(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public FonoAPIResponse callFonoAPI(String deviceName) throws AppException {

		ResponseEntity<FonoAPIResponse> responseEntity = null;
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Object> entity = new HttpEntity<>(null, headers);
			StringBuilder url = new StringBuilder();
			url.append(baseurl).append(deviceendpoint).append(getFonoApiToken()).append("&device=").append(deviceName);
			responseEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, entity, FonoAPIResponse.class);
			final HttpStatus statusCode = responseEntity.getStatusCode();
			if (HttpStatus.OK.equals(statusCode) && responseEntity.getBody() != null) {
				return responseEntity.getBody();
			} else {
				return null;
			}

		} catch (Exception e) {
			throw new AppException("Error Calling FONO API ", e);
		}

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

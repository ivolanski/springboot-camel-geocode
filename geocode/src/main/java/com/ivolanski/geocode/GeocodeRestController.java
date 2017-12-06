package com.ivolanski.geocode;

import org.apache.camel.EndpointInject;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class GeocodeRestController {
	@EndpointInject
	private FluentProducerTemplate producer;

	@RequestMapping(value = "geocode", method = RequestMethod.GET)
	public @ResponseBody String getitem(@RequestParam("address") String address) {
		producer.setDefaultEndpointUri("geocoder:address:" + address);
		address = producer.request(String.class);
		return address;
	}

}

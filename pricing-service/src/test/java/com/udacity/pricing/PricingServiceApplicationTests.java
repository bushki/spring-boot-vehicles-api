package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PricingServiceApplicationTests {

	@Autowired
	PriceRepository priceRepository;

	@Test
	public void getPriceForVehicle1() throws Exception {

		Optional<Price> price  = priceRepository.findById(new Long(1));
		assertTrue(price.isPresent());
		assertTrue(price.get().getPrice() != null);
		assertTrue(price.get().getCurrency() != null);
		assertTrue(price.get().getVehicleId() != null);
	}
}

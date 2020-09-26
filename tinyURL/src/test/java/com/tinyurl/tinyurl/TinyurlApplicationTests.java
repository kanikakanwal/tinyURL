package com.tinyurl.tinyurl;

import com.tinyurl.tinyurl.tinyurl.exception.ClientNotExistException;
import com.tinyurl.tinyurl.tinyurl.impl.ClientServiceImpl;
import com.tinyurl.tinyurl.tinyurl.impl.UrlShortnerImpl;
import com.tinyurl.tinyurl.tinyurl.service.ClientService;
import com.tinyurl.tinyurl.tinyurl.service.UrlShortnerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
class TinyurlApplicationTests {

	@Autowired
	ClientService clientService;
	@Autowired
	UrlShortnerService urlShortnerService;
	@Test
	void contextLoads() {
	}

	@Test
	public void testShort() throws ClientNotExistException {
		clientService.addClient("12");
		String a1 = urlShortnerService.getUrlShortner("google.com", "12");
		String a2 = urlShortnerService.getUrlShortner("google.com", "12");
		Assert.assertEquals(a1, a2);
	}

	@Test
	public void testShortMismatch() throws ClientNotExistException {
		clientService.addClient("12");
		String a1 = urlShortnerService.getUrlShortner("google.com", "12");
		String a2 = urlShortnerService.getUrlShortner("facebook.com", "12");
		Assert.assertNotEquals(a1, a2);
	}

	@Test
	public void testShortMismatchClientNotAdded() throws ClientNotExistException {
		try {
			String a1 = urlShortnerService.getUrlShortner("google.com", "13");
		} catch (ClientNotExistException e) {
			Assert.assertEquals("true", "true");
			return;
		}
		Assert.assertEquals("false", "true");

	}

}
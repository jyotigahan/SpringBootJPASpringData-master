package com.jyotionjava.sdjpa.mock.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jyotionjava.sdjpa.controller.BookingController;
import com.jyotionjava.sdjpa.mock.TestUtils;
import com.jyotionjava.sdjpa.models.Booking;
import com.jyotionjava.sdjpa.services.BookingService;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class, secure = false)
public class BookingControllerTest {

	private static final Logger logger = LogManager.getLogger(BookingControllerTest.class);

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingService bookingService;
 
	// Unit test positive scenario
	@Test
	public void testGetBooking() throws Exception {
		Booking mockBooking = new Booking(26l, "Jyoti", "Pune", "USA", parseDate("2017-10-17"));
		Mockito.when(bookingService.getById(Mockito.anyLong())).thenReturn(mockBooking);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/booking/read?bookingId=27");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		logger.info("==> testGetBooking() result.getResponse().getStatus() ---> " + result.getResponse().getStatus());
		logger.info("==> testGetBooking() result.getResponse().getContentAsString() ---> " + result.getResponse().getContentAsString());
		String expected = "{\"bookingId\":26,\"psngrName\":\"Jyoti\",\"departure\":\"Pune\",\"destination\":\"USA\",\"travelDate\":1508212800000}";
		verify(bookingService).getById(any(Long.class));
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
		assertNotNull(result);
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	// Unit test negative scenario
	@Test
	public void testGetBookingNotExist() throws Exception {

		// Mockito.when(bookingService.getById(Mockito.anyLong())).thenReturn(mockBooking);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/booking/read?bookingId=27");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		logger.info("==> testGetBookingNotExist() result.getResponse().getStatus() ---> " + result.getResponse().getStatus());
		logger.info("==> testGetBookingNotExist() result.getResponse().getContentAsString() ---> " + result.getResponse().getContentAsString());

		assertEquals(HttpStatus.NOT_FOUND.value(), result.getResponse().getStatus());
		Booking resultBooking = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Booking.class);
		logger.info(" resultBooking ---> " + resultBooking);
		assertNull(resultBooking.getBookingId());

	}

	@Test
	public void testAddBooking() throws Exception {

		Booking mockBooking = new Booking(28l, "Jyoti", "Pune", "USA");
		String exampleBookingJson = "{\"bookingId\":28,\"psngrName\":\"Jyoti\",\"departure\":\"Pune\",\"destination\":\"USA\",\"travelDate\":1508212800000}";
		Mockito.when(bookingService.saveOrUpdate(Mockito.any(Booking.class))).thenReturn(mockBooking);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/booking/create")
				.accept(MediaType.APPLICATION_JSON).content(exampleBookingJson).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		logger.info(" ==> testAddBooking() result.getResponse().getStatus() ---> " + result.getResponse().getStatus());
		logger.info(" ==> testAddBooking() result.getResponse().getContentAsString() ---> " + result.getResponse().getContentAsString());
		// verify that service method was called once
		verify(bookingService).saveOrUpdate(any(Booking.class));
		Booking resultBooking = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Booking.class);
		logger.info(" esultBooking.getBookingId().longValue() ---> " + resultBooking.getBookingId().longValue());

		assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
		assertNotNull(resultBooking.getBookingId());
		assertEquals(28l, resultBooking.getBookingId().longValue());

	}

	@Test
	public void testUpdateBooking() throws Exception {

		Booking mockBooking = new Booking(21l, "Jyoti1", "Pune", "USA", parseDate("2017-10-17"));
		Mockito.when(bookingService.getById(Mockito.anyLong())).thenReturn(mockBooking);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/booking/update/21?psngrName=Jyoti1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		logger.info("==> testUpdateBooking() result.getResponse().getStatus() ---> " + result.getResponse().getStatus());
		logger.info("==> testUpdateBooking() result.getResponse().getContentAsString() ---> " + result.getResponse().getContentAsString());
		// verify that service method was called once
		verify(bookingService).getById(any(Long.class));
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

	}
	
	@Test
	public void testDeleteBooking() throws Exception {

		Booking mockBooking = new Booking(21l, "Jyoti1", "Pune", "USA", parseDate("2017-10-17"));
		Mockito.when(bookingService.getById(Mockito.anyLong())).thenReturn(mockBooking);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/booking/delete/7");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		logger.info(" ==> testDeleteBooking() result.getResponse().getStatus() ---> " + result.getResponse().getStatus());
		logger.info(" ==>  testDeleteBooking() result.getResponse().getContentAsString() ---> " + result.getResponse().getContentAsString());
		// verify that service method was called once
		verify(bookingService).getById(any(Long.class));
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());

	}
	 
	
	@Test
	public void testGetAllBooking() throws Exception {
		List<Booking> mockBookingList = new ArrayList<Booking>();
		Booking mockBooking1 = new Booking(26l, "Jyoti", "Pune", "USA", parseDate("2017-10-17"));
		Booking mockBooking2 = new Booking(27l, "Jyoti", "Pune", "USA", parseDate("2017-10-17"));
		mockBookingList.add(mockBooking1);
		mockBookingList.add(mockBooking2);
		Mockito.when(bookingService.listAll()).thenReturn(mockBookingList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/booking/readall");
		//perform an expectation
		mockMvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));
		 
	}
	
	

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}

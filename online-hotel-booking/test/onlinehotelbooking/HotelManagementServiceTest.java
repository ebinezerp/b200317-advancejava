package onlinehotelbooking;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import onlinehotelbooking.dto.HotelManagement;
import onlinehotelbooking.services.HotelMangmentService;

class HotelManagementServiceTest {

	private HotelMangmentService hotelMangmentService;
	private HotelManagement hotelManagement;

	@BeforeEach
	public void setUp() {
		hotelMangmentService = new HotelMangmentService();
		hotelManagement = new HotelManagement();
		hotelManagement.setFullname("bhaskar");
		hotelManagement.setEmail("bhaskar@gmail.com");
		hotelManagement.setMobile("8908909090");
		hotelManagement.setUsername("bhaskar");
		hotelManagement.setPassword("12345");
	}

	@AfterEach
	public void destory() {
		if (hotelManagement != null && hotelManagement.getId() != null) {
			if (hotelMangmentService.getHotelManagement(hotelManagement.getId()) != null) {
				hotelMangmentService.delete(hotelManagement);
			}
		}
	}

	@Test
	public void testSave1() {
		boolean result = hotelMangmentService.save(hotelManagement);
		assertTrue(result);
	}

}

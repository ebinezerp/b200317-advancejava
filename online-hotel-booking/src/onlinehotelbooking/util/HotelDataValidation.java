package onlinehotelbooking.util;

import java.util.HashMap;
import java.util.Map;

import onlinehotelbooking.dto.Hotel;

public class HotelDataValidation {

	public Map<String, String> validate(Hotel hotel) {

		Map<String, String> errorMessages = new HashMap<String, String>();

		if (hotel.getHotelName().isEmpty()) {
			errorMessages.put("hotelNameError", "Enter Hotel Name");
		}

		if (hotel.getGstNo().isEmpty()) {
			errorMessages.put("gstError", "Enter GST No");
		}

		if (hotel.getRating() <= 0 || hotel.getRating() > 5) {
			errorMessages.put("ratingError", "Rating should be greater than zero and lessthan or equal to 5");
		}

		if (hotel.getRoomTypes().isEmpty()) {
			errorMessages.put("roomTypeError", "Atleast select one room type");
		}

		if (hotel.getFacilities().isEmpty()) {
			errorMessages.put("facilitiesError", "Atleast select one facility");
		}

		return errorMessages;

	}

}

package onlinehotelbooking.util;

import java.util.HashMap;
import java.util.Map;

import onlinehotelbooking.dto.HotelManagement;

public class HotelManagmentDataValidation {

	public Map<String, String> validate(HotelManagement hotelManagement) {

		Map<String, String> errorMessages = new HashMap<String, String>();

		if (hotelManagement.getFullname().isEmpty()) {
			errorMessages.put("fullnameError", "Enter fullname");
		}

		if (hotelManagement.getEmail().isEmpty()) {
			errorMessages.put("emailError", "Enter Email");
		}

		if (hotelManagement.getMobile().isEmpty()) {
			errorMessages.put("mobileError", "Enter Mobile Number");
		}

		if (hotelManagement.getUsername().isEmpty()) {
			errorMessages.put("usernameError", "Enter Username");
		}

		if (hotelManagement.getPassword().isEmpty()) {
			errorMessages.put("passwordError", "Enter Password");
		}

		return errorMessages;

	}

}

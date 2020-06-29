package onlinehotelbooking.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onlinehotelbooking.dto.Hotel;
import onlinehotelbooking.exception.NoFacilitiesSelectedException;
import onlinehotelbooking.exception.NoRoomSelectedException;
import onlinehotelbooking.util.HotelDataValidation;

@WebServlet("/addhotel")
public class AddHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String hotelName = request.getParameter("hotelname");
			String gstNo = request.getParameter("gst");
			String rating = request.getParameter("rating");
			String[] roomTypes = request.getParameterValues("roomtype");
			String[] facilities = request.getParameterValues("facilities");

			if (roomTypes == null) {
				throw new NoRoomSelectedException();
			}

			if (facilities == null) {
				throw new NoFacilitiesSelectedException();
			}

			Hotel hotel = new Hotel();
			hotel.setHotelName(hotelName);
			hotel.setGstNo(gstNo);
			hotel.setRating(Float.parseFloat(rating));
			hotel.setRoomTypes(Arrays.asList(roomTypes));
			hotel.setFacilities(Arrays.asList(facilities));

			Map<String, String> errorMessages = new HotelDataValidation().validate(hotel);

			if (!errorMessages.isEmpty()) {
				request.setAttribute("errorMessages", errorMessages);
				request.getRequestDispatcher("addhotel.jsp").forward(request, response);
			} else {
				response.getWriter().print("validation is successful");
			}
		} catch (NoRoomSelectedException e) {
			request.setAttribute("roomTypeError", "Atleast select one room");
			e.printStackTrace();
			request.getRequestDispatcher("addhotel.jsp").forward(request, response);
		} catch (NoFacilitiesSelectedException e) {
			request.setAttribute("facilitesError", "Atleast select one facility");
			e.printStackTrace();
			request.getRequestDispatcher("addhotel.jsp").forward(request, response);
		}

	}

}

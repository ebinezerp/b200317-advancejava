package onlinehotelbooking.dto;

import java.util.List;

public class Hotel {

	private Integer id;
	private String hotelName;
	private String gstNo;
	private Float rating;
	private List<String> roomTypes;
	private List<String> facilities;

	public Hotel() {
		super();
	}

	public Hotel(Integer id, String hotelName, String gstNo, Float rating, List<String> roomTypes,
			List<String> facilities) {
		super();
		this.id = id;
		this.hotelName = hotelName;
		this.gstNo = gstNo;
		this.rating = rating;
		this.roomTypes = roomTypes;
		this.facilities = facilities;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public List<String> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(List<String> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public List<String> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<String> facilities) {
		this.facilities = facilities;
	}


}

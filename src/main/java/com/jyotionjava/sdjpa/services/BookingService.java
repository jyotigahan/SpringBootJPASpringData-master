package com.jyotionjava.sdjpa.services;

import java.util.List;

import com.jyotionjava.sdjpa.models.Booking;

public interface BookingService {

	List<Booking> listAll();

	Booking getById(Long id);

	Booking saveOrUpdate(Booking booking);

	void delete(Long id);

}

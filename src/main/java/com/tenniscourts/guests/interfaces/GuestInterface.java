package com.tenniscourts.guests.interfaces;

import com.tenniscourts.guests.CreateGuestRequestDTO;
import com.tenniscourts.guests.GuestDTO;

import java.util.List;

public interface GuestInterface {

    GuestDTO createGuest(CreateGuestRequestDTO createGuestRequestDTO);

    GuestDTO updateGuest(CreateGuestRequestDTO createGuestRequestDTO, Long guestId);

    void deleteGuest(Long id);

    GuestDTO findGuestById(Long guestId);

    GuestDTO findGuestByName(String guestName);

    List<GuestDTO> getAllGuests();
}

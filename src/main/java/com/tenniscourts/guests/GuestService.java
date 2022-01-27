package com.tenniscourts.guests;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.guests.interfaces.GuestInterface;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GuestService implements GuestInterface {

    private static final Logger LOGGER = LogManager.getLogger(GuestService.class);

    private final GuestRepository guestRepository;

    private final GuestMapper guestMapper;

    @Override
    public GuestDTO createGuest(CreateGuestRequestDTO createGuestRequestDTO) {
        LOGGER.info("Creating guest with name {}", createGuestRequestDTO.getName());
        return guestMapper.map(guestRepository.save(guestMapper.map(createGuestRequestDTO)));
    }

    @Override
    public GuestDTO updateGuest(CreateGuestRequestDTO createGuestRequestDTO, Long guestId) {
        Guest guest = guestMapper.map(findGuestById(guestId));
        LOGGER.info("Updating guest with name {} to name {}", guest.getName(), createGuestRequestDTO.getName());
        guest.setName(createGuestRequestDTO.getName());
        return guestMapper.map(guestRepository.saveAndFlush(guest));
    }

    @Override
    public void deleteGuest(Long id) {
        guestRepository.delete(guestMapper.map(findGuestById(id)));
    }

    @Override
    public GuestDTO findGuestById(Long guestId) {
        return guestRepository.findById(guestId).map(guestMapper::map).orElseThrow(() -> new EntityNotFoundException("Guest not found."));
    }

    @Override
    public GuestDTO findGuestByName(String guestName) {
        return guestRepository.findByName(guestName).map(guestMapper::map).orElseThrow(() -> new EntityNotFoundException("Guest not found."));
    }

    @Override
    public List<GuestDTO> getAllGuests() {
        return guestMapper.map(guestRepository.findAll());
    }
}

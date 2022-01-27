package com.tenniscourts.guests;

import com.tenniscourts.config.BaseRestController;
import com.tenniscourts.guests.interfaces.GuestInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(description = "Guest management")
public class GuestController extends BaseRestController {

    private final GuestInterface guestInterface;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest successfully created")
    })
    @PostMapping(path = "/create-guest")
    public ResponseEntity<Void> createGuest(@ApiParam("Guest request payload")
                                        @RequestBody CreateGuestRequestDTO createGuestRequestDTO){
        return ResponseEntity.created(locationByEntity(guestInterface.createGuest(createGuestRequestDTO).getId())).build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest successfully updated")
    })
    @PutMapping(path = "/update-guest")
    public ResponseEntity<Void> updateGuest(@ApiParam("Guest request payload")
                                            @RequestBody CreateGuestRequestDTO createGuestRequestDTO,
                                            @ApiParam("Guest Id") @RequestParam Long guestId){
        return ResponseEntity.created(locationByEntity(guestInterface.updateGuest(createGuestRequestDTO, guestId).getId())).build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest successfully deleted")
    })
    @DeleteMapping(path = "/delete-guest")
    public ResponseEntity<Void> deleteGuest(@ApiParam("Guest Id")
                                            @RequestParam Long guestId){
        guestInterface.deleteGuest(guestId);
        return ResponseEntity.ok().build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest was found")
    })
    @GetMapping(path = "/find-guest-by-id")
    public ResponseEntity<GuestDTO> findGuestById(@ApiParam("Guest Id")
                                            @RequestParam Long guestId){

        return ResponseEntity.ok(guestInterface.findGuestById(guestId));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guest was found")
    })
    @GetMapping(path = "/find-guest-by-name")
    public ResponseEntity<GuestDTO> findGuestByName(@ApiParam("Guest Name")
                                                  @RequestParam String name){

        return ResponseEntity.ok(guestInterface.findGuestByName(name));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Guests were found")
    })
    @GetMapping(path = "/get-all-guests")
    public ResponseEntity<List<GuestDTO>> getAllGuests(){

        return ResponseEntity.ok(guestInterface.getAllGuests());
    }
}

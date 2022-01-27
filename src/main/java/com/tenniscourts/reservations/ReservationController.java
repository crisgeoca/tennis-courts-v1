package com.tenniscourts.reservations;

import com.tenniscourts.config.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Api(description = "Reservation management")
public class ReservationController extends BaseRestController {

    private final ReservationService reservationService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reservation successfully created")
    })
    @PostMapping(path = "/book-reservation")
    public ResponseEntity<Void> bookReservation(@ApiParam("Reservation request payload")
                                                    @RequestBody CreateReservationRequestDTO createReservationRequestDTO) {
        return ResponseEntity.created(locationByEntity(reservationService.bookReservation(createReservationRequestDTO).getId())).build();
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reservation was found")
    })
    @GetMapping(path = "/find-reservation")
    public ResponseEntity<ReservationDTO> findReservation(@ApiParam("Reservation Id")
                                                              @RequestParam Long reservationId) {
        return ResponseEntity.ok(reservationService.findReservation(reservationId));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reservation successfully canceled")
    })
    @PutMapping(path = "/cancel-reservation")
    public ResponseEntity<ReservationDTO> cancelReservation(@ApiParam("Reservation Id")
                                                                @RequestParam Long reservationId) {
        return ResponseEntity.ok(reservationService.cancelReservation(reservationId));
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Reservation successfully rescheduled")
    })
    @PutMapping(path = "/reschedule-reservation")
    public ResponseEntity<ReservationDTO> rescheduleReservation(@ApiParam("Reservation Id")
                                                                    @RequestParam Long reservationId,
                                                                @ApiParam("Schedule Id") @RequestParam Long scheduleId) {
        return ResponseEntity.ok(reservationService.rescheduleReservation(reservationId, scheduleId));
    }
}

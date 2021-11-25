import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OwnerRating } from '../model/owner-rating';
import { TripBooking } from '../model/trip-booking';
import { LoginAuthService } from '../service/login-auth.service.ts.service';
import { TripBookingService } from '../service/trip-booking.service';

@Component({
  selector: 'app-book-ride',
  templateUrl: './book-ride.component.html',
  styleUrls: ['./book-ride.component.css']
})
export class BookRideComponent implements OnInit {
  trip: any;
  bookingTrip: TripBooking = {
    id: 0,
    seatsBooked: 0,
    trip: {
      id: 10,
      origin: "",
      destination: "",
      departureTime: "",
      price: 0,
      date: "",
      owner: {
        id: 0,
        name: "",
        address: "",
        mobile: "",
        licenceNumber: "",
        licenceUrl: "",
        aadharNumber: "",
        aadharUrl: "",
        user: {
          id: 0,
          email: "",
          password: "",
          role: "",
          blacklisted: ""
        },
        ownerPreference: {
          id: 1,
          music: "",
          smoking: "",
          petsAllowed: ""
        },
        status: "",
      },
      numberOfPassengers: 0,
      numberOfSeatsAvailable: 0,
      carType: "",
      status: ""

    },
    passenger: {
      id: 0,
      name: "",
      mobileNumber: "",
      dateOfBirth: "",
      user: {
        id: 0,
        email: "",
        password: "",
        role: "",
        blacklisted: ""
      }
    },
    status: "",
    notificationStatus: "NotRead",
    ownerRatingPassenger: 0,
    passengerRatingOwner: 0,
    passengerReviewOwner: ''
  };
  ownerratings!: TripBooking[];

  bookingSucess: boolean = false;
  valid: boolean = true;
  overallrating = 0;
  sum = 0;
  constructor(private service: TripBookingService, private route: ActivatedRoute, private loginAuthService: LoginAuthService) { }

  ngOnInit(): void {
    let idd: any = this.route.snapshot.paramMap.get('id');
    this.bookingTrip.trip.id = idd;
    let resp = this.service.getTrip(idd);
    resp.subscribe((data) => {
      this.trip = data;
      this.service.getOwnerRatingsByUserId(this.trip.owner.id).subscribe((data) => {
        this.ownerratings = (data)
        console.log(this.ownerratings)
        if (this.ownerratings.length != 0) {
          for (var val of this.ownerratings) {
            this.sum += val.passengerRatingOwner;
          }
          this.overallrating = this.sum / this.ownerratings.length;
        }
      });

    }
    );
  }

  booktrip(): void {
    console.log("Clicked");
    if (this.valid) {
      this.bookingTrip.passenger.user.id = this.loginAuthService.user.id;
      this.service.addTripBooking(this.bookingTrip).subscribe(
        (data) => {
          this.ngOnInit();
          this.bookingSucess = true;
        }
      );
    }
  }

  validate(): void {
    if (this.bookingTrip.seatsBooked > 0 && this.bookingTrip.seatsBooked <= this.trip.numberOfSeatsAvailable) {
      this.valid = true;
    } else {
      this.valid = false;
    }

  }

}

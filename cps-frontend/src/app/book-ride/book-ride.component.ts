import { Component, OnInit } from '@angular/core';
import { TripBooking } from '../model/trip-booking';
import { TripBookingService } from '../service/trip-booking.service';

@Component({
  selector: 'app-book-ride',
  templateUrl: './book-ride.component.html',
  styleUrls: ['./book-ride.component.css']
})
export class BookRideComponent implements OnInit {


  trip: any;
  // bookingTrip: TripBooking = {
  //   id: 0,
  //   seatsBooked: 0,
  //   trip: { id: 3 },
  //   passenger: { id: 1 }
  // };
  bookingTrip: TripBooking = {
    id: 0,
    seatsBooked: 0,
    trip: {
      id: 10,
      origin: "",
      destination: "",
      departureTime: "",
      price: 0,
      date: new Date(2021, 10, 1),
      owner: {
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
          role: ""
        },
        ownerPreference: {
          id: 1,
          music: "",
          smoking: "",
          petsAllowed: ""
        },
        status: ""
      },
      numberOfPassengers: 0,
      numberOfSeatsAvailable: 0,
      carType: ""
    },
    passenger: {
      id: 1,
      name: "",
      mobileNumber: "",
      dateOfBirth: new Date(2021, 10, 1),
      user: {
        id: 0,
        email: "",
        password: "",
        role: ""
      }
    }
  }
  bookingSucess: boolean = false;
  valid: boolean = true;
  // let id : any = this.route.snapshot.paramMap.get('id');
  //   this.addRequest.trip.id = id;

  constructor(private service: TripBookingService) { }

  ngOnInit(): void {
    let resp = this.service.getTrip();
    resp.subscribe((data) => this.trip = data);
  }
  booktrip(): void {
    console.log("Clicked");
    if(this.valid){
    this.service.addTripBooking(this.bookingTrip).subscribe(
      (data) => {
        this.ngOnInit();
        this.bookingSucess = true;
      }
    );
    }
  }

  validate(): void {
    if (this.bookingTrip.seatsBooked >0 && this.bookingTrip.seatsBooked <= this.trip.numberOfSeatsAvailable) {
      this.valid = true;

    } else {
      this.valid = false;
    }

  }

}


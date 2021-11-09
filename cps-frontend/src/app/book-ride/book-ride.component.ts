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
  bookingTrip:TripBooking={
    id: 0,
    seatsBooked: 0,
    trip: {
      id: 1,
      origin: "",
      destination: "",
      departureTime: "",
      price: 0,
      date: new Date(2021,10,1),
    owner: {
      id:0,
      name:"",
      address:"",
      mobile:"",
      licenceNumber:"",
      licenceUrl:"",
      aadharNumber:"",
      aadharUrl:"",
      user:{ id: 0,
        email: "",
        password:"",
        role:""	},
      ownerPreference:{
        id:1,
        music:"",
        smoking:"",
        petsAllowed:""
      },
      status:""
    },
      numberOfPassengers: 0,    
      numberOfSeatsAvailable: 0,
      carType: ""
    },
    passenger:{  id: 1,
    name: "",
    mobileNumber: "",
    dateOfBirth:new Date(2021,10,1) ,
    user:{ id: 0,
      email: "",
      password:"",
      role:""	}
    }}


  constructor(private service: TripBookingService) { }

  ngOnInit(): void {
    let resp = this.service.getTrip();
    resp.subscribe((data) => this.trip = data);
  }
  booktrip(): void {
    console.log("Clicked");
    this.service.addTripBooking(this.bookingTrip).subscribe();
   
  }

}


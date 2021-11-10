import { Component, OnInit } from '@angular/core';
import { TripBooking } from '../model/trip-booking';

@Component({
  selector: 'app-book-ride',
  templateUrl: './book-ride.component.html',
  styleUrls: ['./book-ride.component.css']
})
export class BookRideComponent implements OnInit {

  constructor() { }
  bookingTrip:TripBooking={
    id: 0,
    seatsBooked: 0,
    trip: {
      id: 3,
      origin: "",
      destination: "",
      departureTime: "",
      price: 0,
      date: new Date(2021,10,1),
    owner: {
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
  }
  }
  ngOnInit(): void {
  }

}

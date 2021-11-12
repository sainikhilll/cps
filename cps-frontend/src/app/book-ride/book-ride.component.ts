import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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
      date: "",
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
      status:"",
    },
    numberOfPassengers: 0,
    numberOfSeatsAvailable: 0,
    carType: ""},
    passenger: {
      id: 0,
      name: "",
      mobileNumber: "",
      dateOfBirth: "",
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
  
  constructor(private service: TripBookingService,private route:ActivatedRoute,private loginAuthService:LoginAuthService) { }
  
  ngOnInit(): void {
    let idd : any = this.route.snapshot.paramMap.get('id');
    this.bookingTrip.trip.id=idd;
    let resp = this.service.getTrip(idd);
    resp.subscribe((data) => this.trip = data);
  }
  booktrip(): void {
    console.log("Clicked");
    if(this.valid){
      this.bookingTrip.passenger.user.id=this.loginAuthService.user.id;
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

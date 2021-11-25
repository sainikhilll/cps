import { Component, OnInit } from '@angular/core';
import { TripBooking } from '../model/trip-booking';
import { PassengerNotificationsService } from '../service/passenger-notifications.service';

@Component({
  selector: 'app-passenger-notifications',
  templateUrl: './passenger-notifications.component.html',
  styleUrls: ['./passenger-notifications.component.css']
})
export class PassengerNotificationsComponent implements OnInit {

  tripBookings!: TripBooking[];
  tripBooking: TripBooking = {
    id: 0,
    seatsBooked: 0,
    trip: {
      id: 0,
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
          id: 0,
          music: "",
          smoking: "",
          petsAllowed: ""
        },
        status: ""
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
    notificationStatus: "",
    ownerRatingPassenger: 0,
    passengerRatingOwner: 0,
    passengerReviewOwner: ''
  }
  success: boolean = false;
  error: boolean = false;

  constructor(private service: PassengerNotificationsService) { }

  ngOnInit(): void {
    console.log("notifications in ngOnInit");
    this.service.getPassengerDetails(this.tripBooking.passenger.id).subscribe(
      data => {
        console.log("Inside function");
        this.tripBookings = data;
        console.log(this.tripBookings);
        this.tripBookings.sort((a,b)=>a.notificationStatus.localeCompare(b.notificationStatus));
        console.log(this.tripBookings);
      }
    );
    
  }
  updateStatus(): void{
    for(let x of this.tripBookings){
      x.notificationStatus="Read";
      this.service.addNotificationStatus(x).subscribe(
        response => {
          this.success = true;
        },
        error => {
          this.error = true;
        }
      );
      console.log(x);
    }
  }

}

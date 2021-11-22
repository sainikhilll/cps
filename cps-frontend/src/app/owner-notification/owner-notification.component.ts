import { Component, OnInit } from '@angular/core';
import { TripBooking } from '../model/trip-booking';
import { OwnerNotificationService } from '../service/owner-notification.service';

@Component({
  selector: 'app-owner-notification',
  templateUrl: './owner-notification.component.html',
  styleUrls: ['./owner-notification.component.css']
})
export class OwnerNotificationComponent implements OnInit {
  
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
    notificationStatus: ""
  }
  constructor(private service: OwnerNotificationService) { }

  ngOnInit(): void {
    console.log("notifications in ngOnInit");
    this.service.getPassengerDetails(this.tripBooking.trip.owner.id).subscribe(
      data => {
        console.log("Inside function");
        this.tripBookings = data;
        console.log(this.tripBookings);
        // this.updateStatus();

        // for(let x of this.tripBookings){
          
          // this.service.addNotificationStatus(this.tripBookings[1]);
        // }
      }
    );
    //this.service.addNotificationStatus(this.tripBookings[1]);
    
  }
  updateStatus(): void{
    this.tripBookings[1].notificationStatus="Read";
    this.service.addNotificationStatus(this.tripBookings[1]);
    console.log(this.tripBookings[1]);
  }
  
  // tripBooking: TripBooking = {
  //   id: 0,
  //   seatsBooked: 0,
  //   trip: {
  //     id: 0,
  //     origin: "",
  //     destination: "",
  //     departureTime: "",
  //     price: 0,
  //     date: "",
  //     owner: {
  //       id: 0,
  //       name: "",
  //       address: "",
  //       mobile: "",
  //       licenceNumber: "",
  //       licenceUrl: "",
  //       aadharNumber: "",
  //       aadharUrl: "",
  //       user: {
  //         id: 0,
  //         email: "",
  //         password: "",
  //         role: "",
  //         blacklisted: ""
  //       },
  //       ownerPreference: {
  //         id: 0,
  //         music: "",
  //         smoking: "",
  //         petsAllowed: ""
  //       },
  //       status: ""
  //     },
  //     numberOfPassengers: 0,
  //     numberOfSeatsAvailable: 0,
  //     carType: "",
  //     status: ""
  //   },
  //   passenger: {
  //     id: 0,
  //     name: "",
  //     mobileNumber: "",
  //     dateOfBirth: "",
  //     user: {
  //       id: 0,
  //       email: "",
  //       password: "",
  //       role: "",
  //       blacklisted: ""
  //     }
  //   },
  //   status: "",
  //   notificationStatus: ""
  // }
  
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TripBooking } from '../model/trip-booking';
import { LoginAuthService } from '../service/login-auth.service.ts.service';
import { OwnerNotificationService } from '../service/owner-notification.service';
import { Observable, Subject, timer } from 'rxjs';
import { takeUntil } from 'rxjs/operators';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(public loginAuthService : LoginAuthService, private _router: Router, private service: OwnerNotificationService) { }
  destroy = new Subject();
  timer: number=0;
  rxjsTimer = timer(1000,5000);

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

  count: number = 0;
  ngOnInit(): void {
    this.rxjsTimer.pipe(takeUntil(this.destroy))
    .subscribe(val => {
      this.timer = val;
      // console.log(this.timer);
      let counter = 0;
      if(this.loginAuthService.loggedInUser.role=='owner'){
        this.service.getPassengerDetails(this.tripBooking.trip.owner.id).subscribe(
          data => {
            this.tripBookings = data;
            // console.log(this.tripBookings);
            // console.log(this.count);
            for(let x of this.tripBookings){
              if(x.notificationStatus=="NotRead"){
                counter++;
              }
            }
            if(counter != this.count){
              this.count = counter;
            }
            // console.log(this.count);
          }
          
        );
      }
    })
  }

  logout() : void {
    this.loginAuthService.logout();
    this._router.navigate(['/login']);
  } 

}

import { Component, OnInit } from '@angular/core';
import { OwnerRating } from '../model/owner-rating';
import { Trip } from '../model/trip';
import { TripBooking } from '../model/trip-booking';
import { LoginAuthService } from '../service/login-auth.service.ts.service';
import { PassengerReviewRateService } from '../service/passenger-review-rate.service';

@Component({
  selector: 'app-passenger-review-rate',
  templateUrl: './passenger-review-rate.component.html',
  styleUrls: ['./passenger-review-rate.component.css']
})
export class PassengerReviewRateComponent implements OnInit {
  trips!:Trip[];
  
  

 
  alert:boolean=false;
  constructor(private service: PassengerReviewRateService,private loginAuthService:LoginAuthService) { }
  

  ngOnInit(): void {
    let resp = this.service.getTripByStatus();
    resp.subscribe((data)=>{
      this.trips=data;
      console.log(this.trips);
    });
  }

public submitRating(trip:Trip){
  console.log(trip);
  console.log(trip.tripBookingList[0]);
  console.log(trip.id);
 //this.ownerrating.passenger.user.id=this.loginAuthService.user.id;
 let tripBooking = trip.tripBookingList[0]; 
 
 tripBooking.trip = {
    id: trip.id,
    origin: trip.origin,
    destination: trip.destination,
    departureTime: trip.departureTime,
    price: trip.price,
    date: trip.date,
	  owner: trip.owner,
    numberOfPassengers: trip.numberOfPassengers,    
    numberOfSeatsAvailable: trip.numberOfSeatsAvailable,
    carType: trip.carType,
    status: trip.status,
    tripBookingList:[]
 };

 
 tripBooking.passenger.user = this.loginAuthService.user;
    this.service.dorating(tripBooking).subscribe(
     
    );
    {
      this.alert=true;
    }
    //console.log(observable);
    
  }
  public saveRating(ownerId:number)
  {
    console.log(ownerId);
  }
}




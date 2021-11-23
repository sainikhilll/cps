import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { OwnerRating } from '../model/owner-rating';
import { Trip } from '../model/trip';
import { LoginAuthService } from '../service/login-auth.service.ts.service';
import { PassengerReviewRateService } from '../service/passenger-review-rate.service';

@Component({
  selector: 'app-passenger-review-rate',
  templateUrl: './passenger-review-rate.component.html',
  styleUrls: ['./passenger-review-rate.component.css']
})
export class PassengerReviewRateComponent implements OnInit {
  trips:any;
  ownerrating: OwnerRating = {
    id: 0,
    rating: 0,
    review:"",
    passenger:{
      id: 2,
      name: "",
      mobileNumber: "",
      dateOfBirth: "",
      user: {
        id: 2,
        email: "",
        password: "",
        role: "",
        blacklisted: ""
      }
    },
    trip: {
      id: 2,
      origin: "",
      destination: "",
      departureTime: "",
      price: 0,
      date: "",
    owner: {
      id: 0,
      name:"",
      address:"",
      mobile:"",
      licenceNumber:"",
      licenceUrl:"",
      aadharNumber:"",
      aadharUrl:"",
      user:{ id: 2,
        email: "",
        password:"",
        role:"",
        blacklisted: ""
      },
      ownerPreference:{
        id: 2,
        music:"",
        smoking:"",
        petsAllowed:""
      },
      status:"",
    },
    numberOfPassengers: 0,
    numberOfSeatsAvailable: 0,
    carType: "",
    status: ""
  
    },
  }
 

  constructor(private service: PassengerReviewRateService,private loginAuthService:LoginAuthService) { }
  

  ngOnInit(): void {
    let resp = this.service.getTripByStatus();
    resp.subscribe((data)=>this.trips=data);
  }

public submitRating(){
  console.log("buttonclicked");
 // this.ownerrating.passenger.user.id=this.loginAuthService.user.id; 
    this.service.dorating(this.ownerrating).subscribe();
    //console.log(observable);
    
  }
  public saveRating(ownerId:number)
  {
    console.log(ownerId);
  }
}




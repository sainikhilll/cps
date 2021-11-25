import { Component, OnInit } from '@angular/core';
import { OwnerRating } from '../model/owner-rating';
import { TripBooking } from '../model/trip-booking';
import { OwnerViewRatingsService } from '../service/owner-view-ratings.service';

@Component({
  selector: 'app-owner-view-ratings',
  templateUrl: './owner-view-ratings.component.html',
  styleUrls: ['./owner-view-ratings.component.css']
})
export class OwnerViewRatingsComponent implements OnInit {
  ownerRating :OwnerRating = {
    id: 0,
    rating: 0,
    review: '',
    passenger: {
      id: 0,
      name: "",
      mobileNumber: "",
      dateOfBirth: "",
      user : {
        id: 0,
        email: "",
        password: "",
        role: "",	
        blacklisted:""
    }
  },
    owner :{
      id: 0,
      name:"",
      address:"",
      mobile:"",
      licenceNumber:"",
      licenceUrl:"",
      aadharNumber:"",
      aadharUrl:"",
      user: {
        id: 0,
        email: "",
        password: "",
        role: "",	
        blacklisted:""
      },
      ownerPreference: { 
        id: 0,
        music:"",
        smoking:"",
        petsAllowed:"",
      },
      status:""
    }
  }
  ownerRatings : TripBooking[] = [];

  constructor(private ownerViewRatingService: OwnerViewRatingsService) { }

  ngOnInit(): void {
    this.ownerViewRatingService.getOwnerViewRatings().subscribe(
      data=>{
        this.ownerRatings= data;
        console.log("ownerRating");
        console.log(this.ownerRatings);
        
      }
    )
  }

}

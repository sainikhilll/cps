import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PassengerRating } from '../model/passenger-rating';
import { Trip } from '../model/trip';
import { TripBooking } from '../model/trip-booking';
import { PassengerRatingService } from '../service/passenger-rating.service';

@Component({
  selector: 'app-passenger-rating',
  templateUrl: './passenger-rating.component.html',
  styleUrls: ['./passenger-rating.component.css']
})
export class PassengerRatingComponent implements OnInit {

  trips!: Trip[];
  currentList!: TripBooking[];
  currentId = 0;
  constructor(private service: PassengerRatingService, private router: Router) { }

  currentRate = 0;
  ngOnInit(): void {
    this.service.getTrips().subscribe(
      data => {
        this.trips = data;
        console.log(this.trips);
      }
    )
  }

  public showRatings(id: number){
    this.currentId = id;
  }

  public postRatings(trip: Trip, tb: TripBooking) {
    for (let t of this.trips) {
      if (t.id == trip.id) {
        for (let tripBooking of trip.tripBookingList!) {
          if (tripBooking.id == tb.id) {
            this.service.postRating(tripBooking).subscribe(
              data => {
                console.log("success")
              }
            )
          }
        }
      }
    }
  }

  public editTrip(id: number) {
    this.router.navigate(['/edit-cancel-trip-owner', { id: id }]);
  }

  public cancelTrip(id: number) {
    this.service.cancelTrip(id);
  }

}


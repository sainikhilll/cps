import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { REST_URL } from './common';


@Injectable({
  providedIn: 'root'
})
export class TripBookingService {

  constructor(private http:HttpClient) { }
  public getTrip(id:number){
    return this.http.get(REST_URL+"trips/"+id);
  }
  public addTripBooking(tripBooked:any){
    return this.http.post(REST_URL+"trip-bookings",tripBooked);
  }
  public getOwnerRatingsByUserId(id:number){
    return this.http.get<any>(REST_URL+"trip-bookings/ownerRatings/"+id);
  }
}

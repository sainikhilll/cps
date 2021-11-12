import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { REST_URL } from './common';


@Injectable({
  providedIn: 'root'
})
export class TripBookingService {

  constructor(private http:HttpClient) { }
  public getTrip(){
    return this.http.get(REST_URL+"trips/1");
  }
  // public addTripBooking(tripBooked:any){
  //   return this.http.post("http://localhost:8080/trip-bookings",tripBooked);
  //   return this.http.get(REST_URL+"trips/1");
  // }
  public addTripBooking(tripBooked:any){
    return this.http.post(REST_URL+"trip-bookings",tripBooked);
  }
}

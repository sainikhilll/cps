import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class TripBookingService {

  constructor(private http:HttpClient) { }
  public getTrip(){
    return this.http.get("http://localhost:8081/trips/1");
  }
  public addTripBooking(tripBooked:any){
    return this.http.post("http://localhost:8081/trip-bookings",tripBooked);
  }
}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PassengerRating } from '../model/passenger-rating';
import { Trip } from '../model/trip';
import { TripBooking } from '../model/trip-booking';
import { REST_URL } from './common';
import { LoginAuthService } from './login-auth.service.ts.service';

@Injectable({
  providedIn: 'root'
})
export class PassengerRatingService {

  constructor(private http: HttpClient, private service: LoginAuthService) { }

  public getTrips(): Observable<any> {
    return this.http.get<any>(REST_URL + "trip-bookings/2" );
  }

  public postRating(rating: TripBooking): Observable<any>{
    return this.http.put<any>(REST_URL+ "/trip-bookings/passengerRatings", rating);
  }

    public cancelTrip(id: number): Observable<any>{
      return this.http.get<any>(REST_URL+"cancel/trips/" + id);
    }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { OwnerRating } from '../model/owner-rating';
import { Observable } from 'rxjs';
import { REST_URL } from './common';
import { TripBooking } from '../model/trip-booking';
import { LoginAuthService } from './login-auth.service.ts.service';
import { Trip } from '../model/trip';

@Injectable({
  providedIn: 'root'
})
export class PassengerReviewRateService {

  constructor(private http:HttpClient,private loginAuthService: LoginAuthService) { }

  public dorating(tripBooking:TripBooking)
  {
    return this.http.put(REST_URL + "trip-bookings",tripBooking);
  }
  public getTripByStatus(){
    return this.http.get<Trip[]>(REST_URL + "trips/completed/"+ this.loginAuthService.user.id);
  }
}

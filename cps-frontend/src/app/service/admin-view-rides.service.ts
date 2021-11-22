import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trip } from '../model/trip';
import { REST_URL } from './common';
import { TripBookingService } from './trip-booking.service';

@Injectable({
  providedIn: 'root'
})
export class AdminViewRidesService {
  url=REST_URL+"trips";
 

  constructor(private _http:HttpClient) { }

  public restTrips():Observable<any>{
    return this._http.get<any>(this.url);
  }
  public restCompletedTrips():Observable<any>{
    return this._http.get<any>(REST_URL + "completedTrips/");
  }


  public restStatus(id: number):Observable<any>{
    return this._http.get<any>(REST_URL + "canceltrips/" + id);
  }

}

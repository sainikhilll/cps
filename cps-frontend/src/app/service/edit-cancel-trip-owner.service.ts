import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trip } from '../model/trip';
import { REST_URL } from './common';

@Injectable({
  providedIn: 'root'
})
export class EditCancelTripOwnerService {
  url = REST_URL + "trips/update";
  constructor(private _http:HttpClient) {}
  public getTripDetail(): Observable<any>{
    return this._http.get<any>(REST_URL + "trips/" + 1);
  }

  public restTrip(trip:Trip): Observable<any>{
    return this._http.put<any>(this.url, trip);
  }
}

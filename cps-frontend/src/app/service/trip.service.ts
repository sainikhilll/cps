import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

import { Trip } from '../model/trip';
import { Observable } from 'rxjs';
import { REST_URL } from './common';
@Injectable({
  providedIn: 'root'
})
export class TripService {
  url = REST_URL+"trips";

  constructor(private _http: HttpClient) { }

  public trips(trips: Trip): Observable<any> {
    return this._http.post<any>(this.url, trips);

  

 
    
  }
  
  public getApi():Observable<any>{
    const body = {
      'country': 'india',
    }
    return this._http.post<any>("https://countriesnow.space/api/v0.1/countries/cities", body);
  }
}

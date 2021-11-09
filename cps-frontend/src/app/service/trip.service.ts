import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { REST_URL } from './common';
import { Observable } from 'rxjs';
import { Trip } from '../model/trip';

@Injectable({
  providedIn: 'root'
})

export class TripService {
  public getApi():Observable<any>{
    const body = {
      'country': 'india',
    }
    return this.httpClient.post<any>("https://countriesnow.space/api/v0.1/countries/cities", body);
  }

  url: string = REST_URL + "trips";

  constructor(private httpClient : HttpClient) { }
  publish(trip: Trip): Observable<any> {
    const headers = { 'content-type': 'application/json'};
    console.log("publish trip Service");
    return this.httpClient.post<any>(
      this.url, trip, {'headers': headers}
    );
  }
}

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Passenger } from '../model/passenger';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { REST_URL } from './common';


@Injectable({
  providedIn: 'root'
})
export class PassengerService {

  constructor(private httpClient: HttpClient
    ) { }
  signup(passenger:Passenger) :  Observable <any> {
    const headers = { 'content-type': 'application/json'};
    return this.httpClient.post<any>(REST_URL+"passengers", JSON.stringify(passenger), {'headers': headers});


  }


}

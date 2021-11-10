import { getLocaleWeekEndRange } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { Owner } from '../model/owner';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  constructor(private httpClient: HttpClient) { }


getOwners() : Observable<any>{
       return this.httpClient.get("http://localhost:8080/owners");
}
}
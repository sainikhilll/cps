import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { OwnerRating } from '../model/owner-rating';
import { Observable } from 'rxjs';
import { REST_URL } from './common';

@Injectable({
  providedIn: 'root'
})
export class PassengerReviewRateService {

  constructor(private http:HttpClient) { }

  public dorating(ownerrating:OwnerRating)
  {
    return this.http.post(REST_URL + "ownerratings",ownerrating);
  }
  public getTripByStatus(){
    return this.http.get(REST_URL + "ownerratings/complete");
  }
}

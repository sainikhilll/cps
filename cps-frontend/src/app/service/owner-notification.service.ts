import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TripBooking } from '../model/trip-booking';
import { REST_URL } from './common';
import { LoginAuthService } from './login-auth.service.ts.service';

@Injectable({
  providedIn: 'root'
})
export class OwnerNotificationService {
  
  constructor(private http:HttpClient, private service: LoginAuthService) {  }
  getPassengerDetails(ownerId: number): Observable<any> {
    console.log("notifications service starts");
    console.log(this.service.user.id);
    return this.http.get<any>(REST_URL+"notifications/"+this.service.user.id);
  }
  
  addNotificationStatus(tripBooking: TripBooking): Observable<any> {
    const headers = { 'content-type': 'application/json'};
    console.log(tripBooking);
    return this.http.put<any>(
      (REST_URL+"notifications/update"), tripBooking
    );
  }
  
}

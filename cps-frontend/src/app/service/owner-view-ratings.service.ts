import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { REST_URL } from './common';
import { LoginAuthService } from './login-auth.service.ts.service';

@Injectable({
  providedIn: 'root'
})
export class OwnerViewRatingsService {

  constructor(private httpClient: HttpClient, private service: LoginAuthService) { }

  getOwnerViewRatings() : Observable<any> {
    return this.httpClient.get(REST_URL+"viewratings/"+this.service.user.id);
  }
}

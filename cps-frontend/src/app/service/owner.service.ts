import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Owner } from '../model/owner';
import { Observable } from 'rxjs';
import { REST_URL } from './common';
import { LoginAuthService } from './login-auth.service.ts.service';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  constructor(private http: HttpClient, private loginAuthService: LoginAuthService) { }
  public registerOwner(ownerData: Owner): Observable<any>{
    return this.http.put<any>(REST_URL +"owners", ownerData);
  }

  public getOwnerDetails(): Observable<any>{
    return this.http.get<any>(REST_URL +'owners/user/'+ this.loginAuthService.user.id);
  }
}

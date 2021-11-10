import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';
import { REST_URL } from './common';


// export const AUTH_TOKEN_KEY = 'auth-token';
// export const AUTH_USER_DATA = 'user-data';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  loginUrl : string = REST_URL+"/authenticate";

  constructor(private httpClient : HttpClient) { }
  login(user : User): Observable<any> {                                      
    const headers = {'content-type':'application/json'};
    // sessionStorage.setItem(AUTH_USER_DATA, JSON.stringify(user));


    return this.httpClient.post<any>(
     this.loginUrl,user,{'headers':headers}
      
     );
  }
  // user : User = {
  //   id: 0,
  //   email: '',
  //   password: '',
  //   role: ''
  // }
}

import { Injectable } from '@angular/core';
import { User } from '../model/user';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {
  ownerLoggedIn : boolean = false;
  passengerLoggedIn : boolean = false;
  adminLoggedIn : boolean = false;
  user : User = {
    id : 0,
    email : "",
    password : "",
    role : ""
  };

  constructor(private authService : AuthService) { }

  setUser(user : User) : void {
    this.user = user;
  }

  get loggedInUser() : User {
    return this.user;
  }

  logout() : void {
    this.user =  {
      id : 0,
      email : "",
      password : "",
      role : ""
    };
  }

  
}

import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class LoginAuthService {
  ownerLoggedIn : boolean = false;
  passengerLoggedIn : boolean = false;
  adminLoggedIn : boolean = false;

  constructor(private authService : AuthService) { }

  ownerlogin() : void {
    this.ownerLoggedIn = true;
  }

  ownerlogout() : void {
    this.ownerLoggedIn = false;
  }

  get isOwnerLoggedIn() : boolean {
    return this.ownerLoggedIn;
  }

  passengerlogin() : void {
    this.passengerLoggedIn = true;
  }

  passengerlogout() : void {
    this.passengerLoggedIn = false;
  }

  get isPassengerLoggedIn() : boolean {
    return this.passengerLoggedIn;
  }

  adminlogin() : void {
    this.adminLoggedIn = true;
  }

  adminlogout() : void {
    this.adminLoggedIn = false;
  }

  get isAdminLoggedIn() : boolean {
    return this.adminLoggedIn;
  }
}

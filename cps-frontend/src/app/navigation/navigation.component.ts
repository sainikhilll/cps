import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginAuthService } from '../service/login-auth.service.ts.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(public loginAuthService : LoginAuthService, private _router: Router) { }

  ngOnInit(): void {
  }

  ownerlogout() : void {
    this.loginAuthService.ownerlogout();
    this._router.navigate(['/login']);
  }

  passengerlogout() : void {
    this.loginAuthService.passengerlogout();
    this._router.navigate(['/login']);
  }

  adminlogout() : void {
    this.loginAuthService.adminlogout();
    this._router.navigate(['/login']);

  }

}

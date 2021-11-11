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

  logout() : void {
    this.loginAuthService.logout();
    this._router.navigate(['/login']);
  }

  

}

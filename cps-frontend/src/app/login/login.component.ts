import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { AuthService } from '../service/auth.service';
import { LoginAuthService } from '../service/login-auth.service.ts.service';

export const AUTH_USER_DATA = 'user-data';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {
  user: User = {
    id: 0,
    email: "",
    password: "",
    role: "",
    blacklisted: "Y"
  }

  
  success: boolean = false;
  currentLoggedInUser !: User;
  error !: HttpErrorResponse;
  fail : boolean = false;
  status : boolean = false;
  

  constructor(private authService: AuthService, private router : Router, private loginAuthService : LoginAuthService) { 

  }

  ngOnInit(): void {
  }

  login(): void {
    //console.log("login starts");
    let observable: Observable<any> = this.authService.login(this.user);
    observable.subscribe(
      data => {
        console.log(data.role);
        console.log("login successful");
        this.currentLoggedInUser = data;
        this.loginAuthService.setUser(data);
        if(this.loginAuthService.user.blacklisted == "Y")
        {
          this.status = true;
        }
        else{
          this.success = true;
        }
        console.log(this.currentLoggedInUser);
        // sessionStorage.setItem(AUTH_USER_DATA, JSON.stringify(this.currentLoggedInUser));

        if(this.currentLoggedInUser.role == "owner" && this.success==true) {
          this.router.navigate(['/passenger-rating']);
          // this.loginAuthService.ownerlogin();
        }
        else if(this.currentLoggedInUser.role == "passenger"&&this.success == true) {
          this.router.navigate(['/search-trip']);
          // this.loginAuthService.passengerlogin();
        }

        else if (this.currentLoggedInUser.role == "admin") {
          this.router.navigate(['/approve-ride-owner']);
          // this.loginAuthService.adminlogin();
        }


      },
      
      error => {

        this.fail = true;
        console.log(error);

      } 
    )

  }
  
}





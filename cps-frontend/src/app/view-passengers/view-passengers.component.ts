import { Component, OnInit } from '@angular/core';
import { Passenger } from '../model/passenger';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-view-passengers',
  templateUrl: './view-passengers.component.html',
  styleUrls: ['./view-passengers.component.css']
})
export class ViewPassengersComponent implements OnInit {
  passenger : Passenger[] = [];

  constructor(
    private authService: AuthService) { }

  ngOnInit(): void {
    this.authService.getPassenger().subscribe(
      data =>{
        this.passenger= data;
    
    })
  }
  blackList(id:number){
    this.authService.blackList(id).subscribe(
      data=>{
        this.ngOnInit()

        
      }
    )

  }
}

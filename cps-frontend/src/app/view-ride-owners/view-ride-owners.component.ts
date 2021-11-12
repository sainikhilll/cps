import { Component, OnInit } from '@angular/core';
import { Owner } from '../model/owner';
import { OwnerService } from '../service/owner.service';

@Component({
  selector: 'app-view-ride-owners',
  templateUrl: './view-ride-owners.component.html',
  styleUrls: ['./view-ride-owners.component.css']
})
export class ViewRideOwnersComponent implements OnInit {

  owners : Owner[] = [];
  constructor(private ownerService: OwnerService) { }

  ngOnInit(): void {
    this.ownerService.getOwners().subscribe(
      data =>{
        this.owners= data;
      }
    )
  }

}

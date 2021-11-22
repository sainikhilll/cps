import { Component, OnInit } from '@angular/core';
import { OwnerRating } from '../model/owner-rating';
import { OwnerViewRatingsService } from '../service/owner-view-ratings.service';

@Component({
  selector: 'app-owner-view-ratings',
  templateUrl: './owner-view-ratings.component.html',
  styleUrls: ['./owner-view-ratings.component.css']
})
export class OwnerViewRatingsComponent implements OnInit {
  ownerRatings : OwnerRating[] = [];

  constructor(private ownerViewRatingService: OwnerViewRatingsService) { }

  ngOnInit(): void {
    this.ownerViewRatingService.getOwnerViewRatings().subscribe(
      data=>{
        this.ownerRatings= data;
        console.log("ownerRating");
        console.log(this.ownerRatings);
      }
    )
  }

}

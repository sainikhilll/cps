import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Owner } from '../model/owner';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  constructor(private http: HttpClient) { }
  public registerOwner(ownerData: Owner): Observable<any>{
    return this.http.put<any>('http://localhost:8080/owners', ownerData);
  }

  public getOwnerDetails(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/owners/'+ 3);
  }
}

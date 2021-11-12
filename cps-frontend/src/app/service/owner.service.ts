import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from '../model/owner';
import { REST_URL } from './common';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {

  
  constructor(private httpClient: HttpClient) { }
  // signup(owner: Owner) : Observable<any>  {
  //   console.log("signup called");
  //   const headers = { 'content-type': 'application/json'};
  //   // let header : HttpHeaders = new HttpHeaders();
  //   // header.set('Content-Type', 'application/json');
  //   return this.httpClient.post<any>("http://localhost:8080/owners", JSON.stringify(owner), {'headers': headers});
  
// }


public signup(owner: Owner) : Observable<any> 
 {
  const url=REST_URL+"owners"; 
  return this.httpClient.post<any>(url, owner);

  
}

}

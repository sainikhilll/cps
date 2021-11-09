import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Owner } from '../model/owner';

@Injectable({
  providedIn: 'root'
})
export class OwnerService {
url="http://localhost:8080/approvals";
url1="http://localhost:8080/approvals/updates";
  constructor(private _http:HttpClient) { }
  public restOwner():Observable<any>{
    return this._http.get<any>(this.url);
    
  }
  public updateOwner(id:number):Observable<any>{
    return this._http.get<any>("http://localhost:8080/approvals/updates/"+id);
  }
  public rejectOwner(id:number):Observable<any>{
    return this._http.get<any>("http://localhost:8080/approvals/rejects/"+id);
  }
}

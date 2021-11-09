import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';

import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})


export class UserService {
  PasswordUrl : string = "http://localhost:8080/authenticate/";
  constructor(private httpClient:HttpClient) { }


  onSubmit(user : User,np:string) : Observable<any> { 
    const headers = {'content-type':'application/json'};
    return this.httpClient.put<any>(
      this.PasswordUrl+np,user,{'headers':headers}
    );
    

  }
  user: User = {  
    id: 0,
    email: '',
    password: '',
    role: ''
  }


}

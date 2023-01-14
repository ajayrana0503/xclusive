import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root'
})

export class LoginSignUpApiService{
  rootUrl = 'http://localhost:8080'
  constructor(private _http : HttpClient)
  {}

  onRegisterUser(input: any){

  //return this._http.post("http://localhost:8080",input);
    return this._http.post(this.rootUrl,input);
  }
  onLogin(input : any){
     return this._http.post(this.rootUrl+'',input);
  }
}

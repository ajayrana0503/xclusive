import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { AuthenticationService } from './authentication-token.service';
import { GatewayService } from './gateway.service';

@Injectable({
  providedIn: 'root'
})

export class LoginSignUpApiService{
  rootUrl = 'http://localhost:8080'
  constructor(private _http : HttpClient,
    private _authenticationService : AuthenticationService,
    private _gatewayService : GatewayService)
  {}

  onRegisterUser(input: any){

  return this._http.post("http://localhost:8080/user/register",input);
    return this._http.post(this.rootUrl,input);
  }
  onLogin(input : any){
    // return this._gatewayService.handleGatewayPost("http://localhost:8080/user/login")
     return this._http.post("http://localhost:8080/user/login",input);
  }
  onLogout(){
    return this._gatewayService.handleGatewayGet("http://localhost:8080/logout")
    //return this._http.get("http://localhost:8080/logout");
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from './authentication-token.service';

@Injectable()
export class GatewayService {

  constructor(
    private _http: HttpClient,
    private _authenticationService : AuthenticationService
  ) { }
  headers = this._authenticationService.getToken();
  handleGatewayPost(url: string, input?: any){
    // const input = {
    //   request: {
    //     method: method,
    //     url: url,
    //     ...(payload ? { payload: payload } : null)
    //   }
    // };

    return this._http.post(url, input, {
      headers: this.headers
    });
  }
  handleGatewayGet(url : string, input? : any){
    return this._http.get(url,{headers: this.headers})
  }
}

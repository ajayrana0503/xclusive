import { Injectable } from "@angular/core";

@Injectable({
  providedIn : 'root'
})

export class AuthenticationService{
   constructor(){}
  setToken(value : string){
    sessionStorage.setItem('Token', JSON.stringify(value));
  }
  getToken(){
    let value = sessionStorage.getItem('Token');
    return value ? JSON.parse(value) : null;
  }
}

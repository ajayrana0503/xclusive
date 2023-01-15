import { Router } from '@angular/router';
import {Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { take } from 'rxjs';
import { MustMatch } from 'src/app/helpers';
import { LoginSignUpApiService } from 'src/app/services';

@Component({
  selector : 'sign-up-reactive',
  templateUrl : './sign-up-reactive.component.html',
  styleUrls : ['./sign-up-reactive.component.css']
})

export class SignUpReactiveComponent implements OnInit{
  registerForm: FormGroup;
  submitted : boolean = false;
  loading : boolean = false;

  constructor(private _fb : FormBuilder,
     private _loginSignUpApiService : LoginSignUpApiService,
     private _navigation : Router
    ){

  }

  ngOnInit(){
      this.initializeRegisterForm();
  }

  private initializeRegisterForm(){
    this.registerForm = this._fb.group({
      userName: ['',[Validators.required, Validators.pattern(/^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$/)]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', Validators.required],
  }, {
      validator: MustMatch('password', 'confirmPassword')
  });
  }

  get form() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid) {
        return;
    }
    else{

      let input = this._parseInput();
      this._loginSignUpApiService.onRegisterUser(input).pipe(take(1)).subscribe((response)=>
      {
        console.log(response);
      },
      (error)=>{
        console.log(error)
      })

    }

}
private _parseInput(){
      let data = this.registerForm['value'];
      return {name : data.userName , email : data.email , password : data.password};

}

onReset() {
    this.submitted = false;
    this.registerForm.reset();
}

onNavigateLogin(){
   this._navigation.navigateByUrl('/login');
}

}

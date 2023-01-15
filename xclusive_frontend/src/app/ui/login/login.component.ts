import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { take } from "rxjs";
import { AuthenticationService, LoginSignUpApiService } from "src/app/services";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {
  loginForm: FormGroup;
  submitted: boolean = false;
  loading: boolean = false;

  constructor(private _fb: FormBuilder,
    private _loginSignUpApiService: LoginSignUpApiService,
    private _navigation: Router,
    private _authenticationService : AuthenticationService
  ) {
  }

  ngOnInit() {
    this.initializeloginForm();
  }

  private initializeloginForm() {
    this.loginForm = this._fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
    });
  }

  get form() { return this.loginForm.controls; }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }
    else {

      let input = this._parseInput();
      this._loginSignUpApiService.onLogin(input).pipe(take(1)).subscribe((response : any) => {
        console.log(response.output.jwt)
        this._authenticationService.setToken(response?.output?.jwt)

       },
        () => { })

    }

  }
  private _parseInput() {
    let data = this.loginForm['value'];
    return { email: data.email, password: data.password };

  }

  onReset() {
    this.submitted = false;
    this.loginForm.reset();
  }

  onNavigateRegister() {
    this._navigation.navigateByUrl('/register');
  }
}

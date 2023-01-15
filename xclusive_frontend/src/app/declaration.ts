
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component"
import { DashboardComponent, InputComponent, LoginButtonComponent, LoginComponent, PageErroComponent, SignUpComponent, SignUpReactiveComponent } from "./ui"
import { AppRoutingModule } from "./app-routing.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { LoginSignUpApiService } from "./services";
import { TooltipModule } from 'ngx-bootstrap/tooltip';


export const component = [
  AppComponent,
  DashboardComponent,
  LoginComponent,
  PageErroComponent,
  SignUpComponent,
  InputComponent,
  LoginButtonComponent,
  SignUpReactiveComponent
]


export const bootstrap = [AppComponent];

export const imports = [
  BrowserModule,
  AppRoutingModule,
  FormsModule,
  HttpClientModule,
  ReactiveFormsModule,
  TooltipModule.forRoot()
];

export const providers = [
  LoginSignUpApiService
];

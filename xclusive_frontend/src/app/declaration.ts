
import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component"
import { DashboardComponent, FooterComponent, HeaderComponent, InputComponent, LoginButtonComponent, LoginComponent, PageErroComponent, SignUpComponent, SignUpReactiveComponent } from "./ui"
import { AppRoutingModule } from "./app-routing.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { LoginSignUpApiService } from "./services";


export const component = [
  AppComponent,
  DashboardComponent,
  FooterComponent,
  HeaderComponent,
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
  ReactiveFormsModule
];

export const providers = [
  LoginSignUpApiService
];

import { BrowserModule } from "@angular/platform-browser";
import { AppComponent } from "./app.component"
import { DashboardComponent, FooterComponent, HeaderComponent, InputComponent, LoginButtonComponent, LoginComponent, PageErroComponent, SignUpComponent } from "./ui"
import { AppRoutingModule } from "./app-routing.module";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";


export const component = [ AppComponent,DashboardComponent,FooterComponent, HeaderComponent,LoginComponent,PageErroComponent,SignUpComponent,InputComponent,LoginButtonComponent]


export const bootstrap = [AppComponent];

export const imports = [
  BrowserModule,
  AppRoutingModule,
  FormsModule,
  HttpClientModule,
];

export const providers = [];

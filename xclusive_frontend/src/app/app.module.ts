import { bootstrap, component, imports, providers } from './declaration';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


@NgModule({
  declarations:
    component
  ,
  imports:
    imports
  ,
  providers: providers,
  bootstrap: bootstrap
})
export class AppModule { }

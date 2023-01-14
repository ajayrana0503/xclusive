import { SignUpComponent } from './ui/sign-up/sign-up.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent, LoginComponent, PageErroComponent, SignUpReactiveComponent } from './ui';

const routes: Routes = [
  {
    path: '',

    component: SignUpReactiveComponent,
  },
  {
    path: 'login',

    component: LoginComponent,
  },
  {
    path: 'register',

    component: SignUpComponent,
  },
  {
    path: '**',
    component: PageErroComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

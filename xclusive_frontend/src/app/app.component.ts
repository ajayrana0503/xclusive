import { Component, OnInit } from '@angular/core';
import { Subject, takeUntil } from 'rxjs';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = ''
  constructor(private apiService: AppService){}
  
  ngOnInit(): void {
    this.getUser()
  }
  getUser(){

   console.log('test')
    this.apiService.getUsers().subscribe((res : any)=>{
        console.log(res) 
        this.title = res['101'] as any
    },(error)=>{
      console.log(error)
    })
  }

}

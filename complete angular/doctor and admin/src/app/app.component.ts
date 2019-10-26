import { Component, OnInit} from '@angular/core';
import { RouterLink, Router } from '@angular/router';
import { NgClass } from '@angular/common';
import { OcsService } from './ocs.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(private _ocsService:OcsService,private _router:Router){}
  ngOnInit() {
 
    this._router.navigate(['/homepage']);
  }


 
  
  
}

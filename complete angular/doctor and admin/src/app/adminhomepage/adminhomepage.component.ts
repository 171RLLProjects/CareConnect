import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-adminhomepage',
  templateUrl: './adminhomepage.component.html',
  styleUrls: ['./adminhomepage.component.css']
})
export class AdminhomepageComponent implements OnInit {

  aname:string;
  constructor(private _activatedRouter:ActivatedRoute,private _router:Router) {
    
   }

  ngOnInit() {
    this.aname=this._activatedRouter.snapshot.paramMap.get("aname");
    console.log(this.aname);
  }
  logout(){
    this._router.navigateByUrl('/homepage');
  }

}

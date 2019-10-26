import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsService } from '../ocs.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-choosedoctor',
  templateUrl: './choosedoctor.component.html',
  styleUrls: ['./choosedoctor.component.css']
})
export class ChoosedoctorComponent implements OnInit {

  adate:String;
  did:String;
  pid:String;
  constructor(private doctor:Doctor,private doctors:Doctor[],private _ocsService:OcsService,private _router:Router,
    private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {
    this.adate=this._activatedRouter.snapshot.paramMap.get('adate');
    this.did=this._activatedRouter.snapshot.paramMap.get('did');
    
  }

}

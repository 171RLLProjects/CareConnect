import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-updateappointment',
  templateUrl: './updateappointment.component.html',
  styleUrls: ['./updateappointment.component.css']
})
export class UpdateappointmentComponent implements OnInit {

  constructor(private doctor:Doctor,private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  ngOnInit() {
  }

}

import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-reqappointment',
  templateUrl: './reqappointment.component.html',
  styleUrls: ['./reqappointment.component.css']
})
export class ReqappointmentComponent implements OnInit {

  constructor( private doctor:Doctor,private _ocsService:OcsService,private _router:Router,private _activatedRouter:ActivatedRoute) { }

  pid:string;
  i:number;
  adate:string;
  ngOnInit() {
  }

  reqAppointment()
  {
    this._ocsService.checkandReqAppointment(this.pid).subscribe(data =>
      { this.i=data;});
      if(this.i===0)
      {
            alert('you already have an appointment ,check in appointments information');
            this._router.navigate(['/reqappointment']);
      }
      else{
        this._router.navigate(['/updatepatient',this.adate]);
      }
  }

}

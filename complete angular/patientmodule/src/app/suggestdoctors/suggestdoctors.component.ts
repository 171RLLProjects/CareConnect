import { Component, OnInit } from '@angular/core';
import { Doctor } from '../doctor';
import { OcsServiceService } from '../ocs-service.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Patient } from '../patient';

@Component({
  selector: 'app-suggestdoctors',
  templateUrl: './suggestdoctors.component.html',
  styleUrls: ['./suggestdoctors.component.css']
})
export class SuggestdoctorsComponent implements OnInit {
  pid:string;
  adate: string; 
doctors:Doctor[];
  
  constructor(private _ocsService:OcsServiceService,
    private _router:Router,private _activatedRoute:ActivatedRoute) { }

  ngOnInit() {
   
    this.adate=this._activatedRoute.snapshot.paramMap.get('pid');
    console.log('adate'+this.adate);
    this.pid=this._activatedRoute.snapshot.paramMap.get('adate');
    console.log('pid'+this.pid);
    this._ocsService.getDoctorsByLocAndSym(this.pid).subscribe(
      doctors =>{
        this.doctors=doctors;
      },
      error =>{
        alert(error);
      }
    );
  }

  logout(){
    this._router.navigateByUrl('/homepage');
  }

  doctorDetails(did:string)
  {
    this._router.navigate(['/choosedoctor/',did,this.adate,this.pid]);
  }
}

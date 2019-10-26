import { Component, OnInit } from '@angular/core';
import { Location } from '../location';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addlocation',
  templateUrl: './addlocation.component.html',
  styleUrls: ['./addlocation.component.css']
})
export class AddlocationComponent implements OnInit {

  location = new Location;
  constructor(private _ocsService:OcsService,private _router:Router,private  _activatedRoute:ActivatedRoute) { }
 
  ngOnInit() {
    this.location.locid=this._activatedRoute.snapshot.paramMap.get("locid");
 
    this.location.streetName=this._activatedRoute.snapshot.paramMap.get("streetName");
    this.location.areaName=this._activatedRoute.snapshot.paramMap.get("areaName");
    this.location.city=this._activatedRoute.snapshot.paramMap.get("city");
    this.location.pincode=+this._activatedRoute.snapshot.paramMap.get("pincode");
  }
addlocation()
{
this.location={
  'locid':this.location.locid,
  'streetName':this.location.streetName,
  'areaName':this.location.areaName,
  'city':this.location.city,
  'pincode':this.location.pincode
};
if(this.location.locid===null)
{
this._ocsService.addLocation(this.location).subscribe(
data =>{
  this._router.navigate(['/viewlocations']);
},
error => {
  alert(error);
});
}
else
{
  this._ocsService.updateLocation(this.location).subscribe(
    data =>{
      this._router.navigate(['/viewlocations']);
    },
    error => {
      alert(error);
    });
}
}

}

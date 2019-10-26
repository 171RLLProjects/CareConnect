import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router } from '@angular/router';
import { Location } from '../location';

@Component({
  selector: 'app-viewlocations',
  templateUrl: './viewlocations.component.html',
  styleUrls: ['./viewlocations.component.css']
})
export class ViewlocationsComponent implements OnInit {

  locations:Location[];
  constructor(private _ocsService:OcsService,private _router:Router) { }
 
  ngOnInit() {
    this._ocsService.getAllLocations().subscribe(
      location =>
      {
        this.locations=location;
      },
      error =>
      {
        alert(error);
      });
  }
 
  edit(loc:Location): void {
    console.log('location edit called');
    this._router.navigate(['/addlocation/',loc]);
  }
  delete(location:Location)
  {
    this._ocsService.deleteLocation(location.locid).subscribe(
      data => {
        this.locations=this.locations.filter(u => u !== location);
      });
     
  }

}

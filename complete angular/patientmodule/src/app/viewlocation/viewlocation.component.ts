import { Component, OnInit } from '@angular/core';
import { Location } from '../location';
import { OcsServiceService } from '../ocs-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-viewlocation',
  templateUrl: './viewlocation.component.html',
  styleUrls: ['./viewlocation.component.css']
})
export class ViewlocationComponent implements OnInit {

  locations:Location[];
  constructor(private _ocsService:OcsServiceService,private _router:Router) { }

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

}

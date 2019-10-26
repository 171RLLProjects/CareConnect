import { Component, OnInit } from '@angular/core';
import { Leave } from '../leave';
import { Router, ActivatedRoute } from '@angular/router';
import { OcsService } from '../ocs.service';

@Component({
  selector: 'app-update-leave',
  templateUrl: './updateleave.component.html',
  styleUrls: ['./updateleave.component.css']
})
export class UpdateLeaveComponent implements OnInit {
  leaves:Leave[];

  constructor(private _ocsservice: OcsService, private router: Router,private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this. _ocsservice.getLeavesByStatus().subscribe(leaves =>
      {
        console.log("leaves");
        this.leaves=leaves;
        console.log(leaves);
        console.log('leave display');
      });

  }
  logout(){
    this.router.navigateByUrl('/homepage');
  }

    updateLeave(l1: Leave)
    {
      l1.leaveStatus="approved";
      this._ocsservice.updateLeave(l1).subscribe(data => {
        this.leaves=this.leaves.filter(u => u !== l1);
      });
      //alert('successfully updated');
    
   }
      
    }
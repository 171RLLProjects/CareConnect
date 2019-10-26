import { Component, OnInit } from '@angular/core';
import { OcsService } from '../ocs.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-viewappforadmin',
  templateUrl: './viewappforadmin.component.html',
  styleUrls: ['./viewappforadmin.component.css']
})
export class ViewappforadminComponent implements OnInit {

  appointments:Appointment[];
  constructor(private _ocsservice: OcsService, private router: Router,private activatedRoute: ActivatedRoute) { }
 
  ngOnInit() {
    this. _ocsservice.getAppointmentsByStatus().subscribe(appointments =>
      {
        
        this.appointments=appointments;
        
        
      });
 
  }
  
 
    updateAppointment(appointment:Appointment)
    {
      
      this._ocsservice.updateAppointment(appointment.appointmentId).subscribe(data => {
        this.appointments=this.appointments.filter(u => u !== appointment);
      
      //alert('successfully updated');
       });
      }
}

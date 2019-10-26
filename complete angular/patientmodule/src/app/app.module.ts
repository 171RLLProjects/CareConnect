import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule,FormGroup, Validators } from '@angular/forms';
import {RouterModule, Routes} from '@angular/router';
//import {FormBuilder} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { PatientLoginComponent } from './patient-login/patient-login.component';
import { OcsServiceService } from './ocs-service.service';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { UpdatepatientComponent } from './updatepatient/updatepatient.component';
import { AddlocationComponent } from './addlocation/addlocation.component';
import { AdddoctorComponent } from './adddoctor/adddoctor.component';
import { ViewDoctorComponent } from './view-doctor/view-doctor.component';
import { PatienthomepageComponent } from './patienthomepage/patienthomepage.component';
import { PatientappointmentsComponent } from './patientappointments/patientappointments.component';
import { SuggestdoctorsComponent } from './suggestdoctors/suggestdoctors.component';
import { ChoosedoctorComponent } from './choosedoctor/choosedoctor.component';
import { ViewlocationComponent } from './viewlocation/viewlocation.component';
import { HomepageComponent } from './homepage/homepage.component';



const appRoute: Routes = [
  {path: 'home',  component: AppComponent},
  {path: 'homepage',  component: HomepageComponent},
  {path: 'addpatient', component:AddPatientComponent},
  {path: 'patientlogin', component:PatientLoginComponent},
  {path: 'updatepatient/:adate/:pid', component:UpdatepatientComponent},
  {path: 'patienthomepage/:pid', component:PatienthomepageComponent},
  {path: 'patientappointments/:pid', component:PatientappointmentsComponent},
  {path: 'suggestdoctors/:adate/:pid', component:SuggestdoctorsComponent},
  {path: 'choosedoctor/:did/:adate/:pid', component:ChoosedoctorComponent},
  //{path: 'addlocation', component: AddlocationComponent},
  //{path: 'viewlocation', component: ViewlocationComponent},
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    PatientLoginComponent,
    AddPatientComponent,
    UpdatepatientComponent,
    AddlocationComponent,
    AdddoctorComponent,
    ViewDoctorComponent,
    PatienthomepageComponent,
    PatientappointmentsComponent,
    SuggestdoctorsComponent,
    ChoosedoctorComponent,
    ViewlocationComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,FormsModule,HttpClientModule,RouterModule.forRoot(appRoute),ReactiveFormsModule//FormBuilder,FormGroup,Validators
  ],
  providers: [OcsServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

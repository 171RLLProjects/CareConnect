import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Patient } from './patient';
import { Observable, throwError } from 'rxjs';
import { Doctor } from './doctor';
import { Reporter } from './reporter';
import { Leave } from './leave';
import { Appointment } from './appointment';
import { Location } from './location';
import { tap, catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class OcsServiceService {

  headers = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  }

  constructor(private _http: HttpClient) { }


  doctorLogin(userId: String, password: String) {

    return this._http.get<Doctor>(`http://172.21.41.13:6987/PraneethaOCSproject/doctorlogin/` + userId + `/` + password);

  }

  getAllDoctors(): Observable<Doctor[]> {
    return this._http.get<Doctor[]>('http://172.21.41.13:6987/PraneethaOCSproject/getalldoctors');

  }
  addDoctor(doctor: Doctor): Observable<String> {
    return this._http.post<String>('http://172.21.41.13:6987/PraneethaOCSproject/adddoctor', JSON.stringify(doctor), this.headers)
  }
  deleteDoctor(did: string) {
    return this._http.delete(`http://172.21.41.13:6987/PraneethaOCSproject/deletedoctor/` + did);
  }
  updateDoctor(doctor: Doctor) {
    return this._http.put('http://172.21.41.13:6987/PraneethaOCSproject/updatedoctor', JSON.stringify(doctor), this.headers)
  }
  getDoctorById(did: string): Observable<Doctor> {
    return this._http.get<Doctor>(`http://172.21.41.13:6987/PraneethaOCSproject/getdoctorbyid/` + did);
  }
  getDoctorsByLocAndSym(pid: string): Observable<Doctor[]> {
    return this._http.get<Doctor[]>(`http://172.21.41.13:6987/PraneethaOCSproject/getdoctorsbylocandsym/` + pid);
  }
  addReporter(reporter: Reporter) {
    return this._http.post('http://172.21.41.13:6987/PraneethaOCSproject/addreporter', JSON.stringify(reporter), this.headers)

  }
  updateReporter(reporter: Reporter) {
    return this._http.put('http://172.21.41.13:6987/PraneethaOCSproject/updatereporter', JSON.stringify(reporter), this.headers)

  }

  getReporterById(rid: string): Observable<Reporter> {
    return this._http.get<Reporter>(`http://172.21.41.13:6987/PraneethaOCSproject/getreporterbyid/` + rid)
  }


  patientLogin(pid: string, password: string): Observable<Patient> {
    console.log("patientlogin");
    return this._http.get<Patient>(`http://172.21.41.13:6987/PraneethaOCSproject/login/` + pid + `/` + password);
  }

  addPatient(patient: Patient): Observable<Patient> {
    console.log(patient);
    console.log("addpatient");
    return this._http.post<Patient>('http://172.21.41.13:6987/PraneethaOCSproject/addpatient', JSON.stringify(patient), this.headers);
  }


  updatePatient(patient: Patient) {
    console.log(patient);
    console.log("updatepatient");
    return this._http.put('http://172.21.41.13:6987/PraneethaOCSproject/updatepatient', JSON.stringify(patient), this.headers);
  }

  getPatientByid(pid: String): Observable<Patient> {

    return this._http.get<Patient>(`http://172.21.41.13:6987/PraneethaOCSproject/getpatientbyid/` + pid);
  }

  addLocation(location: Location) {
    console.log("addlocation");
    return this._http.post('http://172.21.41.13:6987/PraneethaOCSproject/addlocation', JSON.stringify(location), this.headers);
  }

  viewLocation(location: Location) {
    console.log("VIEWlocation");
    return this._http.put('http://172.21.41.13:6987/PraneethaOCSproject/updatelocation', JSON.stringify(location), this.headers);
  }

  getLocationByid(locid: String): Observable<Location> {
    console.log("getlocationbyid");
    return this._http.get<Location>(`http://172.21.41.13:6987/PraneethaOCSproject/getlocationbyid/` + locid);
  }


  getAllLocations(): Observable<Location[]> {
    return this._http.get<Location[]>('http://172.21.41.13:6987/PraneethaOCSproject/getalllocations');
  }

  insertLeave(leave: Leave) {
    console.log(leave);
    return this._http.post('http://172.21.41.13:6987/PraneethaOCSproject/addleave', JSON.stringify(leave), this.headers);
  }
  updateLeave(leave: Leave) {
    return this._http.put('http://172.21.41.13:6987/PraneethaOCSproject/updateleave', JSON.stringify(leave), this.headers);

  }
  getLeaveById(lid: string): Observable<Leave> {
    return this._http.get<Leave>(`http://172.21.41.13:6987/PraneethaOCSproject/getleavebyid/` + lid);
  }
  getLeavesByStatus(): Observable<Leave[]> {
    return this._http.get<Leave[]>('http://172.21.41.13:6987/PraneethaOCSproject/getleavesbystatus');
  }
  getLeavesByDoctor(doctor: Doctor): Observable<Leave[]> {
    return this._http.post<Leave[]>('http://172.21.41.13:6987/PraneethaOCSproject/getleavesbydoctor', JSON.stringify(doctor), this.headers)

  }
  checkAndRequestLeave(did: String): Observable<number> {
    return this._http.get<number>(`http://172.21.41.13:6987/PraneethaOCSproject/checkandreqleave/` + did);
  }
  addAppointment(adate: string, pid: string, did: string) {
    console.log(adate + pid + did);
    return this._http.get(`http://172.21.41.13:6987/PraneethaOCSproject/addappointment/` + adate + `/` + pid + `/` + did);

  }
  updateAppointment(appointment: Appointment) {
    return this._http.put('http://172.21.41.13:6987/PraneethaOCSproject/updateappointment', JSON.stringify(appointment), this.headers);

  }
  getAppointmentsByPatient(pid: String): Observable<Appointment[]> {
    return this._http.get<Appointment[]>(`http://172.21.41.13:6987/PraneethaOCSproject/getappointmentsbypatient/` + pid);

  }
  getAppointmentsByDoctor(did: string): Observable<Appointment[]> {
    return this._http.get<Appointment[]>(`http://172.21.41.13:6987/PraneethaOCSproject/getappointmentsbydoctor/` + did);
  }
  getAppointmentsByStatus(): Observable<Appointment[]> {
    return this._http.get<Appointment[]>('http://172.21.41.13:6987/PraneethaOCSproject/getappointmentsbystatus/');

  }

  handleError(error) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }
  checkandReqAppointment(pid: string): Observable<Number> {

    return this._http.get<Number>(`http://172.21.41.13:6987/PraneethaOCSproject/checkandReqAppointment/` + pid)

  }

}

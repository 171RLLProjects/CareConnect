import { Patient } from "./patient";
import { Doctor } from "./doctor";

export class Appointment {
    appointmentId: string;
    appointmentDate: string;
status :string;
patient: Patient;
doctor: Doctor;
}

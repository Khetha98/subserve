import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface ContactRequest {
  fullName: string;
  contactInfo: string;
  serviceCategory: string;
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private apiUrl = 'http://localhost:9091/api/v1/contact/send';

  constructor(private http: HttpClient) {}

  sendInquiry(data: ContactRequest): Observable<any> {
    // Request text response to avoid JSON parsing hangups
    return this.http.post(this.apiUrl, data, { responseType: 'text' });
  }
}
import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlShortnerService {
  serviceUrl: string = '';
  constructor(private http: HttpClient) {
    this.serviceUrl = "http://localhost:8080/api";
  }

  generateShortUrl(url: string) {
    this.http.post<any>(this.serviceUrl, url).subscribe(
      res => {
        console.log("Hello here");
      }, err => {
        console.log("HEHHEHHEHHEH")
      });
  }

  generateShortUrl2(url: string) {
    this.http.post<any>(this.serviceUrl, url).subscribe({ 
      next: (res) => { console.log("Next")},
     error: (err) => { console.log("Error") },
    complete : ()=>{ console.log("Complete")} });

  }

}
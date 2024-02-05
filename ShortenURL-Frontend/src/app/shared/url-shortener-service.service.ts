import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UrlShortnerService {
  serviceUrl: string = '';
  constructor(private http: HttpClient) {
    this.serviceUrl = "http://localhost:8080/url/shortner";
  }

  generateShortUrl(url: string) {
    return this.http.post<any>(this.serviceUrl, url);
  }

  generateShortUrl2(url: string) {
    this.http.post<any>(this.serviceUrl, url)

  }

}
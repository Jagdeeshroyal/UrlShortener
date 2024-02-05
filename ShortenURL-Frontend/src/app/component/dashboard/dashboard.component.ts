import { Component } from '@angular/core';
import { UrlShortnerService } from 'src/app/shared/url-shortener-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  url: string = "";
  shortUrl: string = "";
  isValidUrl: boolean = true;

  constructor(private urlShortServ: UrlShortnerService) { }

  ngOnInIt(): void {

  }

  generateShortUrl() {
    this.urlShortServ.generateShortUrl(this.url).subscribe({
      next: (res) => {
        if (res.status === "SUCCESS") {
          this.shortUrl = res.url.shortenUrl;
          this.url = res.url.originalUrl;
          this.isValidUrl = true;
        } else {
          this.isValidUrl = false;
        }
      },
      error: (err) => {
        this.isValidUrl = false;
      }
    });;


  }
}

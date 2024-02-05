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
  isValidUrl: boolean = false;

  constructor(private urlShortServ: UrlShortnerService) { }

  ngOnInIt(): void {

  }

  generateShortUrl() {
    console.log("IN");
    this.urlShortServ.generateShortUrl2(this.url);
    // .subscribe({
    //   next: (res) => {
    //     console.log("jaggu");
    //     if (res.status === "SUCCESS") {
    //       console.log("jaggu");
    //       this.shortUrl = res.url.shortenUrl;
    //       this.isValidUrl = true;
    //     } else {
    //       this.isValidUrl = false;
    //       console.log("fail");

    //     }
    //   }, error: (err) => {
    //     this.isValidUrl = false;
    //   }, complete() {
    //       console.log("Completed");
    //   },
    // });

  }
}

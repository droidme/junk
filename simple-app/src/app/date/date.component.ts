import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'app-date',
  templateUrl: './date.component.html',
  styleUrls: ['./date.component.css']
})
export class DateComponent implements OnInit {

  private timestamp: number;

  constructor() { 
    this.timestamp = 0;
  }

  ngOnInit() {
    Observable.interval(1000)
      .timestamp()
      .map( t => t.timestamp)
      .subscribe( ts => this.timestamp = ts);
  }

}

import { Observable } from 'rxjs/Rx';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-canvas',
  templateUrl: './canvas.component.html',
  styleUrls: ['./canvas.component.css']
})
export class CanvasComponent implements OnInit {

  @Input() id: string;
  @Input() width: number;
  @Input() height: number;

  constructor() { }

  ngOnInit() {
    const box = document.querySelector('canvas');
    Observable.fromEvent(box, 'mousemove')
      .throttleTime(200)
      .subscribe(
        event => console.log(event)
      );
  }

}
